package interviewpre.linmp4.com.interviewpre.Network.Okhttp;

import java.util.LinkedHashMap;

import interviewpre.linmp4.com.interviewpre.Network.BaseNetworkActivity;
import interviewpre.linmp4.com.interviewpre.Network.HttpListener;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;

public class OkHttpActivity extends BaseNetworkActivity {

    @Override
    public void getAsynHttp() {
        getdefaultpd().showDialog();
        OkHttpUtil.getAsyn(getAQuery().getContext(), baseGetUrl, new HttpListener() {
            @Override
            public void callback(String url, int code, String response) {
                getdefaultpd().dismissDialog();

                new StringCheck.UpdateUI(response, code, url, null) {
                    @Override
                    public void Success(String temp) {
                        getAQuery().id(R.id.tv_code).text(temp);
                    }
                };
            }
        });
    }


    @Override
    public void postAsynHttp() {
        getdefaultpd().showDialog();

        OkHttpUtil.postAsyn(getAQuery().getContext(), basePostUrl, map, new HttpListener() {
            @Override
            public void callback(String url, int code, String response) {
                getdefaultpd().dismissDialog();

                new StringCheck.UpdateUI(response, code, url, map) {
                    @Override
                    public void Success(String temp) {
                        getAQuery().id(R.id.tv_code).text(temp);
                    }
                };
            }
        });
    }

}
