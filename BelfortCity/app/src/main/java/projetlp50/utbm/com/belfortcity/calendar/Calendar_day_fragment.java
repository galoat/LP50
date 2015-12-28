package projetlp50.utbm.com.belfortcity.calendar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import projetlp50.utbm.com.belfortcity.R;

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
        String output = null;
        Calendar_Servlet sManager = new Calendar_Servlet();
        try {
            output = sManager.ListeEvenement(year, month, day);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override
    protected void onPostExecute(String output) {
        if (output == "") {
            //     home_no_weather_icon.setVisibility(View.VISIBLE);
            //     home_no_weather.setVisibility(View.VISIBLE);
        } else {
            JSONObject jObj = null;
            try {
                LinearLayout insideScroll = (LinearLayout) rootView.findViewById(R.id.scrollLayout);
                jObj = new JSONObject(output.toString());
                NbEvenement = (int) (jObj.getDouble("nombre"));
                JSONArray jsonArray = jObj.optJSONArray("Evenement");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int minuteD = jsonObject.getInt("MinuteD");
                    String type = jsonObject.getString("Types");
                    String Description = jsonObject.getString("Description");
                    int minuteF = jsonObject.getInt("MinuteF");
                    int heureF = jsonObject.getInt("HeureF");
                    final int ID = jsonObject.getInt("ID");
                    String Name = jsonObject.getString("Name");
                    int heureD = jsonObject.getInt("HeureDee");
                    // GEstion de la vue

                    ViewGroup vueText = (ViewGroup) inflater.inflate(R.layout.activity_calendar_layout_scroll, container, false);
                    ImageView im = (ImageView) vueText.findViewById(R.id.imageView);

                    im.setImageResource(choiIcon(jsonObject.getString("Types")));
                    textTitre = (TextView) vueText.findViewById(R.id.texteTitre);
                    textTitre.setText(type);
                    textDate = (TextView) vueText.findViewById(R.id.TextDate);
                    textDate.setText(heureD + "H" + minuteD + "==" + heureF + "H" + minuteF);
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
    private int choiIcon(String icon){
        if(icon.compareTo("soirée")==0){
            return R.drawable.fete;
        }
        else if(icon.compareTo("évènement VIP")==0){
            return R.drawable.music;
        }
        else if(icon.compareTo("pourenfant")==0){
            return R.drawable.pourenfant;
        }else if(icon.compareTo("defaut")==0) {
            return R.drawable.iconnormal;
        }
        return 0;
    }
}
