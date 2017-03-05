package interviewpre.linmp4.com.interviewpre.Picture.Picasso;

import com.squareup.picasso.Picasso;

import interviewpre.linmp4.com.interviewpre.Picture.BasePicActivity;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class PicassoActivity extends BasePicActivity {

    private String code = "" +
            "/**\n" +
            " * 加载圆形图片\n" +
            " */\n" +
            "CircleImageTransformation transform = new CircleImageTransformation();\n" +
            "Picasso.with(this)\n" +
            "        .load(picurl)\n" +
            "        .placeholder(R.mipmap.ic_launcher)\n" +
            "        .transform(transform)\n" +
            "        .into(iv_pic);" +
            "\n" +
            "/**\n" +
            " * 清除图片缓存\n" +
            " */" +
            "\n" +
            "Picasso.with(this).invalidate(picurl);\n";

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void loadOrginPic() {
        super.loadOrginPic();
        Picasso.with(this)
                .load(picurl)
                .placeholder(R.mipmap.ic_launcher)
                .into(iv_pic);
    }


    @Override
    public void loadRoundPic() {
        super.loadOrginPic();
        CircleImageTransformation transform = new CircleImageTransformation();
        Picasso.with(this)
                .load(picurl)
                .placeholder(R.mipmap.ic_launcher)
                .transform(transform)
                .into(iv_pic);
    }

    @Override
    public void clearPic() {
        String temp = null;
        Picasso.with(this)
                .load(temp)
                .placeholder(R.mipmap.ic_launcher)
                .into(iv_pic);
        Picasso.with(this).invalidate(picurl);
        ToastUtil.makeText(getAQuery().getContext(), "清理完成");
    }

}
