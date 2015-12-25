package projetlp50.utbm.com.belfortcity.eat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import projetlp50.utbm.com.belfortcity.getIp.AdresseIp;

/**
 * Created by galoat on 24/12/15.
 */
public class Servlet_Eat {

    public String listeEnjoy() throws IOException {


        InputStream stream = null;
        URL url = new URL("http://" + AdresseIp.IP + ":8080/WebServiceLp50/getListeEnjoy");
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

    public String EnjoyID(int ID) throws IOException {


        InputStream stream = null;
        URL url = new URL("http://" + AdresseIp.IP + ":8080/WebServiceLp50/getEnjoyById");
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

    public String addComment(int ID,String name,String comm) throws IOException {


        InputStream stream = null;
        URL url = new URL("http://" + AdresseIp.IP + ":8080/WebServiceLp50/addCommentaireEnjoyById?id="+ID+"&comment"+comm+"&user="+name);
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



    public String addNote(int note,int ID) throws IOException {


        InputStream stream = null;
        URL url = new URL("http://" + AdresseIp.IP + ":8080/WebServiceLp50/addNoteEnjoyById?id="+ID+"&note"+note);
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
