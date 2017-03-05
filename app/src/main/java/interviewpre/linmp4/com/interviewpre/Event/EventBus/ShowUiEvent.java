package interviewpre.linmp4.com.interviewpre.Event.EventBus;

class ShowUiEvent {

    public String threadMode;
    public String ThreadName;
    public String message;

    ShowUiEvent(String threadMode, String ThreadName, String message) {
        this.threadMode = threadMode;
        this.ThreadName = ThreadName;
        this.message = message;
    }
}
