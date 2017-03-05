package interviewpre.linmp4.com.interviewpre.Json;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import interviewpre.linmp4.com.interviewpre.BaseActivity;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class BaseJsonActivity extends BaseActivity {

    public EditText et_string_input;
    public TextView tv_string_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_json);
        super.onCreate(savedInstanceState);

        InitUI();
    }

    public void InitUI() {
        et_string_input = (EditText) findViewById(R.id.et_string_input);
        tv_string_res = (TextView) findViewById(R.id.tv_string_res);
        getAQuery().id(R.id.bt_start).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartJson(null);
            }
        });
    }


    public void StartJson(String result) {
        tv_string_res.setText(result);
    }

}
