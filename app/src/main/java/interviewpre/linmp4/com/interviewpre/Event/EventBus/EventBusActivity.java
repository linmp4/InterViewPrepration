package interviewpre.linmp4.com.interviewpre.Event.EventBus;

import android.content.Intent;
import android.os.Bundle;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import interviewpre.linmp4.com.interviewpre.Event.BaseEvenActivity;
import interviewpre.linmp4.com.interviewpre.Event.MessageEvent;

public class EventBusActivity extends BaseEvenActivity {

    private String code = "" +
            "//定义一个消息类\n" +
            "public class MessageEvent {\n" +
            "    private String message;\n" +
            "\n" +
            "    public MessageEvent(String txt) {\n" +
            "        this.message = txt;\n" +
            "    }\n" +
            "\n" +
            "    public String getMessage() {\n" +
            "        return message;\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "//注册\n" +
            "EventBus.getDefault().register(this);\n" +
            "\n" +
            "//反注册\n" +
            "EventBus.getDefault().unregister(this);\n" +
            "\n" +
            "//发送普通通知\n" +
            "EventBus.getDefault().post(new MessageEvent(text));\n" +
            "\n" +
            "//发送粘性通知\n" +
            "EventBus.getDefault().postSticky(new MessageEvent(text));\n" +
            "\n" +
            "@Subscribe(threadMode = ThreadMode.PostThread)\n" +
            "public void onMessageEventPostThread(MessageEvent messageEvent){\n" +
            "}\n" +
            "\n" +
            "//在UI线程中执行\n" +
            "@Subscribe(threadMode = ThreadMode.MainThread, sticky = true)\n" +
            "public void onMessageEventMainThread(MessageEvent messageEvent){\n" +
            "}\n" +
            "\n" +
            "//如果产生事件的是UI线程，则在新的线程中执行。如果产生事件的是非UI线程，则在产生事件的线程中执行\n" +
            "@Subscribe(threadMode = ThreadMode.BackgroundThread)\n" +
            "public void onMessageEventBackgroundThread(MessageEvent messageEvent){\n" +
            "}\n" +
            "\n" +
            "//无论产生事件的是否是UI线程，都在新的线程中执行\n" +
            "@Subscribe(threadMode = ThreadMode.Async)\n" +
            "public void onMessageEventAsync(MessageEvent messageEvent){\n" +
            "}\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void next_act() {
        startActivity(new Intent(this, SecondeEventBusActivity.class));
    }

    //在产生事件的线程中执行
    @Subscribe(threadMode = ThreadMode.PostThread)
    public void onMessageEventPostThread(MessageEvent messageEvent) {
        EventBus.getDefault().post(new ShowUiEvent("PostThread", Thread.currentThread().getName(), messageEvent.getMessage()));
    }

    //在UI线程中执行
    @Subscribe(threadMode = ThreadMode.MainThread, sticky = true)
    public void onMessageEventMainThread(MessageEvent messageEvent) {
        String temp = "threadMode:MainThread 当前线程名:" + Thread.currentThread().getName() + " 消息内容:" + messageEvent.getMessage();
        showText(temp);
    }

    //如果产生事件的是UI线程，则在新的线程中执行。如果产生事件的是非UI线程，则在产生事件的线程中执行
    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onMessageEventBackgroundThread(MessageEvent messageEvent) {
        EventBus.getDefault().post(new ShowUiEvent("BackgroundThread", Thread.currentThread().getName(), messageEvent.getMessage()));
    }

    //无论产生事件的是否是UI线程，都在新的线程中执行
    @Subscribe(threadMode = ThreadMode.Async)
    public void onMessageEventAsync(MessageEvent messageEvent) {
        EventBus.getDefault().post(new ShowUiEvent("Async", Thread.currentThread().getName(), messageEvent.getMessage()));
    }

    //在UI线程中执行
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void updateUI(ShowUiEvent messageEvent) {
        String temp = "threadMode:" + messageEvent.threadMode + " 当前线程名:" + messageEvent.ThreadName + " 消息内容:" + messageEvent.message;
        showText(temp);
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void clear(ClearTextEvent messageEvent) {
        clearText();
    }

    @Override
    public void normal_send(String text) {
        clearText();
        EventBus.getDefault().post(new MessageEvent(text));
    }

    @Override
    public void sticky_send(String text) {
        clearText();
        EventBus.getDefault().postSticky(new MessageEvent(text));
    }

    @Override
    public void register() {
        if (EventBus.getDefault().isRegistered(this)) {
            showText("不可重复注册");
        } else {
            showText("注册成功");
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void unregister() {
        showText("反注册成功");
        EventBus.getDefault().unregister(this);
    }

    @Override
    public String getCode() {
        return code;
    }
}
