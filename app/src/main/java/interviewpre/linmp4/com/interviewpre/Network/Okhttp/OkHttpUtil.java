package interviewpre.linmp4.com.interviewpre.Network.Okhttp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import interviewpre.linmp4.com.interviewpre.Network.HttpListener;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {

    private static OkHttpUtil mInstance;
    private static OkHttpClient mOkHttpClient;
    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    private OkHttpUtil() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
        }
    }

    private static OkHttpUtil initClient() {
        if (mInstance == null) {
            synchronized (OkHttpUtil.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpUtil();
                }
            }
        }
        return mInstance;
    }

    private static OkHttpUtil getInstance() {
        return initClient();
    }

    static void getAsyn(Context context, String url, HttpListener listener) {
        getInstance()._getAsyn((Activity) context, url, listener);
    }

    static void postAsyn(Context context, String url, LinkedHashMap<String, String> formBody, HttpListener listener) {
        getInstance()._postAsyn((Activity) context, url, formBody, listener);
    }

    /**
     * get异步请求
     */
    private static void _getAsyn(final Activity context, final String url, final HttpListener listener) {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        Call mcall = mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                if (context == null || context.isDestroyed() || context.isFinishing())
                    return;
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null)
                            listener.callback(url, -1, e.getMessage());

                        ToastUtil.makeText(context, "网络异常");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final int code = response.code();
                final String body = response.body().string();

                if (context == null || context.isDestroyed() || context.isFinishing())
                    return;
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null)
                            listener.callback(url, code, body);
                    }
                });
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
    private void _postAsyn(final Activity context, final String url, LinkedHashMap<String, String> formMap, final HttpListener listener) {
        FormBody.Builder temp = new FormBody.Builder();
        for (final Map.Entry<String, String> entry : formMap.entrySet()) {
            temp.add(entry.getKey(), entry.getValue());
        }
        RequestBody formBody = temp.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                if (context == null || context.isDestroyed() || context.isFinishing())
                    return;
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null)
                            listener.callback(url, -1, e.getMessage());

                        ToastUtil.makeText(context, "网络异常");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final int code = response.code();
                final String body = response.body().string();

                if (context == null || context.isDestroyed() || context.isFinishing())
                    return;
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null)
                            listener.callback(url, code, body);
                    }
                });
            }

        });
    }

    /**
     * 异步上传文件
     */

    private void postAsynFile() {
        File file = new File("/sdcard/wangshu.txt");
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("wangshu", response.body().string());
            }
        });
    }


    /**
     * 异步下载文件
     */
    private void downAsynFile() {
        String url = "https://www.baidu.com/img/baidu_jgylogo3.gif";
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) {
                InputStream inputStream = response.body().byteStream();
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(new File("/sdcard/wangshu.jpg"));
                    byte[] buffer = new byte[2048];
                    int len = 0;
                    while ((len = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                    fileOutputStream.flush();
                } catch (IOException e) {
                    Log.i("wangshu", "IOException");
                    e.printStackTrace();
                }

                Log.d("wangshu", "文件下载成功");
            }
        });
    }

    private void sendMultipart() {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("title", "wangshu")
                .addFormDataPart("image", "wangshu.jpg",
                        RequestBody.create(MEDIA_TYPE_PNG, new File("/sdcard/wangshu.jpg")))
                .build();

        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + "...")
                .url("https://api.imgur.com/3/image")
                .post(requestBody)
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("wangshu", response.body().string());
            }
        });
    }
}
