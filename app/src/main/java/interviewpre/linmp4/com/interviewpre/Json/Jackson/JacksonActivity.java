package interviewpre.linmp4.com.interviewpre.Json.Jackson;

import android.os.Bundle;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

import interviewpre.linmp4.com.interviewpre.Json.BaseJsonActivity;
import interviewpre.linmp4.com.interviewpre.Json.JsonModel;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class JacksonActivity extends BaseJsonActivity {

    private String code = "" +
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
            "ObjectMapper objectMapper = new ObjectMapper();\n" +
            "//解析json\n" +
            "JsonModel jsonArray = objectMapper.readValue(string, JsonModel.class);\n" +
            "//对象转json\n" +
            "String result = objectMapper.writeValueAsString(jsonArray);\n";

    private ObjectMapper objectMapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        objectMapper = new ObjectMapper();
    }

    @Override
    public void StartJson(String result) {
        try {
            jsonArray = objectMapper.readValue(jsonArrayString, JsonModel.class);
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
        try {
            result = objectMapper.writeValueAsString(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.toJson(result);
    }

    @Override
    public String getCode() {
        return code;
    }
}
