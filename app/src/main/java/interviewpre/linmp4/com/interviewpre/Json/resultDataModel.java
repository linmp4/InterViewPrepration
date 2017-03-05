package interviewpre.linmp4.com.interviewpre.Json;

import com.google.gson.annotations.Expose;

public class resultDataModel {
    public resultDataModel() {//转json需继承父类super
        super();
    }

    @Expose
    public int id;
    @Expose
    public String name;

    @Override
    public String toString() {
        return "resultDataModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}