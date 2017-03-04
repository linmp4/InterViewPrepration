package interviewpre.linmp4.com.interviewpre.Network.retrofit;

import interviewpre.linmp4.com.interviewpre.Network.BaseNetworkActivity;
import interviewpre.linmp4.com.interviewpre.Network.HttpListener;
import interviewpre.linmp4.com.interviewpre.Picture.Glide.GlideActivity;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;
import retrofit2.Retrofit;

public class RetrofitActivity extends BaseNetworkActivity {

    @Override
    public void getAsynHttp() {
        getdefaultpd().showDialog();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseGetHead)
                .build();
        retrofit.create(FirService.class)
                .getVersion()
                .enqueue(new RetrofitCallback(new HttpListener() {
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
                }));
    }

    @Override
    public void postAsynHttp() {
        getdefaultpd().showDialog();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseGetHead)
                .build();
        retrofit.create(StarService.class)
                .getStar(map.get("consName"), map.get("type"), map.get("key"))
                .enqueue(new RetrofitCallback(new HttpListener() {
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
                }));
    }
}
