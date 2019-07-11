package redudant.countryapp.services.clientbase;

import redudant.countryapp.services.GetCountryDataServices;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitIntance {

    //web api http://www.groupkt.com
    //from this web http://www.groupkt.com/post/c9b0ccb9/restful-webservices-to-get-and-search-countries.htm
    //http://services.groupkt.com/country/get/all
    private static Retrofit retrofit = null;
    private static String BASE_URL = "http://services.groupkt.com";

    public static GetCountryDataServices getServices()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return null;
    }

}
