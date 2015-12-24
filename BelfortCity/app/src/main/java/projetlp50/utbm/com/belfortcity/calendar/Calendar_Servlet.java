package projetlp50.utbm.com.belfortcity.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import projetlp50.utbm.com.belfortcity.getIp.AdresseIp;

/**
 * Created by galoat on 22/12/15.
 */
public class Calendar_Servlet {


    public String ListeEvenement(int year,int month,int day) throws IOException{


        InputStream stream = null;
       URL url = new URL("http://" + AdresseIp.IP + ":8080/WebServiceLp50/getListeEvenementByDate?year="+year+"&month="+(month+1)+"&day="+day);
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

    public String ListeComment(int id) throws IOException{


        InputStream stream = null;

        URL url = new URL("http://" + AdresseIp.IP + ":8080/WebServiceLp50/getEvenmentById");
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

