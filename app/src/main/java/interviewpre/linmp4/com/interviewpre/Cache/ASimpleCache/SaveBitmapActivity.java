package interviewpre.linmp4.com.interviewpre.Cache.ASimpleCache;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class SaveBitmapActivity extends BaseASimpleActivity {

    @Override
    public void initGobalUI() {
        mEt_string_input.setVisibility(View.GONE);
        iv_bitmap_save.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public void save() {
        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
        getACache().put("testBitmap", bitmap);
        super.save();
    }

    @Override
    public void read() {
        Bitmap testBitmap = getACache().getAsBitmap("testBitmap");
        if (testBitmap == null) {
            ToastUtil.makeText(this, "数据为空");
            iv_bitmap_res.setImageBitmap(null);
            return;
        }
        iv_bitmap_res.setImageBitmap(testBitmap);
    }

    @Override
    public void clear() {
        getACache().remove("testBitmap");
        iv_bitmap_res.setImageBitmap(null);
    }
}
