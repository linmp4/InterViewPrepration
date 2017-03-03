package interviewpre.linmp4.com.interviewpre.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import interviewpre.linmp4.com.interviewpre.Model.ContextModel;
import interviewpre.linmp4.com.interviewpre.Model.MainModel;

public class ListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ContextModel m = (ContextModel) getIntent().getSerializableExtra("Content");
        if (m != null && m.mainModel != null) {
            ListView listView = new ListView(this);
            listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData(m.mainModel)));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                    MainModel temp = m.mainModel.get(pos);
                    Intent intent = new Intent(getAQuery().getContext(), temp.ActClass);
                    if (temp.model != null)
                        intent.putExtra("Content", temp.model);
                    startActivity(intent);
                }
            });
            setContentView(listView);
        }
    }

    private List getData(List<MainModel> mainModel) {
        List<String> data = new ArrayList<>();
        for (MainModel m : mainModel)
            data.add(m.title);
        return data;
    }
}
