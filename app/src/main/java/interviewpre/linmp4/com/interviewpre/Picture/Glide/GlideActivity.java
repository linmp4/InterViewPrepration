package interviewpre.linmp4.com.interviewpre.Picture.Glide;

import com.bumptech.glide.Glide;

import interviewpre.linmp4.com.interviewpre.Picture.BasePicActivity;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class GlideActivity extends BasePicActivity {

    private String code = "" +
            "/**\n" +
            " * 加载圆形图片\n" +
            " */" +
            "\n" +
            "GlideCircleTransform transform = new GlideCircleTransform(this);\n" +
            "Glide.with(this).load(picurl)\n" +
            "        .placeholder(R.mipmap.ic_launcher)\n" +
            "        .transform(transform)\n" +
            "        .into(iv_pic);" +
            "\n" +
            "/**\n" +
            " * 清除图片缓存\n" +
            " */" +
            "\n" +
            "Glide.clear(iv_pic);\n" +
            "Glide.get(this).clearMemory();\n" +
            "new Thread() {\n" +
            "    @Override\n" +
            "    public void run() {\n" +
            "        super.run();\n" +
            "        Glide.get(getAQuery().getContext()).clearDiskCache();\n" +
            "    }\n" +
            "}.start();\n";

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void loadOrginPic() {
        super.loadOrginPic();
        Glide.with(this).load(picurl)
                .placeholder(R.mipmap.ic_launcher)
                .into(iv_pic);
    }

    /**
     * 加载圆形图片
     */
    @Override
    public void loadRoundPic() {
        super.loadOrginPic();
        GlideCircleTransform transform = new GlideCircleTransform(this);
        Glide.with(this).load(picurl)
                .placeholder(R.mipmap.ic_launcher)
                .transform(transform)
                .into(iv_pic);
    }

    /**
     * 清除图片缓存
     */
    @Override
    public void clearPic() {
        Glide.clear(iv_pic);
        Glide.get(this).clearMemory();
        new Thread() {
            @Override
            public void run() {
                super.run();
                Glide.get(getAQuery().getContext()).clearDiskCache();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.makeText(getAQuery().getContext(), "清理完成");
                    }
                });
            }
        }.start();
    }

}
