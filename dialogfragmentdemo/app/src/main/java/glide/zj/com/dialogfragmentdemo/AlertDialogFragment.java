package glide.zj.com.dialogfragmentdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * 使用alertdialog来穿件dialog
 * 这里面的点击事件就不写了这个跟editdiaolgfragment里面一样
 * Created by zhoujie on 2017/4/10.
 */

public class AlertDialogFragment extends DialogFragment{



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_alert_layout, null);
        view.findViewById(R.id.dialog_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }


    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setWindowAnimations(
                R.style.DialogAnimation);              //设置动画
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = DensityUtils.getScreenWidth(getActivity());
        params.height = DensityUtils.getScreenHeight(getActivity()) / 4;
        getDialog().getWindow().setAttributes(params);
    }
}
