package interviewpre.linmp4.com.interviewpre.UI.CodeView;

import android.os.Bundle;

import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.HightlightJs;
import interviewpre.linmp4.com.interviewpre.BaseActivity;

public class CodeViewActivity extends BaseActivity {

    public static String CODE = "Code";
    private String webcode = "" +
            "CodeView cv = new CodeView(this);\n" +
            "\n" +
            "cv.setSyntaxHighlighter(new HightlightJs())\n" +
            "        .setCode(temp)\n" +
            "        .setLanguage(HightlightJs.Languages.JAVA)\n" +
            "        .setTheme(HightlightJs.Themes.DRACULA)\n" +
            "        .setShowLineNumber(true)\n" +
            "        .setTextSize(14)\n" +
            "        .apply();\n" +
            "setContentView(cv);\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String temp = getIntent().getStringExtra(CODE);
        if (temp == null)
            temp = "无代码";

        CodeView cv = new CodeView(this);
        cv.setSyntaxHighlighter(new HightlightJs())
                .setCode(temp)
                .setLanguage(HightlightJs.Languages.JAVA)
                .setTheme(HightlightJs.Themes.DRACULA)
                .setShowLineNumber(true)
                .setTextSize(14)
                .apply();
        setContentView(cv);

        ActionBartitle = "CodeView";
    }

    @Override
    public String getCode() {
        return webcode;
    }
}
