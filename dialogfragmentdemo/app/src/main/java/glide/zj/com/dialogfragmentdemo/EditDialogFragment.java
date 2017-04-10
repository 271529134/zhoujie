package glide.zj.com.dialogfragmentdemo;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by zhoujie on 2017/4/10.
 */

public class EditDialogFragment extends DialogFragment {

    public static String STR_EDIT = "str_edit";
    @BindView(R.id.dialog_edittext)
    EditText mDialogEdittext;
    @BindView(R.id.dialog_button)
    Button mDialogButton;
    Unbinder unbinder;

    EditInputListener editInputListener;

    public static EditDialogFragment getIntent(String strEdit) {
        EditDialogFragment editDialogFragment = new EditDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(STR_EDIT, strEdit);
        editDialogFragment.setArguments(bundle);
        return editDialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);  //去掉标题
        getDialog().getWindow().setWindowAnimations(
                R.style.DialogAnimation);              //设置动画
        getDialog().setCanceledOnTouchOutside(false);  //触摸边缘不消失
        View view = inflater.inflate(R.layout.dialog_layout, container);
        unbinder = ButterKnife.bind(this, view);
        if (getArguments() != null) {
            mDialogEdittext.setText(getArguments().getString(STR_EDIT));
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = DensityUtils.getScreenWidth(getActivity());
        params.height = DensityUtils.getScreenHeight(getActivity()) / 4;
        getDialog().getWindow().setAttributes(params);
    }

    @OnClick(R.id.dialog_button)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_button:
                if(getEditInputListener() != null){
                    editInputListener.bundleStr(mDialogEdittext.getText().toString());
                }
                getDialog().dismiss();
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public EditInputListener getEditInputListener() {
        return editInputListener;
    }

    public void setEditInputListener(EditInputListener editInputListener) {
        this.editInputListener = editInputListener;
    }
}
