package interviewpre.linmp4.com.interviewpre.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import interviewpre.linmp4.com.interviewpre.BaseActivity;
import interviewpre.linmp4.com.interviewpre.Model.ContextModel;
import interviewpre.linmp4.com.interviewpre.Model.MainModel;
import interviewpre.linmp4.com.interviewpre.UI.CodeView.CodeViewActivity;

public class GobalListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ContextModel m = (ContextModel) getIntent().getSerializableExtra("Content");
        if (m != null && m.mainModel != null) {
            ListView listView = new ListView(this);

            listView.setAdapter(new GobalListAdapter(this, m.mainModel) {
                @Override
                void ClickCode(String code) {
                    startActivity(new Intent(getAQuery().getContext(), CodeViewActivity.class).putExtra(CodeViewActivity.CODE, code));
                }
            });

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
}
