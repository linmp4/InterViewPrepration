package interviewpre.linmp4.com.interviewpre.Cache.ASimpleCache;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.BaseActivity;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class BaseASimpleActivity extends BaseActivity {

    public EditText mEt_string_input;
    public TextView mTv_string_res;

    private ACache mCache;
    public ImageView iv_bitmap_save;
    public ImageView iv_bitmap_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_string);
        // 初始化控件
        initView();

        initGobalUI();
    }

    public ACache getACache() {
        if (mCache == null) {
            synchronized (BaseActivity.class) {
                if (mCache == null) {
                    mCache = ACache.get(this);
                }
            }
        }
        return mCache;
    }

    public void initGobalUI() {
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mEt_string_input = (EditText) findViewById(R.id.et_string_input);
        mTv_string_res = (TextView) findViewById(R.id.tv_string_res);
        iv_bitmap_save = (ImageView) findViewById(R.id.iv_bitmap_save);
        iv_bitmap_res = (ImageView) findViewById(R.id.iv_bitmap_res);
        getAQuery().id(R.id.bt_save).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
        getAQuery().id(R.id.bt_read).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                read();
            }
        });
        getAQuery().id(R.id.bt_clear).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
    }

    public void save() {
        ToastUtil.makeText(this,"保存成功");
    }

    public void read() {
    }

    public void clear() {
    }

}
