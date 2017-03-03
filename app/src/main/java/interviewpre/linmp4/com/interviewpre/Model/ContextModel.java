package interviewpre.linmp4.com.interviewpre.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContextModel implements Serializable {
    public List<MainModel> mainModel = new ArrayList<>();

    public ContextModel() {
    }

    public ContextModel(ArrayList<MainModel> list) {
        mainModel.addAll(list);
    }
}