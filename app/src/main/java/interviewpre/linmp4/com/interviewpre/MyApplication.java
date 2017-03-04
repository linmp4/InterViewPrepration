package interviewpre.linmp4.com.interviewpre;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application {
    public static RequestQueue queues;
    public static String requestTag = "volley";

    @Override
    public void onCreate() {
        super.onCreate();
        queues = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpQueues() {
        return queues;
    }
}
