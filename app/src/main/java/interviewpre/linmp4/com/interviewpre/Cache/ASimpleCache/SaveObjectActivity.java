package interviewpre.linmp4.com.interviewpre.Cache.ASimpleCache;

import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class SaveObjectActivity extends BaseASimpleActivity {

    private UserBean userBean;

    @Override
    public void initGobalUI() {
        userBean = new UserBean();
        userBean.setAge("18");
        userBean.setName("HaoYoucai");
        mEt_string_input.setText(userBean.toString());
        mEt_string_input.setEnabled(false);
    }

    @Override
    public void save() {
        getACache().put("testObject", userBean);
        super.save();
    }

    @Override
    public void read() {
        UserBean testObject = (UserBean) getACache().getAsObject("testObject");
        if (testObject == null) {
            ToastUtil.makeText(this, "数据为空");
            mTv_string_res.setText(null);
            return;
        }
        mTv_string_res.setText(testObject.toString());
    }

    @Override
    public void clear() {
        getACache().remove("testObject");
        mTv_string_res.setText(null);
    }
}
