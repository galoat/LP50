package projetlp50.utbm.com.belfortcity.mainPage;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import projetlp50.utbm.com.belfortcity.MeteoActivity;
import projetlp50.utbm.com.belfortcity.R;
import projetlp50.utbm.com.belfortcity.calendar.Calendar;
import projetlp50.utbm.com.belfortcity.weather.WeatherManager;

public class MainActivity extends AppCompatActivity {
    private TextView home_weather_temp ;
    private TextView home_no_weather;
    private TextView home_weather_type;

    private ImageView home_no_weather_icon;
    private ImageView home_weather_icon ;

    private View mAboutContainer;
    private View watherContainer;

    private TextView textViewCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_weather_temp = (TextView) findViewById(R.id.home_weather_temp);
        home_no_weather = (TextView)findViewById(R.id.home_no_weather);
        home_weather_type = (TextView)findViewById(R.id.home_weather_type);

        home_no_weather_icon=(ImageView)findViewById(R.id.home_no_weather_icon);
        home_weather_icon =(ImageView)findViewById(R.id.home_weather_icon);

        mAboutContainer = (View)findViewById(R.id.home_about_container);
        mAboutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        watherContainer = (View)findViewById(R.id.home_weather);
        watherContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MeteoActivity.class);
                startActivity(intent);
            }
        });


       textViewCalendar =(TextView)findViewById(R.id.home_calendar_btn);
        textViewCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calendar.class);
                startActivity(intent);
            }
        });

        GetWeather task = new GetWeather();
        task.execute(new String[]{});
    }
    public void addListenerOnButton() {


    }

    private class GetWeather extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String output = null ;
            WeatherManager weaterManager = new WeatherManager();
            try {
                output = weaterManager.getJSONToday();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return output;
        }

        @Override
        protected void onPostExecute(String output)
        {
            if (output =="")
            {
                home_no_weather_icon.setVisibility(View.VISIBLE);
                home_no_weather.setVisibility(View.VISIBLE);
            }
            else
            {
                JSONObject jObj = null;
                try
                {
                    jObj = new JSONObject(output.toString());
                    JSONObject jMain = jObj.getJSONObject("main");
                    int temp = (int)(jMain.getDouble("temp") -273.15) ;
                    home_weather_temp.setText("" + temp + "°C");

                    JSONArray jArr = jObj.getJSONArray("weather");
                    JSONObject jWeather = jArr.getJSONObject(0);
                    home_weather_type.setText((String) jWeather.get("description"));

                    String icon = (String) jWeather.get("icon");
                    if (icon.equals("01d"))
                        home_weather_icon.setImageResource(R.drawable.forecast_01d);

                    else if (icon.equals("01n"))
                        home_weather_icon.setImageResource(R.drawable.forecast_01n);

                    else if (icon.equals("02d"))
                        home_weather_icon.setImageResource(R.drawable.forecast_02d);

                    else if (icon.equals("02n"))
                        home_weather_icon.setImageResource(R.drawable.forecast_02n);

                    else if (icon.equals("03d"))
                        home_weather_icon.setImageResource(R.drawable.forecast_03d);

                    else if (icon.equals("03n"))
                        home_weather_icon.setImageResource(R.drawable.forecast_03n);

                    else if (icon.equals("04d"))
                        home_weather_icon.setImageResource(R.drawable.forecast_04d);

                    else if (icon.equals("04n"))
                        home_weather_icon.setImageResource(R.drawable.forecast_04n);

                    else if (icon.equals("09d"))
                        home_weather_icon.setImageResource(R.drawable.forecast_09d);

                    else if (icon.equals("09n"))
                        home_weather_icon.setImageResource(R.drawable.forecast_09n);

                    else if (icon.equals("10d"))
                        home_weather_icon.setImageResource(R.drawable.forecast_10d);

                    else if (icon.equals("10n"))
                        home_weather_icon.setImageResource(R.drawable.forecast_10n);

                    else if (icon.equals("11d"))
                        home_weather_icon.setImageResource(R.drawable.forecast_11d);

                    else if (icon.equals("11n"))
                        home_weather_icon.setImageResource(R.drawable.forecast_11n);

                    else if (icon.equals("13d"))
                        home_weather_icon.setImageResource(R.drawable.forecast_13d);

                    else if (icon.equals("13n"))
                        home_weather_icon.setImageResource(R.drawable.forecast_13n);

                    else if (icon.equals("50d"))
                        home_weather_icon.setImageResource(R.drawable.forecast_50d);

                    else if (icon.equals("50n"))
                        home_weather_icon.setImageResource(R.drawable.forecast_50n);



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

    }



}