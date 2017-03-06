package interviewpre.linmp4.com.interviewpre.Event;

import android.os.Bundle;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

import interviewpre.linmp4.com.interviewpre.BaseActivity;
import interviewpre.linmp4.com.interviewpre.R;

public class BaseEvenActivity extends BaseActivity {

    private String totalText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_even);
        super.onCreate(savedInstanceState);

        InitUI();
    }

    public void InitUI() {
        getAQuery().id(R.id.bt_normal_send).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normal_send(getAQuery().id(R.id.et_send).getText().toString());
            }
        });
        getAQuery().id(R.id.bt_sticky_send).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sticky_send(getAQuery().id(R.id.et_send).getText().toString());
            }
        });
        getAQuery().id(R.id.bt_register).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
        getAQuery().id(R.id.bt_unregister).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unregister();
            }
        });
        getAQuery().id(R.id.bt_next_act).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_act();
            }
        });
    }

    public void next_act() {
    }

    public void unregister() {
    }

    public void register() {
    }

    public void sticky_send(String text) {
    }

    public void normal_send(String text) {
    }

    public void clearText() {
        totalText = "";
    }

    public void showText(String temp) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        totalText = str + " :\n" + temp + "\n\n" + totalText;
        getAQuery().id(R.id.tv_code).text(totalText);
    }

}
