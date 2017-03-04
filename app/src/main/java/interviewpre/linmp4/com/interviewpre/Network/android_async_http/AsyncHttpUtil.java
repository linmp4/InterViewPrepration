package interviewpre.linmp4.com.interviewpre.Network.android_async_http;

import android.app.Activity;
import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import java.util.LinkedHashMap;
import java.util.Map;

import interviewpre.linmp4.com.interviewpre.Network.HttpListener;

class AsyncHttpUtil {

    static void getAsyn(Context context, String url, HttpListener listener) {
        _getAsyn((Activity) context, url, listener);
    }

    static void postAsyn(Context context, String url, LinkedHashMap<String, String> formBody, HttpListener listener) {
        _postAsyn((Activity) context, url, formBody, listener);
    }

    /**
     * get异步请求
     *
     * @param context
     * @param url
     * @param listener
     */
    private static void _getAsyn(final Activity context, final String url, final HttpListener listener) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        client.get(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (listener != null)
                    listener.callback(url, statusCode, new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (listener != null)
                    listener.callback(url, statusCode, error.getMessage());
            }
        });
    }

    /**
     * post异步请求
     *
     * @param context
     * @param url
     * @param formMap
     * @param listener
     */
    private static void _postAsyn(final Activity context, final String url, final LinkedHashMap<String, String> formMap, final HttpListener listener) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        for (final Map.Entry<String, String> entry : formMap.entrySet()) {
            params.add(entry.getKey(), entry.getValue());
        }

        client.get(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (listener != null)
                    listener.callback(url, statusCode, new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (listener != null)
                    listener.callback(url, statusCode, error.getMessage());
            }
        });
    }
}
