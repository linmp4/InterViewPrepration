package interviewpre.linmp4.com.interviewpre.UI;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import interviewpre.linmp4.com.interviewpre.Model.ContextModel;
import interviewpre.linmp4.com.interviewpre.Model.MainModel;
import interviewpre.linmp4.com.interviewpre.Network.Okhttp.OkHttpActivity;
import interviewpre.linmp4.com.interviewpre.Network.Volley.VolleyActivity;
import interviewpre.linmp4.com.interviewpre.Network.retrofit.RetrofitActivity;
import interviewpre.linmp4.com.interviewpre.UI.Material.ui.activity.MaterialActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MainModel model1 =
                new MainModel("网络框架", ListActivity.class, new ContextModel(new ArrayList<MainModel>() {{
                    add(new MainModel("OkHttp3", OkHttpActivity.class));
                    add(new MainModel("Retrofit2", RetrofitActivity.class));
                    add(new MainModel("Volley", VolleyActivity.class));
                }}));

        final MainModel model2 =
                new MainModel("UI框架", ListActivity.class, new ContextModel(new ArrayList<MainModel>() {{
                    add(new MainModel("Material Design", MaterialActivity.class));
                }}));


        ContextModel ctx = new ContextModel(new ArrayList<MainModel>() {{
            add(model1);
            add(model2);
        }});

        startActivity(new Intent(this, ListActivity.class).putExtra("Content", ctx));
        finish();
    }

}
