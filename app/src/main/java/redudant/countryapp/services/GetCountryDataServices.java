package redudant.countryapp.services;

import redudant.countryapp.model.Info;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetCountryDataServices {

    //http://services.groupkt.com/country/get/all
    //@GET("country/get/all")
    //Call<Data> getResults();

    //thi is multi parameter
    //http://services.groupkt.com/country/get/iso2code/{alpha2_code}
    //@GET("country/get/iso2code/{alpha2_code}")
    //Call<Info> getResultByAlpha2Code(@Path("alpha2_code"), String code, @Query("api_key") String apiKey);

    //single parameter
    //http://services.groupkt.com/country/get/iso2code/{alpha2_code}
    @GET("country/get/iso2code/{alpha2_code}")
    Call<Info> getResultByAlpha2Code(@Path("alpha2_code") String alpha2Code);

}
