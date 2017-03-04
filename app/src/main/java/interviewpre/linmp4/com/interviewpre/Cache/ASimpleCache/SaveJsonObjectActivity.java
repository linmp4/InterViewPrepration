package interviewpre.linmp4.com.interviewpre.Cache.ASimpleCache;

import org.json.JSONException;
import org.json.JSONObject;

import interviewpre.linmp4.com.interviewpre.Util.StringCheck;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class SaveJsonObjectActivity extends BaseASimpleActivity {

    private JSONObject jsonObject;

    @Override
    public void initGobalUI() {
        jsonObject = new JSONObject();
        try {
            jsonObject.put("name", "Yoson");
            jsonObject.put("age", 18);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String temp = jsonObject.toString();
        try {
            temp = StringCheck.Tojson(temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mEt_string_input.setText(temp);
        mEt_string_input.setEnabled(false);
    }

    @Override
    public void save() {
        getACache().put("testJsonObject", jsonObject);
        super.save();
    }

    @Override
    public void read() {
        JSONObject testJsonObject = getACache().getAsJSONObject("testJsonObject");
        if (testJsonObject == null) {
            ToastUtil.makeText(this, "数据为空");
            mTv_string_res.setText(null);
            return;
        }
        String temp = testJsonObject.toString();
        try {
            temp = StringCheck.Tojson(temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mTv_string_res.setText(temp);
    }

    @Override
    public void clear() {
        getACache().remove("testJsonObject");
        mTv_string_res.setText(null);
    }
}
