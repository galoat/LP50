package projetlp50.utbm.com.belfortcity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import projetlp50.utbm.com.belfortcity.weather.WeatherManager;

/**
 * Created by nicolas on 06/12/15.
 */
public class MeteoActivity extends Activity {
    TextView dateTextView;
    TextView tempToday;
    TextView tempMaxToday;
    TextView tempMinToday;
    TextView windToday;
    ImageView bigLogoMeteo;
    TextView descriptionMeteo;

    TextView jour1Temp;
    ImageView jour1Image;

    TextView jour2Temp;
    ImageView jour2Image;

    TextView jour3Temp;
    ImageView jour3Image;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);

        Calendar c = Calendar.getInstance();
        dateTextView =(TextView) findViewById(R.id.dateMeteo);
        DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
        dateTextView.setText(  df.format(c.getTime()));

        tempToday =(TextView) findViewById(R.id.tempToday);
        tempMaxToday =(TextView) findViewById(R.id.tempMaxToday);
        tempMinToday =(TextView) findViewById(R.id.tempMinToday);
        windToday = (TextView) findViewById(R.id.windToday);
        bigLogoMeteo = (ImageView)findViewById(R.id.bigLogoMeteo);
        descriptionMeteo =(TextView)findViewById(R.id.descriptionMeteo);
        jour1Temp = (TextView) findViewById(R.id.jour1Temp);
        jour1Image = (ImageView)findViewById(R.id.jour1Image);

        jour2Temp = (TextView) findViewById(R.id.jour2Temp);
        jour2Image = (ImageView)findViewById(R.id.jour2Image);

        jour3Temp = (TextView) findViewById(R.id.jour3Temp);
        jour3Image = (ImageView)findViewById(R.id.jour3Image);
        GetWeatherToday task = new GetWeatherToday();
        task.execute(new String[]{});

        GetWeatherNext task2 = new GetWeatherNext();
        task2.execute(new String[]{});
    }

    private class GetWeatherToday extends AsyncTask<String, Void, String> {

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
           //     home_no_weather_icon.setVisibility(View.VISIBLE);
           //     home_no_weather.setVisibility(View.VISIBLE);
            }
            else
            {
                JSONObject jObj = null;
                try
                {
                    jObj = new JSONObject(output.toString());
                    JSONObject jMain = jObj.getJSONObject("main");
                    int temp = (int)(jMain.getDouble("temp") -273.15) ;
                    tempToday.setText("" + temp + "°C");

                    int tempMax = (int)(jMain.getDouble("temp_max") -273.15) ;
                    tempMaxToday.setText("" + tempMax + "°C");

                    int tempMin = (int)(jMain.getDouble("temp_min") -273.15) ;
                    tempMinToday.setText("" + tempMin + "°C");

                    JSONObject jWind = jObj.getJSONObject("wind");
                    int wind = (int) (jWind.getDouble("speed"));
                    windToday.setText("" + wind + "M/S");

                    JSONArray jArr = jObj.getJSONArray("weather");
                    JSONObject jWeather = jArr.getJSONObject(0);
                    descriptionMeteo.setText((String) jWeather.get("description"));
                    String icon = (String) jWeather.get("icon");
                    changeIconBig(icon, bigLogoMeteo  );

                 } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

    }


    private class GetWeatherNext extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String output = null ;
            WeatherManager weaterManager = new WeatherManager();
            try {
                output = weaterManager.getJSONNextDay();
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
                //     home_no_weather_icon.setVisibility(View.VISIBLE);
                //     home_no_weather.setVisibility(View.VISIBLE);
            }
            else
            {
                JSONObject jObj = null;
                try
                {
                    jObj = new JSONObject(output.toString());
                    JSONArray jArr = jObj.getJSONArray("list");
                    JSONObject jtemp;
                    int min;
                    int max;
                    JSONArray jLogoTab;
                    JSONObject jLogo;

                    /*jour 1*/
                    JSONObject jour1 = jArr.getJSONObject(0);

                    jtemp =jour1.getJSONObject("temp");
                    min = (int)(jtemp.getDouble("min") -273.15) ;
                    max = (int )(jtemp.getDouble("max") -273.15) ;
                    jour1Temp.setText("" + min + "/" + max + "°C");

                    jLogoTab = jour1.getJSONArray("weather");
                    jLogo = jLogoTab.getJSONObject(0);
                    changeIcon(jLogo.getString("icon"),jour1Image );

                    /*jour 2*/
                    JSONObject jour2 = jArr.getJSONObject(1);
                    jtemp =jour2.getJSONObject("temp");
                    min = (int)(jtemp.getDouble("min") -273.15) ;
                    max = (int )(jtemp.getDouble("max") -273.15) ;
                    jour2Temp.setText("" + min + "/" + max + "°C");

                    jLogoTab = jour2.getJSONArray("weather");
                    jLogo = jLogoTab.getJSONObject(0);
                    changeIcon(jLogo.getString("icon"),jour2Image );

                    /*jour 3*/
                    JSONObject jour3 = jArr.getJSONObject(2);
                    jtemp =jour3.getJSONObject("temp");
                    min = (int)(jtemp.getDouble("min") -273.15) ;
                    max = (int )(jtemp.getDouble("max") -273.15) ;
                    jour3Temp.setText("" + min + "/" + max + "°C");

                    jLogoTab = jour3.getJSONArray("weather");
                    jLogo = jLogoTab.getJSONObject(0);
                    changeIcon(jLogo.getString("icon"),jour3Image );
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    protected  void changeIcon (String icon , ImageView weather_icon )
    {
        if (icon.equals("01d"))
            weather_icon.setImageResource(R.drawable.forecast_01d);

        else if (icon.equals("01n"))
            weather_icon.setImageResource(R.drawable.forecast_01n);

        else if (icon.equals("02d"))
            weather_icon.setImageResource(R.drawable.forecast_02d);

        else if (icon.equals("02n"))
            weather_icon.setImageResource(R.drawable.forecast_02n);

        else if (icon.equals("03d"))
            weather_icon.setImageResource(R.drawable.forecast_03d);

        else if (icon.equals("03n"))
            weather_icon.setImageResource(R.drawable.forecast_03n);

        else if (icon.equals("04d"))
            weather_icon.setImageResource(R.drawable.forecast_04d);

        else if (icon.equals("04n"))
            weather_icon.setImageResource(R.drawable.forecast_04n);

        else if (icon.equals("09d"))
            weather_icon.setImageResource(R.drawable.forecast_09d);

        else if (icon.equals("09n"))
            weather_icon.setImageResource(R.drawable.forecast_09n);

        else if (icon.equals("10d"))
            weather_icon.setImageResource(R.drawable.forecast_10d);

        else if (icon.equals("10n"))
            weather_icon.setImageResource(R.drawable.forecast_10n);

        else if (icon.equals("11d"))
            weather_icon.setImageResource(R.drawable.forecast_11d);

        else if (icon.equals("11n"))
            weather_icon.setImageResource(R.drawable.forecast_11n);

        else if (icon.equals("13d"))
            weather_icon.setImageResource(R.drawable.forecast_13d);

        else if (icon.equals("13n"))
            weather_icon.setImageResource(R.drawable.forecast_13n);

        else if (icon.equals("50d"))
            weather_icon.setImageResource(R.drawable.forecast_50d);

        else if (icon.equals("50n"))
            weather_icon.setImageResource(R.drawable.forecast_50n);
    }

    protected  void changeIconBig (String icon , ImageView weather_icon )
    {
        if (icon.equals("01d"))
            weather_icon.setImageResource(R.drawable.forecast_01d_big);

        else if (icon.equals("01n"))
            weather_icon.setImageResource(R.drawable.forecast_01n);

        else if (icon.equals("02d"))
            weather_icon.setImageResource(R.drawable.forecast_02d_big);

        else if (icon.equals("02n"))
            weather_icon.setImageResource(R.drawable.forecast_02n_big);

        else if (icon.equals("03d"))
            weather_icon.setImageResource(R.drawable.forecast_03d_big);

        else if (icon.equals("03n"))
            weather_icon.setImageResource(R.drawable.forecast_03n_big);

        else if (icon.equals("04d"))
            weather_icon.setImageResource(R.drawable.forecast_04d_big);

        else if (icon.equals("04n"))
            weather_icon.setImageResource(R.drawable.forecast_04n_big);

        else if (icon.equals("09d"))
            weather_icon.setImageResource(R.drawable.forecast_09d_big);

        else if (icon.equals("09n"))
            weather_icon.setImageResource(R.drawable.forecast_09n_big);

        else if (icon.equals("10d"))
            weather_icon.setImageResource(R.drawable.forecast_10d_big);

        else if (icon.equals("10n"))
            weather_icon.setImageResource(R.drawable.forecast_10n_big);

        else if (icon.equals("11d"))
            weather_icon.setImageResource(R.drawable.forecast_11d_big);

        else if (icon.equals("11n"))
            weather_icon.setImageResource(R.drawable.forecast_11n_big);

        else if (icon.equals("13d"))
            weather_icon.setImageResource(R.drawable.forecast_13d_big);

        else if (icon.equals("13n"))
            weather_icon.setImageResource(R.drawable.forecast_13n_big);

         else if (icon.equals("50d"))
            weather_icon.setImageResource(R.drawable.forecast_50d_big);

        else if (icon.equals("50n"))
            weather_icon.setImageResource(R.drawable.forecast_50n_big);
    }
}
