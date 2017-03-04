package interviewpre.linmp4.com.interviewpre.Network.Volley;

import interviewpre.linmp4.com.interviewpre.Network.BaseNetworkActivity;
import interviewpre.linmp4.com.interviewpre.Network.HttpListener;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;

public class VolleyActivity extends BaseNetworkActivity {


    @Override
    public void getAsynHttp() {
        getdefaultpd().showDialog();

        VolleyUtil.getAsyn(this, baseGetUrl, new HttpListener() {
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

        VolleyUtil.postAsyn(getAQuery().getContext(), basePostUrl, map, new HttpListener() {
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

    @Override
    protected void onStop() {
        super.onStop();
        VolleyUtil.postAsyn();
    }
}
