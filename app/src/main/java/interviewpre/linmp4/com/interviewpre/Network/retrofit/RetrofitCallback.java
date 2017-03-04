package interviewpre.linmp4.com.interviewpre.Network.retrofit;

import java.io.IOException;

import interviewpre.linmp4.com.interviewpre.Network.Okhttp.HttpListener;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class RetrofitCallback implements Callback<ResponseBody> {

    private HttpListener listener;

    RetrofitCallback(HttpListener listener) {
        this.listener = listener;
    }

    @Override
    public void onResponse(Call call, Response response) {
        int code = response.code();
        String body = null;
        try {
            body = ((ResponseBody) response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = response.raw().request().url().toString();
        if (listener != null)
            listener.callback(url, code, body);
    }

    @Override
    public void onFailure(Call call, final Throwable t) {
        final String url = call.request().url().toString();
        if (listener != null)
            listener.callback(url, -1, t.getMessage());
    }
}