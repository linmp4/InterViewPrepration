package interviewpre.linmp4.com.interviewpre.Network.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FirService {
    @GET("apps/latest/5881b8c0959d691f5c00044c?api_token=e0be056f9e2f0e9623c5dd69b32e488c")
    Call<ResponseBody> getVersion();
}