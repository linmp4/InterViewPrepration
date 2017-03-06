package interviewpre.linmp4.com.interviewpre.Event.Otto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.squareup.otto.Subscribe;

import interviewpre.linmp4.com.interviewpre.Event.BaseEvenActivity;
import interviewpre.linmp4.com.interviewpre.Event.MessageEvent;
import interviewpre.linmp4.com.interviewpre.R;

public class OttoActivity extends BaseEvenActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BusProvider.getInstance().register(this);
        BusProvider.getInstance2().register(this);
        getAQuery().id(R.id.ll_ctx).visibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
        BusProvider.getInstance2().unregister(this);
    }

    @Override
    public void next_act() {
        startActivity(new Intent(this, SecondOttoActivity.class));
    }

    @Subscribe
    public void sayGoodOnEvent(MessageEvent messageEvent) {
        final String temp = "当前线程名:" + Thread.currentThread().getName() + " 消息内容:" + messageEvent.getMessage();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                clearText();
                showText(temp);
            }
        });
    }

    @Override
    public void register() {
        showText("注册成功");
        BusProvider.getInstance().register(this);
        BusProvider.getInstance2().register(this);
    }

    @Override
    public void unregister() {
        showText("反注册成功");
        BusProvider.getInstance().unregister(this);
        BusProvider.getInstance2().unregister(this);
    }
}
