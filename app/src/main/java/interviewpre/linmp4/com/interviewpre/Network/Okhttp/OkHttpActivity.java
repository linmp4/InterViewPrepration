package interviewpre.linmp4.com.interviewpre.Network.Okhttp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.UI.BaseActivity;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class OkHttpActivity extends BaseActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        listView = (ListView) findViewById(R.id.lv_view);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos) {
                    case 0:
                        getAsynHttp();
                        break;
                }
            }
        });
        StringCheck.setListViewHeightBasedOnChildren(listView);
    }


    private List getData() {
        List<String> data = new ArrayList<String>();
        data.add("get方法");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据4");
        return data;
    }

    private void getAsynHttp() {
        getdefaultpd().showDialog();
        String url = "http://api.fir.im/apps/latest/5881b8c0959d691f5c00044c?api_token=e0be056f9e2f0e9623c5dd69b32e488c";
        OkHttpUtil.getAsyn(getAQuery().getContext(), url, new OkHttpUtil.HttpListener() {
            @Override
            public void callback(String url, int code, String response) {
                getdefaultpd().dismissDialog();
                UpdateUI(response, code, url);
            }
        });
    }

    private void UpdateUI(String response, int code, String url) {
        String temp = null;
        try {
            temp = StringCheck.Tojson(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (temp == null) {
            ToastUtil.makeText(getAQuery().getContext(), "json格式错误");
        } else {
            temp = "请求连接：" + url + "\n状态码：+" + code + "\n\n" + temp;
            getAQuery().id(R.id.tv_code).text(temp);
        }
    }


}
