package interviewpre.linmp4.com.interviewpre.Picture.Fresco;

import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import interviewpre.linmp4.com.interviewpre.Picture.BasePicActivity;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class FrescoActivity extends BasePicActivity {

    private String code = "" +
            "<!--XML布局-->\n" +
            "<com.facebook.drawee.view.SimpleDraweeView\n" +
            "          android:layout_width=\"wrap_content\"\n" +
            "          android:layout_height=\"wrap_content\"\n" +
            "          android:scaleType=\"fitXY\"\n" +
            "          fresco:fadeDuration=\"400\"\n" +
            "          fresco:failureImageScaleType=\"fitXY\"\n" +
            "          fresco:placeholderImage=\"@mipmap/ic_launcher\"/>\n" +
            "\n" +
            "/**\n" +
            " * 加载圆形图片\n" +
            " */\n" +
            "mySimpleDraweeView.setImageURI(picurl);\n" +
            "\n" +
            "RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);\n" +
            "roundingParams.setRoundAsCircle(true);\n" +
            "mySimpleDraweeView.getHierarchy().setRoundingParams(roundingParams);" +
            "\n" +
            "/**\n" +
            " * 清除图片缓存\n" +
            " */" +
            "\n" +
            "Fresco.getImagePipeline().clearCaches();\n";

    @Override
    public String getCode() {
        return code;
    }

    private SimpleDraweeView iv_pic2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iv_pic2 = (SimpleDraweeView) findViewById(R.id.iv_pic2);
        iv_pic2.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadOrginPic() {
        super.loadOrginPic();
        iv_pic2.setImageURI(picurl);
        iv_pic2.getHierarchy().setRoundingParams(null);
    }


    @Override
    public void loadRoundPic() {
        super.loadOrginPic();
        iv_pic2.setImageURI(picurl);

        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        iv_pic2.getHierarchy().setRoundingParams(roundingParams);
    }

    @Override
    public void clearPic() {
        Fresco.getImagePipeline().clearCaches();
        ToastUtil.makeText(getAQuery().getContext(), "清理完成");
    }

}
