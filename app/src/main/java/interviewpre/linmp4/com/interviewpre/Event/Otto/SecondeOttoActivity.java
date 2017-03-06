package interviewpre.linmp4.com.interviewpre.Event.Otto;

import interviewpre.linmp4.com.interviewpre.Event.MessageEvent;
import interviewpre.linmp4.com.interviewpre.Event.SecondeEventActivity;

public class SecondeOttoActivity extends SecondeEventActivity {

    @Override
    public void setContent(String ctx) {
        super.setContent("当前Activity未注册Otto通知，ThreadEnforcer.ANY" +
                "可以在任何线程发送和接收通知,ThreadEnforcer.MAIN只能在主线程发送和接收,否则报错。所以这个框架比较专注于更新界面。");
    }

    @Override
    public void main_send() {
        BusProvider.getInstance2().post(new MessageEvent("来自第二个页面的主线程通知"));
    }

    @Override
    public void thread_send() {
        BusProvider.getInstance2().post(new MessageEvent("来自第二个页面的子线程通知"));
    }
}
