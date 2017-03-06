package interviewpre.linmp4.com.interviewpre.Event.Otto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.squareup.otto.Subscribe;

import interviewpre.linmp4.com.interviewpre.Event.BaseEvenActivity;
import interviewpre.linmp4.com.interviewpre.Event.MessageEvent;
import interviewpre.linmp4.com.interviewpre.R;

public class OttoActivity extends BaseEvenActivity {

    private String code = "" +
            "import com.squareup.otto.Subscribe;\n" +
            "import com.squareup.otto.Bus;\n" +
            "\n" +
            "//初始化BUS,有2种模式\n" +
            "Bus BUS_MAIN = new Bus(ThreadEnforcer.MAIN);\n" +
            "Bus BUS_ANY = new Bus(ThreadEnforcer.ANY);\n" +
            "\n" +
            "//注册bus\n" +
            "BusProvider.getInstance2().register(this);\n" +
            "\n" +
            "//反注册bus\n" +
            "BusProvider.getInstance2().unregister(this);\n" +
            "\n" +
            "//发送通知        \n" +
            "BusProvider.getInstance2().post(new MessageEvent(\"来自第二个页面的主线程通知\"));\n" +
            "\n" +
            "//接收通知\n" +
            "@Subscribe\n" +
            "public void sayGoodOnEvent(MessageEvent messageEvent){\n" +
            "\n" +
            "}\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BusProvider.getInstance2().register(this);
        getAQuery().id(R.id.ll_ctx).visibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance2().unregister(this);
    }

    @Override
    public void next_act() {
        startActivity(new Intent(this, SecondeOttoActivity.class));
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
        BusProvider.getInstance2().register(this);
    }

    @Override
    public void unregister() {
        showText("反注册成功");
        BusProvider.getInstance2().unregister(this);
    }

    @Override
    public String getCode() {
        return code;
    }
}
