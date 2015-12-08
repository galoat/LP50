package projetlp50.utbm.com.belfortcity.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WeatherManager {

    public static String url = "http://api.openweathermap.org/data/2.5/weather?q=Belfort,fr&appid=2de143494c0b295cca9337e1e96b00e0";


    public String getJSON () throws IOException {

        InputStream stream = null;
        URL urlWearther = new URL(url);
        URLConnection connection = urlWearther.openConnection();
        StringBuffer output = new StringBuffer("");

        try
        {
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();

            if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                stream = httpConnection.getInputStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
                String s = "";
                while ((s = buffer.readLine()) != null)
                    output.append(s);


            }

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return output.toString() ;
    }
}