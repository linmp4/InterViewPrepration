package interviewpre.linmp4.com.interviewpre;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApplication extends Application {
    public static RequestQueue queues;
    public static String requestTag = "volley";

    @Override
    public void onCreate() {
        super.onCreate();
        queues = Volley.newRequestQueue(getApplicationContext());
        Fresco.initialize(this);
    }

    public static RequestQueue getHttpQueues() {
        return queues;
    }
}
