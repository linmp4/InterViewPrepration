package interviewpre.linmp4.com.interviewpre.Json.Gson;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.util.List;

import interviewpre.linmp4.com.interviewpre.Json.BaseJsonActivity;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;

public class GsonActivity extends BaseJsonActivity {

    private String code = "" +
            "//定义JSON的解析类\n" +
            "class JsonArrayModel {\n" +
            "    int resultCode;\n" +
            "    String resultMsg;\n" +
            "    String resultThirdCode;\n" +
            "    boolean isSuccess;\n" +
            "    List<resultDataModel> resultData;\n" +
            "}\n" +
            "\n" +
            "class resultDataModel {\n" +
            "    int id;\n" +
            "    String name;\n" +
            "}\n" +
            "//解析json\n" +
            "JsonArrayModel list = new Gson().fromJson(jsonArrayString, JsonArrayModel.class)\n";

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

    private class JsonArrayModel {
        int resultCode;
        String resultMsg;
        String resultThirdCode;
        boolean isSuccess;
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
        int id;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String temp = jsonArrayString;
        try {
            temp = StringCheck.Tojson(temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        et_string_input.setText(temp);
    }

    @Override
    public void StartJson(String result) {
        jsonArrayString = et_string_input.getText().toString();
        try {
            JsonArrayModel list = new Gson().fromJson(jsonArrayString, JsonArrayModel.class);
            result = list.toString();
        } catch (Exception e) {
            e.printStackTrace();
            result = "json格式错误";
        }
        super.StartJson(result);
    }

    @Override
    public String getCode() {
        return code;
    }
}
