package redudant.countryapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponse {

    @SerializedName("messages")
    private List<String> massages = null;

    @SerializedName("result")
    private Result result = null;

    public List<String> getMassages() {
        return massages;
    }

    public void setMassages(List<String> massages) {
        this.massages = massages;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
