package interviewpre.linmp4.com.interviewpre.Event;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import interviewpre.linmp4.com.interviewpre.R;

public class SecondeEventActivity extends Activity {

    private TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_even);

        tv_info = (TextView) findViewById(R.id.tv_info);

        findViewById(R.id.bt_main_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_send();
            }
        });
        findViewById(R.id.bt_thread_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        thread_send();
                    }
                }.start();
            }
        });
    }

    public void setContent(String ctx) {
        tv_info.setText(ctx);
    }

    public void thread_send() {
    }

    public void main_send() {
    }


}
