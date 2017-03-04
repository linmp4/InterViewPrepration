package interviewpre.linmp4.com.interviewpre.Picture.Fresco;

import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;

import interviewpre.linmp4.com.interviewpre.Picture.BasePicActivity;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class FrescoActivity extends BasePicActivity {

    private SimpleDraweeView iv_pic2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_picture_fresco);
        InitUI();

        iv_pic2 = (SimpleDraweeView) findViewById(R.id.iv_pic2);
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
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        imagePipeline.clearCaches();
        ToastUtil.makeText(getAQuery().getContext(), "清理完成");
    }

}
