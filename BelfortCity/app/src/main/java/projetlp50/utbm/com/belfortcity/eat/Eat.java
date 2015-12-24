package projetlp50.utbm.com.belfortcity.eat;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import projetlp50.utbm.com.belfortcity.R;
import projetlp50.utbm.com.belfortcity.calendar.Calendar_MoreInformation;
import projetlp50.utbm.com.belfortcity.calendar.Calendar_Servlet;

/**
 * Created by galoat on 24/12/15.
 */
public class Eat extends FragmentActivity {
    private LayoutInflater inflater;
    protected ViewGroup rootView;
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);
        this.inflater=this.getLayoutInflater();
        GetElements task = new GetElements();
        task.execute(new String[]{});
    }


    private class GetElements extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String output = null;
            Servlet_Eat sManager = new Servlet_Eat();
            try {
                output = sManager.listeEnjoy();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return output;
        }

        @Override
        protected void onPostExecute(String output) {
            if (output == "") {

            } else {
                JSONObject jObj = null;
                LinearLayout layoutPrincipal = (LinearLayout) findViewById(R.id.scrollLayout);
                try {
                    jObj = new JSONObject(output.toString());
                    JSONArray jsonArray = jObj.optJSONArray("Enjoy");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String Description =  jsonObject.getString("DESCRIPTION");
                        String nom = jsonObject.getString("NAME");
                        String type = jsonObject.getString("TYPE");

                        ViewGroup vueText = (ViewGroup) inflater.inflate(R.layout.activity_eat_scroll, null);
                        TextView textTitre = (TextView) vueText.findViewById(R.id.texteTitre);
                        textTitre.setText(type);
                        TextView  textDescription = (TextView) vueText.findViewById(R.id.textDescription);
                        textDescription.setText(Description);
                        layoutPrincipal.addView(vueText);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        }
    }
}

