package interviewpre.linmp4.com.interviewpre.Picture;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.BaseActivity;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;

public class BasePicActivity extends BaseActivity {

    public String picurl = "http://img1.gamersky.com/image2017/02/20170222_szc_364_4/gamersky_04origin_07_2017222175972B.jpg";
    public ImageView iv_pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_picture);
        super.onCreate(savedInstanceState);

        iv_pic = (ImageView) findViewById(R.id.iv_pic);

        InitUI();
    }

    public void InitUI() {
        ListView listView = (ListView) findViewById(R.id.lv_view);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos) {
                    case 0:
                        loadOrginPic();
                        break;
                    case 1:
                        loadRoundPic();
                        break;
                    case 2:
                        clearPic();
                        break;
                }
            }
        });
        StringCheck.setListViewHeightBasedOnChildren(listView);
    }

    private List getData() {
        List<String> data = new ArrayList<String>();
        data.add("加载原图");
        data.add("处理为圆形");
        data.add("清空缓存");
        return data;
    }


    public void loadOrginPic() {
        getAQuery().id(R.id.tv_pic).text("图片地址:\n" + picurl);
    }

    public void loadRoundPic() {
        getAQuery().id(R.id.tv_pic).text("图片地址:\n" + picurl);
    }

    public void clearPic() {
    }

}
