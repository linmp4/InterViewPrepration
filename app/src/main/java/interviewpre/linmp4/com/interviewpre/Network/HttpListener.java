package interviewpre.linmp4.com.interviewpre.Network;

public interface HttpListener {
    public void callback(String url, int code, String response);
}