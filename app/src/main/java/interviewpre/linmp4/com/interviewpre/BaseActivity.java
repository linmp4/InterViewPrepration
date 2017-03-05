package interviewpre.linmp4.com.interviewpre;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.androidquery.AQuery;

import interviewpre.linmp4.com.interviewpre.UI.CodeView.CodeViewActivity;
import interviewpre.linmp4.com.interviewpre.Util.DefaultProgressDialog;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class BaseActivity extends AppCompatActivity {

    private AQuery aQuery;
    private DefaultProgressDialog defaultpd;
    public String ActionBartitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBartitle = getIntent().getStringExtra("ActionBartitle");
        if (!StringCheck.isEmpty(ActionBartitle))
            getSupportActionBar().setTitle(ActionBartitle);
    }

    public AQuery getAQuery() {
        if (aQuery == null) {
            synchronized (BaseActivity.class) {
                if (aQuery == null) {
                    aQuery = new AQuery(this);
                }
            }
        }
        return aQuery;
    }

    public DefaultProgressDialog getdefaultpd() {
        if (defaultpd == null) {
            defaultpd = new DefaultProgressDialog(this);
        }
        return defaultpd;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.nav_item_showcode:
                String code = getCode();
                if (StringCheck.isEmpty(code))
                    ToastUtil.makeText(getAQuery().getContext(), "未设置核心代码");
                else
                    startActivity(new Intent(getAQuery().getContext(), CodeViewActivity.class)
                            .putExtra(CodeViewActivity.CODE, code)
                            .putExtra("ActionBartitle", ActionBartitle));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 设置核心代码
     */
    public String getCode() {
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbarmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
