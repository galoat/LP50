package projetlp50.utbm.com.belfortcity.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import projetlp50.utbm.com.belfortcity.getIp.AdresseIp;

/**
 * Created by galoat on 28/12/15.
 */
public class MapServlet {
    public String listePosition() throws IOException {


        InputStream stream = null;
        URL url = new URL("http://" + AdresseIp.IP + ":8080/WebServiceLp50/ServletListePosition");
        URLConnection connection = url.openConnection();
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
