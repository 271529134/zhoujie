package glide.zj.com.dialogfragmentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements EditInputListener{

    @BindView(R.id.edit_dialog)
    Button mEditDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.edit_dialog, R.id.edit_bundle_dialog, R.id.edit_activity_bundle_dialog,
    R.id.edit_alert_dialog})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_dialog:
                editDialog();
                break;
            case R.id.edit_bundle_dialog:
                editBundleDialog();
                break;
            case R.id.edit_activity_bundle_dialog:
                editActivityBundleDialog();
                break;
            case R.id.edit_alert_dialog:
                editAlertDialog();
                break;
        }
    }

    /**
     * 展示dialog
     */
    private void editDialog() {
        EditDialogFragment dialogFragment = new EditDialogFragment();
        dialogFragment.show(getFragmentManager(), "editdialog");
    }

    /**
     * 传值到dialogfragment
     */
    private void editBundleDialog() {
        EditDialogFragment dialogFragment = EditDialogFragment.getIntent("so -- easy");
        dialogFragment.show(getFragmentManager(), "editdialog");
    }

    /**
     * dialogfragment传值到activty
     */
    private void editActivityBundleDialog() {
        EditDialogFragment dialogFragment = EditDialogFragment.getIntent("so -- easy");
        dialogFragment.show(getFragmentManager(), "editdialog");
        dialogFragment.setEditInputListener(this);
    }

    /**
     * 利用alertDialog创建对话框
     */
    private void editAlertDialog(){
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        alertDialogFragment.show(getFragmentManager(), "alertdialog");
    }

    @Override
    public void bundleStr(String strEdit) {
        Toast.makeText(MainActivity.this, "传值===》" + strEdit, Toast.LENGTH_LONG).show();
    }
}
