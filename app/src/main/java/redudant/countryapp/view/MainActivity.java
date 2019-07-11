package redudant.countryapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import redudant.countryapp.R;
import redudant.countryapp.model.Info;
import redudant.countryapp.model.Result;
import redudant.countryapp.services.GetCountryDataServices;
import redudant.countryapp.services.clientbase.RetrofitIntance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText countryCodeEditText;
    TextView countryNameTextView;
    Button submitbutton;
    Button clearButton;

    String countryCode;

    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryCodeEditText = (EditText) findViewById(R.id.etCode);
        countryNameTextView = (TextView) findViewById(R.id.tvCountryname);
        submitbutton = (Button) findViewById(R.id.btnSubmit);
        clearButton = (Button) findViewById(R.id.btnClear);

        onClickButton();
    }

    public void onClickButton() {
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                countryCode = countryCodeEditText.getText().toString();


                GetCountryDataServices getCountryDataServices = RetrofitIntance.getServices();

                Call<Info> call = getCountryDataServices.getResultByAlpha2Code(countryCode);

                call.enqueue(new Callback<Info>() {
                    @Override
                    public void onResponse(Call<Info> call, Response<Info> response) {

                        Info info = response.body();

                        if (info != null && info.getRestResponse() != null) {

                            result = info.getRestResponse().getResult();

                            countryNameTextView.setText(result.getName());

                        }
                    }

                    @Override
                    public void onFailure(Call<Info> call, Throwable t) {


                    }
                });
            }
        });


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                countryCodeEditText.setText(" ");

                countryNameTextView.setText(" ");
            }
        });
    }
}
