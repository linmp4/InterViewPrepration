package interviewpre.linmp4.com.interviewpre.Json.Gson;

import com.google.gson.Gson;

import interviewpre.linmp4.com.interviewpre.Json.BaseJsonActivity;
import interviewpre.linmp4.com.interviewpre.Json.JsonModel;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class GsonActivity extends BaseJsonActivity {

    private String code = "" +
            "//定义JSON的解析类\n" +
            "class JsonModel {\n" +
            "    JsonModel() {//转json需继承父类super\n" +
            "        super();\n" +
            "    }\n" +
            "\n" +
            "    @Expose\n" +
            "    int resultCode;\n" +
            "    @Expose\n" +
            "    String resultMsg;\n" +
            "    @Expose\n" +
            "    String resultThirdCode;\n" +
            "    @Expose\n" +
            "    boolean isSuccess;\n" +
            "    @Expose\n" +
            "    List<resultDataModel> resultData;\n" +
            "}\n" +
            "\n" +
            "class resultDataModel {\n" +
            "    resultDataModel() {//转json需继承父类super\n" +
            "        super();\n" +
            "    }\n" +
            "\n" +
            "    @Expose\n" +
            "    int id;\n" +
            "    @Expose\n" +
            "    String name;\n" +
            "}\n\n" +
            "//解析json\n" +
            "JsonModel list = new Gson().fromJson(string, JsonModel.class)\n" +
            "//对象转json\n" +
            "String result = new Gson().toJson(jsonArray);\n";

    @Override
    public void StartJson(String result) {
        try {
            jsonArray = new Gson().fromJson(jsonArrayString, JsonModel.class);
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
        result = new Gson().toJson(jsonArray);
        super.toJson(result);
    }

    @Override
    public String getCode() {
        return code;
    }
}
