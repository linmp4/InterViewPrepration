package interviewpre.linmp4.com.interviewpre.Model;

import java.io.Serializable;

public class MainModel implements Serializable {
    public String title;
    public Class ActClass;
    public ContextModel model;
    public String code;

    public MainModel(String title, Class ActClass) {
        this.title = title;
        this.ActClass = ActClass;
    }

    public MainModel(String title, Class ActClass, String code) {
        this.title = title;
        this.ActClass = ActClass;
        this.code = code;
    }

    public MainModel(String title, Class ActClass, ContextModel model) {
        this.title = title;
        this.ActClass = ActClass;
        this.model = model;
    }
}