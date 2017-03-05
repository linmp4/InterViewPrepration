package interviewpre.linmp4.com.interviewpre.Network;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import interviewpre.linmp4.com.interviewpre.BaseActivity;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;

public class BaseNetworkActivity extends BaseActivity {

    public static final String baseGetHead = "http://api.fir.im/";
    public static final String baseGetFoot = "apps/latest/5881b8c0959d691f5c00044c?api_token=e0be056f9e2f0e9623c5dd69b32e488c";

    public static final String basePostHead = "http://web.juhe.cn:8080/";
    public static final String basePostFoot = "constellation/getAll";

    public static final String baseGetUrl = baseGetHead + baseGetFoot;
    public static final String basePostUrl = basePostHead + basePostFoot;

    public final LinkedHashMap<String, String> map = new LinkedHashMap<String, String>() {{
        put("consName", "天秤座");
        put("type", "today");
        put("key", "b68175b4019546b7272af37737e543c4");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_volley);
        super.onCreate(savedInstanceState);

        ListView listView = (ListView) findViewById(R.id.lv_view);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos) {
                    case 0:
                        getAsynHttp();
                        break;
                    case 1:
                        postAsynHttp();
                        break;
                }
            }
        });
        StringCheck.setListViewHeightBasedOnChildren(listView);
    }


    private List getData() {
        List<String> data = new ArrayList<String>();
        data.add("GET方法");
        data.add("POST方法");
        return data;
    }

    public void getAsynHttp() {
    }


    public void postAsynHttp() {
    }


}
