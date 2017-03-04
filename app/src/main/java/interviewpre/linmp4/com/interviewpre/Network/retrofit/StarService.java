package interviewpre.linmp4.com.interviewpre.Network.retrofit;

import interviewpre.linmp4.com.interviewpre.Network.BaseNetworkActivity;
import interviewpre.linmp4.com.interviewpre.Picture.Glide.GlideActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface StarService {
    @FormUrlEncoded
    @POST(BaseNetworkActivity.basePostFoot)
    Call<ResponseBody> getStar(
            @Field("consName") String consName,
            @Field("type") String type,
            @Field("key") String key
    );
}