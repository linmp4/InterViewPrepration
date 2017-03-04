package interviewpre.linmp4.com.interviewpre.Cache.ASimpleCache;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import interviewpre.linmp4.com.interviewpre.Model.ContextModel;
import interviewpre.linmp4.com.interviewpre.Model.MainModel;
import interviewpre.linmp4.com.interviewpre.UI.BaseActivity;
import interviewpre.linmp4.com.interviewpre.UI.ListActivity;

public class ASimpleCacehActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContextModel ctx = new ContextModel(new ArrayList<MainModel>() {{
            add(new MainModel("String类型", SaveStringActivity.class));
            add(new MainModel("JsonObject类型", SaveJsonObjectActivity.class));
            add(new MainModel("JsonArray类型", SaveJsonArrayActivity.class));
            add(new MainModel("Bitmap类型", SaveBitmapActivity.class));
            add(new MainModel("Object类型", SaveObjectActivity.class));
        }});

        startActivity(new Intent(this, ListActivity.class).putExtra("Content", ctx));
        finish();
    }
}
