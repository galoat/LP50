package projetlp50.utbm.com.belfortcity.calendar;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.Inflater;

import projetlp50.utbm.com.belfortcity.R;
import projetlp50.utbm.com.belfortcity.getIp.AdresseIp;
import projetlp50.utbm.com.belfortcity.weather.WeatherManager;

/**
 * Created by galoat on 06/12/15.
 */
public class Calendar_day_fragment extends Fragment {
    private int day;
    private int month;
    private int year;
    protected int NbEvenement;
    protected final static SimpleDateFormat dateSortie = new SimpleDateFormat("EEEE d,MMMMMMM");
    protected TextView textTitre;
    protected TextView textDate;
    protected  TextView textDescription;
    protected ViewGroup rootView;
    private LayoutInflater inflater;
    private ViewGroup container;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= (ViewGroup) inflater.inflate(R.layout.activity_calendar_day, container, false);
        Bundle savedInstanceStates = this.getArguments();
        day = savedInstanceStates.getInt("day");
        month = savedInstanceStates.getInt("month");
        year = savedInstanceStates.getInt("year");
        TextView texteJournée = (TextView) rootView.findViewById(R.id.Journée);
        this.inflater=inflater;
        this.container=container;
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, day);

        texteJournée.setText(formatDate(cal.getTime()));
        GetElements task = new GetElements();
        task.execute(new String[]{});

        return rootView;
    }

    public static String formatDate(Date date) {
        return dateSortie.format(date);
    }



//TO DO voir en Syncro
    private class GetElements extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String output = null ;
            Calendar_Servlet sManager = new Calendar_Servlet();
            try {
                output = sManager.ListeEvenement(year,month,day);
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
                {      LinearLayout insideScroll = (LinearLayout) rootView.findViewById(R.id.scrollLayout);
                    jObj = new JSONObject(output.toString());
                     NbEvenement = (int)(jObj.getDouble("nombre")) ;
                    JSONArray jsonArray = jObj.optJSONArray("Evenement");
                        for(int i=0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int minuteD =   jsonObject.getInt("MinuteD");
                            String type = jsonObject.getString("Types");
                            String Description =  jsonObject.getString("Description");
                            int minuteF =jsonObject.getInt("MinuteF");
                            int heureF =jsonObject.getInt("HeureF");
                            final int ID = jsonObject.getInt("ID");
                            String Name = jsonObject.getString("Name");
                            int heureD = jsonObject.getInt("HeureDee");
                            // GEstion de la vue
                            ViewGroup vueText = (ViewGroup) inflater.inflate(R.layout.activity_calendar_layout_scroll, container, false);
                            textTitre = (TextView) vueText.findViewById(R.id.texteTitre);
                            textTitre.setText(type);
                            textDate = (TextView) vueText.findViewById(R.id.TextDate);
                            textDate.setText(heureD +"H"+minuteD+"=="+heureF+"H"+minuteF);
                            textDescription = (TextView) vueText.findViewById(R.id.textDescription);
                            textDescription.setText(Description);
                            textDescription.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(getActivity(), Calendar_MoreInformation.class);
                                    intent.putExtra("ID", ID);
                                    startActivity(intent);
                                }
                            });
                            insideScroll.addView(vueText);
                        }






                        } catch (JSONException e) {
                    e.printStackTrace();
                }


              }
        }

    }



}
