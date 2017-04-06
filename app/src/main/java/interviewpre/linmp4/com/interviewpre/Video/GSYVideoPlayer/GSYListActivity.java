package interviewpre.linmp4.com.interviewpre.Video.GSYVideoPlayer;

import android.graphics.Point;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

import interviewpre.linmp4.com.interviewpre.BaseActivity;
import interviewpre.linmp4.com.interviewpre.R;

public class GSYListActivity extends BaseActivity {

    ListView videoList;
    FrameLayout videoFullContainer;
    RelativeLayout activityListVideo;

    ListVideoUtil listVideoUtil;
    ListVideoAdapter listVideoAdapter;
    int lastVisibleItem;
    int firstVisibleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 设置一个exit transition
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video2);

        activityListVideo = (RelativeLayout) findViewById(R.id.activity_list_video);
        videoFullContainer = (FrameLayout) findViewById(R.id.video_full_container);
        videoList = (ListView) findViewById(R.id.video_list);

        listVideoUtil = new ListVideoUtil(this);
        listVideoUtil.setFullViewContainer(videoFullContainer);
        listVideoUtil.setHideStatusBar(true);
        //listVideoUtil.setHideActionBar(true);
        listVideoUtil.setNeedLockFull(true);

        listVideoAdapter = new ListVideoAdapter(this, listVideoUtil);
        listVideoAdapter.setRootView(activityListVideo);
        videoList.setAdapter(listVideoAdapter);

        //listVideoUtil.setShowFullAnimation(true);
        //listVideoUtil.setAutoRotation(true);
        //listVideoUtil.setFullLandFrist(true);


        videoList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                firstVisibleItem = firstVisibleItem;
                lastVisibleItem = firstVisibleItem + visibleItemCount;
                //大于0说明有播放,//对应的播放列表TAG
                if (listVideoUtil.getPlayPosition() >= 0 && listVideoUtil.getPlayTAG().equals(ListVideoAdapter.TAG)) {
                    //当前播放的位置
                    int position = listVideoUtil.getPlayPosition();
                    //不可视的是时候
                    if ((position < firstVisibleItem || position > lastVisibleItem)) {
                        //如果是小窗口就不需要处理
                        if (!listVideoUtil.isSmall()) {
                            //小窗口
                            int size = CommonUtil.dip2px(getAQuery().getContext(), 150);
                            listVideoUtil.showSmallVideo(new Point(size, size), false, true);
                        }
                    } else {
                        if (listVideoUtil.isSmall()) {
                            listVideoUtil.smallVideoToNormal();
                        }
                    }
                }
            }

        });

        //小窗口关闭被点击的时候回调处理回复页面
        listVideoUtil.setVideoAllCallBack(new SampleListener() {
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                Debuger.printfLog("Duration " + listVideoUtil.getDuration() + " CurrentPosition " + listVideoUtil.getCurrentPositionWhenPlaying());
            }

            @Override
            public void onQuitSmallWidget(String url, Object... objects) {
                super.onQuitSmallWidget(url, objects);
                //大于0说明有播放,//对应的播放列表TAG
                if (listVideoUtil.getPlayPosition() >= 0 && listVideoUtil.getPlayTAG().equals(ListVideoAdapter.TAG)) {
                    //当前播放的位置
                    int position = listVideoUtil.getPlayPosition();
                    //不可视的是时候
                    if ((position < firstVisibleItem || position > lastVisibleItem)) {
                        //释放掉视频
                        listVideoUtil.releaseVideoPlayer();
                        listVideoAdapter.notifyDataSetChanged();
                    }
                }

            }
        });


    }


    @Override
    public void onBackPressed() {
        if (listVideoUtil.backFromFull()) {
            return;
        }
        super.onBackPressed();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        listVideoUtil.releaseVideoPlayer();
        GSYVideoPlayer.releaseAllVideos();
    }

}
