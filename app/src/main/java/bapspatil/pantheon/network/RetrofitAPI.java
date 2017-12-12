package bapspatil.pantheon.network;

import bapspatil.pantheon.model.TeamResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by bapspatil
 */

public interface RetrofitAPI {

    String BASE_URL = "https://raw.githubusercontent.com/bapspatil/Pantheon/master/";

    @GET("resources/team.json")
    Call<TeamResponse> getTeam();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
