package interviewpre.linmp4.com.interviewpre.Network.Volley;

import android.app.Activity;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.LinkedHashMap;
import java.util.Map;

import interviewpre.linmp4.com.interviewpre.MyApplication;
import interviewpre.linmp4.com.interviewpre.Network.Okhttp.HttpListener;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

class VolleyUtil {

    static void getAsyn(Context context, String url, HttpListener listener) {
        _getAsyn((Activity) context, url, listener);
    }

    static void postAsyn(Context context, String url, LinkedHashMap<String, String> formBody, HttpListener listener) {
        _postAsyn((Activity) context, url, formBody, listener);
    }

    static void postAsyn() {
        _StopAll();
    }

    private static void _StopAll() {
        MyApplication.getHttpQueues().cancelAll(MyApplication.requestTag);
    }

    /**
     * get异步请求
     *
     * @param context
     * @param url
     * @param listener
     */
    private static void _getAsyn(final Activity context, final String url, final HttpListener listener) {
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (listener != null)
                            listener.callback(url, 200, response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (listener != null)
                            listener.callback(url, -1, error.getMessage());

                        ToastUtil.makeText(context, "网络异常");
                    }
                }
        );
        request.setTag(MyApplication.requestTag);
        MyApplication.getHttpQueues().add(request);
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
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (listener != null)
                            listener.callback(url, 200, response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (listener != null)
                            listener.callback(url, -1, error.getMessage());

                        ToastUtil.makeText(context, "网络异常");
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return formMap;
            }
        };
        request.setTag(MyApplication.requestTag);
        MyApplication.getHttpQueues().add(request);
    }


}
