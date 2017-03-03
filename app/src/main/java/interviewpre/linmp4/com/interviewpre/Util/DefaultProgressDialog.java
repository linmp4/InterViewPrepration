package interviewpre.linmp4.com.interviewpre.Util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * 自定义loading对话框
 */
public class DefaultProgressDialog {

    private static Context mct;
    private ProgressDialog progressDialog;

    public DefaultProgressDialog(Context context) {
        mct = context;
        progressDialog = new ProgressDialog(mct);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
    }

    public void setCancelable(boolean cancelable) {
        progressDialog.setCancelable(cancelable);
    }

    public void showDialog(String msg) {
        progressDialog.setMessage(msg);
        pdshow();
    }

    public void showDialog() {
        progressDialog.setMessage("加载中");
        pdshow();
    }

    public boolean isShowingDialog() {
        if (progressDialog != null)
            return progressDialog.isShowing();
        else
            return false;
    }

    public void pdSetOnbackPressLister(DialogInterface.OnKeyListener listener) {
        progressDialog.setOnKeyListener(listener);
    }

    private void pdshow() {
        if (progressDialog != null && !progressDialog.isShowing())
            progressDialog.show();
    }

    public void dismissDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
