package interviewpre.linmp4.com.interviewpre.Json.Gson;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import org.json.JSONException;

import java.util.List;

import interviewpre.linmp4.com.interviewpre.Json.BaseJsonActivity;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class GsonActivity extends BaseJsonActivity {

    private String code = "" +
            "//定义JSON的解析类\n" +
            "class JsonArrayModel {\n" +
            "    JsonArrayModel() {//转json需继承父类super\n" +
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
            "JsonArrayModel list = new Gson().fromJson(jsonArrayString, JsonArrayModel.class)\n" +
            "//转为json\n" +
            "String result = new Gson().toJson(jsonArray);\n";

    private String jsonArrayString = "{\n" +
            "    \"resultCode\": \"100\",\n" +
            "    \"resultMsg\": \"成功\",\n" +
            "    \"isSuccess\": true,\n" +
            "    \"resultData\": [\n" +
            "        {\n" +
            "            \"id\": \"1\",\n" +
            "            \"name\": \"顺丰速运\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"2\",\n" +
            "            \"name\": \"圆通\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"resultThirdCode\": null\n" +
            "}";

    private JsonArrayModel jsonArray;

    private class JsonArrayModel {
        JsonArrayModel() {//转json需继承父类super
            super();
        }

        @Expose
        int resultCode;
        @Expose
        String resultMsg;
        @Expose
        String resultThirdCode;
        @Expose
        boolean isSuccess;
        @Expose
        List<resultDataModel> resultData;

        @Override
        public String toString() {
            return "JsonArrayModel{" +
                    "resultCode=" + resultCode +
                    ", resultMsg='" + resultMsg + '\'' +
                    ", resultThirdCode='" + resultThirdCode + '\'' +
                    ", isSuccess=" + isSuccess +
                    ", resultData=" + resultData +
                    '}';
        }
    }

    private class resultDataModel {
        resultDataModel() {//转json需继承父类super
            super();
        }

        @Expose
        int id;
        @Expose
        String name;

        @Override
        public String toString() {
            return "resultDataModel{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public void StartJson(String result) {
        try {
            jsonArray = new Gson().fromJson(jsonArrayString, JsonArrayModel.class);
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
        try {
            result = StringCheck.Tojson(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        super.toJson(result);
    }

    @Override
    public String getCode() {
        return code;
    }
}
