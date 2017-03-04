package interviewpre.linmp4.com.interviewpre.Network.retrofit;

import interviewpre.linmp4.com.interviewpre.Network.BaseNetworkActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FirService {
    @GET(BaseNetworkActivity.baseGetFoot)
    Call<ResponseBody> getVersion();
}