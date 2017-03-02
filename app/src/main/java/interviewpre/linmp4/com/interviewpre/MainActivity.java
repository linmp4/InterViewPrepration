package interviewpre.linmp4.com.interviewpre;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import interviewpre.linmp4.com.interviewpre.Model.MainModel;

public class MainActivity extends BaseActivity {

    List<MainModel> mainModel = new ArrayList<MainModel>() {{
        add(new MainModel("Volley", VolleyActivity.class));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                startActivity(new Intent(getAQuery().getContext(), mainModel.get(pos).ActClass));
            }
        });
        setContentView(listView);
    }

    public static String getRunningActivityName(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        String runningActivity = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
        return runningActivity.substring(0, runningActivity.lastIndexOf(".") + 1);
    }


    private List getData() {
        List<String> data = new ArrayList<>();
        for (MainModel m : mainModel)
            data.add(m.title);
        return data;
    }
}
