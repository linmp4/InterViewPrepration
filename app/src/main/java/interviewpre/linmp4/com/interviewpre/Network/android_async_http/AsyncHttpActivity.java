package interviewpre.linmp4.com.interviewpre.Network.android_async_http;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import interviewpre.linmp4.com.interviewpre.Network.Okhttp.HttpListener;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.UI.BaseActivity;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;

public class AsyncHttpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

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

    private void getAsynHttp() {
        getdefaultpd().showDialog();
        String url = "http://api.fir.im/apps/latest/5881b8c0959d691f5c00044c?api_token=e0be056f9e2f0e9623c5dd69b32e488c";
        AsyncHttpUtil.getAsyn(getAQuery().getContext(), url, new HttpListener() {
            @Override
            public void callback(String url, int code, String response) {
                getdefaultpd().dismissDialog();

                new StringCheck.UpdateUI(response, code, url, null) {
                    @Override
                    public void Success(String temp) {
                        getAQuery().id(R.id.tv_code).text(temp);
                    }
                };
            }
        });
    }


    private void postAsynHttp() {
        getdefaultpd().showDialog();
        String url = "http://web.juhe.cn:8080/constellation/getAll";

        final LinkedHashMap<String, String> map = new LinkedHashMap<String, String>() {{
            put("consName", "天秤座");
            put("type", "today");
            put("key", "b68175b4019546b7272af37737e543c4");
        }};

        AsyncHttpUtil.postAsyn(getAQuery().getContext(), url, map, new HttpListener() {
            @Override
            public void callback(String url, int code, String response) {
                getdefaultpd().dismissDialog();

                new StringCheck.UpdateUI(response, code, url, map) {
                    @Override
                    public void Success(String temp) {
                        getAQuery().id(R.id.tv_code).text(temp);
                    }
                };
            }
        });
    }


}
