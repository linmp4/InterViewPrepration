package interviewpre.linmp4.com.interviewpre.Json.Fastjson;

import com.alibaba.fastjson.JSON;

import interviewpre.linmp4.com.interviewpre.Json.BaseJsonActivity;
import interviewpre.linmp4.com.interviewpre.Json.JsonModel;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class FastjsonActivity extends BaseJsonActivity {

    private String code = "" +
            "//必须独立出来,不能是内部类，必须加public修饰\n" +
            "public class JsonModel {\n" +
            "    public int resultCode;\n" +
            "    public String resultMsg;\n" +
            "    public String resultThirdCode;\n" +
            "    public boolean isSuccess;\n" +
            "    public List<resultDataModel> resultData;\n" +
            "}\n\n" +
            "public class resultDataModel {\n" +
            "    public int id;\n" +
            "    public String name;\n" +
            "}\n\n" +
            "//解析json\n" +
            "JsonModel jsonArray = JSON.parseObject(string, JsonModel.class);\n" +
            "//对象转json\n" +
            "String result = JSON.toJSONString(jsonArray);\n";

    @Override
    public void StartJson(String result) {
        try {
            jsonArray = JSON.parseObject(jsonArrayString, JsonModel.class);
            result = jsonArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.StartJson(result);
    }

    @Override
    public void toJson(String result) {
        if (jsonArray == null)
            ToastUtil.makeText(this, "请先解析json");
        result = JSON.toJSONString(jsonArray);
        super.toJson(result);
    }

    @Override
    public String getCode() {
        return code;
    }
}
