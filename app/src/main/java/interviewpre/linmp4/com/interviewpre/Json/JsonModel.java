package interviewpre.linmp4.com.interviewpre.Json;

import com.google.gson.annotations.Expose;

import java.util.List;

public class JsonModel {
    public JsonModel() {//转json需继承父类super
        super();
    }

    @Expose
    public int resultCode;
    @Expose
    public String resultMsg;
    @Expose
    public String resultThirdCode;
    @Expose
    public boolean isSuccess;
    @Expose
    public List<resultDataModel> resultData;

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

