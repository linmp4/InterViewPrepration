package interviewpre.linmp4.com.interviewpre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private class MainModel {
        private String title;
        private Class ActClass;

        MainModel(String title, Class ActClass) {
            this.title = title;
            this.ActClass = ActClass;
        }
    }

    List<MainModel> mainModel = new ArrayList<MainModel>() {{
        add(new MainModel("Volley", VolleyActivity.class));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

        ListView listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        setContentView(listView);
//        setContentView(R.layout.activity_main);
    }

    private void initData() {

    }

    private List getData() {
        List<String> data = new ArrayList<>();
        for (MainModel m : mainModel)
            data.add(m.title);
        return data;
    }
}
