package interviewpre.linmp4.com.interviewpre.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidquery.AQuery;

import interviewpre.linmp4.com.interviewpre.Util.DefaultProgressDialog;

public class BaseActivity extends AppCompatActivity {

    private AQuery aQuery;
    private DefaultProgressDialog defaultpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

}
