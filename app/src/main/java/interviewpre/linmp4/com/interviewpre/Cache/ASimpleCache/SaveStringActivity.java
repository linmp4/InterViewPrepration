package interviewpre.linmp4.com.interviewpre.Cache.ASimpleCache;

import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class SaveStringActivity extends BaseASimpleActivity {

    @Override
    public void save() {
        if (mEt_string_input.getText().toString().trim().length() == 0) {
            ToastUtil.makeText(this, "请输入要保存的内容");
        }
        getACache().put("testString", mEt_string_input.getText().toString());
        super.save();
    }

    @Override
    public void read() {
        String testString = getACache().getAsString("testString");
        if (testString == null) {
            ToastUtil.makeText(this, "数据为空");
            mTv_string_res.setText(null);
            return;
        }
        mTv_string_res.setText(testString);
    }

    @Override
    public void clear() {
        getACache().remove("testString");
        mTv_string_res.setText(null);
    }
}
