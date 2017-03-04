package interviewpre.linmp4.com.interviewpre.Cache.ASimpleCache;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import interviewpre.linmp4.com.interviewpre.Util.StringCheck;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class SaveJsonArrayActivity extends BaseASimpleActivity {

    private JSONArray jsonArray;

    @Override
    public void initGobalUI() {
        jsonArray = new JSONArray();
        JSONObject yosonJsonObject = new JSONObject();

        try {
            yosonJsonObject.put("name", "Yoson");
            yosonJsonObject.put("age", 18);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject michaelJsonObject = new JSONObject();
        try {
            michaelJsonObject.put("name", "Michael");
            michaelJsonObject.put("age", 25);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        jsonArray.put(yosonJsonObject);
        jsonArray.put(michaelJsonObject);

        String temp = jsonArray.toString();
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
        getACache().put("testJsonArray", jsonArray);
        super.save();
    }

    @Override
    public void read() {
        JSONArray testJsonArray = getACache().getAsJSONArray("testJsonArray");
        if (testJsonArray == null) {
            ToastUtil.makeText(this, "数据为空");
            mTv_string_res.setText(null);
            return;
        }
        String temp = testJsonArray.toString();
        try {
            temp = StringCheck.Tojson(temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mTv_string_res.setText(temp);
    }

    @Override
    public void clear() {
        getACache().remove("testJsonArray");
        mTv_string_res.setText(null);
    }
}
