package interviewpre.linmp4.com.interviewpre.Event.Otto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import interviewpre.linmp4.com.interviewpre.Event.MessageEvent;
import interviewpre.linmp4.com.interviewpre.R;

public class SecondOttoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_even);

        ((TextView)findViewById(R.id.tv_info)).setText("当前Activity未注册Otto通知，ThreadEnforcer.ANY" +
                "可以在任何线程发送和接收通知,ThreadEnforcer.MAIN只能在主线程发送和接收,否则报错。所以这个框架比较专注于更新界面。");

        findViewById(R.id.bt_main_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusProvider.getInstance2().post(new MessageEvent("来自第二个页面的主线程通知"));
            }
        });
        findViewById(R.id.bt_thread_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        BusProvider.getInstance2().post(new MessageEvent("来自第二个页面的子线程通知"));
                    }
                }.start();
            }
        });
    }

}
