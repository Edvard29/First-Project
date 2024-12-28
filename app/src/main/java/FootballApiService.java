import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface FootballApiService {
    @GET("fixtures")
    Call<ApiResponse> getFixtures(@Header("X-RapidAPI-Key") String apiKey);
}
