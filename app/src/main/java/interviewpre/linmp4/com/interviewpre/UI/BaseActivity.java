package interviewpre.linmp4.com.interviewpre.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidquery.AQuery;

public class BaseActivity extends AppCompatActivity {

    private AQuery aQuery;

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

}
