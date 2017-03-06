package interviewpre.linmp4.com.interviewpre.Event.EventBus;

import de.greenrobot.event.EventBus;
import interviewpre.linmp4.com.interviewpre.Event.MessageEvent;
import interviewpre.linmp4.com.interviewpre.Event.SecondeEventActivity;

public class SecondeEventBusActivity extends SecondeEventActivity {

    @Override
    public void main_send() {
        EventBus.getDefault().post(new ClearTextEvent());
        EventBus.getDefault().post(new MessageEvent("来自第二页面的主线程"));
    }

    @Override
    public void thread_send() {
        EventBus.getDefault().post(new ClearTextEvent());
        EventBus.getDefault().post(new MessageEvent("来自第二页面的子线程"));
    }
}
