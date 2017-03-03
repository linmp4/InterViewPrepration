package interviewpre.linmp4.com.interviewpre.Util;


import android.content.Context;
import android.os.Handler;
import android.widget.Toast;


public class ToastUtil {

    private static Toast mToast;
    private static Handler mhandler = new Handler();
    private static Toast Networktoast;

    public static void makeText(final Context ctx, final String text) {
        mhandler.post(new Runnable() {
            @Override
            public void run() {
                if (mToast == null) {
                    mToast = Toast.makeText(ctx, text, Toast.LENGTH_LONG);
                } else {
                    mToast.setText(text);
                    mToast.setDuration(Toast.LENGTH_LONG);
                }
                mToast.show();
            }
        });
    }

    public static void cancelToast() {
        mhandler.post(new Runnable() {
            @Override
            public void run() {
                if (mToast != null) {
                    mToast.cancel();
                }
            }
        });
    }
}
