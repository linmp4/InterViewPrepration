package interviewpre.linmp4.com.interviewpre.Picture.Glide;

import com.bumptech.glide.Glide;

import interviewpre.linmp4.com.interviewpre.Picture.BasePicActivity;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class GlideActivity extends BasePicActivity {

    @Override
    public void loadOrginPic() {
        super.loadOrginPic();
        Glide.with(this).load(picurl)
                .placeholder(R.mipmap.ic_launcher)
                .into(iv_pic);
    }


    @Override
    public void loadRoundPic() {
        super.loadOrginPic();
        GlideCircleTransform transform = new GlideCircleTransform(this);
        Glide.with(this).load(picurl)
                .placeholder(R.mipmap.ic_launcher)
                .transform(transform)
                .into(iv_pic);
    }

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
