package interviewpre.linmp4.com.interviewpre.Video.JieCao;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import interviewpre.linmp4.com.interviewpre.BaseActivity;

public class JieCaoVideoListViewActivity extends BaseActivity {
    ListView listView;
    VideoListAdapter adapterVideoList;

    SensorManager sensorManager;
    JCVideoPlayer.JCAutoFullscreenListener sensorEventListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = new ListView(this);
        adapterVideoList = new VideoListAdapter(this);
        listView.setAdapter(adapterVideoList);

        setContentView(listView);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
