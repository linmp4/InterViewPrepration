package interviewpre.linmp4.com.interviewpre.UI;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import interviewpre.linmp4.com.interviewpre.BaseActivity;
import interviewpre.linmp4.com.interviewpre.Cache.ASimpleCache.ASimpleCacehActivity;
import interviewpre.linmp4.com.interviewpre.Model.ContextModel;
import interviewpre.linmp4.com.interviewpre.Model.MainModel;
import interviewpre.linmp4.com.interviewpre.Network.Okhttp.OkHttpActivity;
import interviewpre.linmp4.com.interviewpre.Network.Volley.VolleyActivity;
import interviewpre.linmp4.com.interviewpre.Network.android_async_http.AsyncHttpActivity;
import interviewpre.linmp4.com.interviewpre.Network.retrofit.RetrofitActivity;
import interviewpre.linmp4.com.interviewpre.Picture.Fresco.FrescoActivity;
import interviewpre.linmp4.com.interviewpre.Picture.Glide.GlideActivity;
import interviewpre.linmp4.com.interviewpre.Picture.Picasso.PicassoActivity;
import interviewpre.linmp4.com.interviewpre.UI.Material.ui.activity.MaterialActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MainModel model1 =
                new MainModel("网络框架", GobalListActivity.class, new ContextModel(new ArrayList<MainModel>() {{
                    add(new MainModel("OkHttp3", OkHttpActivity.class));
                    add(new MainModel("Retrofit2", RetrofitActivity.class));
                    add(new MainModel("Volley", VolleyActivity.class));
                    add(new MainModel("android-async-http", AsyncHttpActivity.class));
                }}));

        final MainModel model2 =
                new MainModel("图片加载框架", GobalListActivity.class, new ContextModel(new ArrayList<MainModel>() {{
                    add(new MainModel("Glide", GlideActivity.class));
                    add(new MainModel("Picasso", PicassoActivity.class));
                    add(new MainModel("Fresco", FrescoActivity.class));
                }}));

        final MainModel model3 =
                new MainModel("UI框架", GobalListActivity.class, new ContextModel(new ArrayList<MainModel>() {{
                    add(new MainModel("Material Design", MaterialActivity.class));
                }}));

        final MainModel model4 =
                new MainModel("缓存框架", GobalListActivity.class, new ContextModel(new ArrayList<MainModel>() {{
                    add(new MainModel("ASimpleCache", ASimpleCacehActivity.class));
                }}));


        ContextModel ctx = new ContextModel(new ArrayList<MainModel>() {{
            add(model1);
            add(model2);
            add(model3);
            add(model4);
        }});

        startActivity(new Intent(this, GobalListActivity.class).putExtra("Content", ctx));
        finish();
    }

}
