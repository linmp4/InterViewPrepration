package interviewpre.linmp4.com.interviewpre.Event.EventBus;

class MessageEvent {

    private String message;

    MessageEvent(String txt) {
        this.message = txt;
    }

    String getMessage() {
        return message;
    }
}
