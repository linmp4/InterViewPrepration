package interviewpre.linmp4.com.interviewpre.Network.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface StarService {
    @FormUrlEncoded
    @POST("constellation/getAll")
    Call<ResponseBody> getStar(
            @Field("consName") String consName,
            @Field("type") String type,
            @Field("key") String key
    );
}