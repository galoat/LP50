package projetlp50.utbm.com.belfortcity.map;

import projetlp50.utbm.com.belfortcity.R;
import projetlp50.utbm.com.belfortcity.eat.Eat_moreInformation;
import projetlp50.utbm.com.belfortcity.eat.Servlet_Eat;
import projetlp50.utbm.com.belfortcity.meteo.MeteoServlet;

import  com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Map extends AppCompatActivity {
    GoogleMap map;
    static final LatLng Belfort = new LatLng(47.6333, 6.8667);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map=googleMap;
                //ajoute un marker sur Paris
                googleMap.addMarker(new MarkerOptions().title("Belfort").position(Belfort));
                     //centre la google map sur Paris (avec animation de zoom)
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Belfort, 15));
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
                GetElements task = new GetElements();
                task.execute(new String[]{});
            }
        });
    }




    private class GetElements extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String output = null;
            MeteoServlet sManager = new MeteoServlet();
            try {
                output = sManager.listePosition();
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
               try {
                    jObj = new JSONObject(output.toString());
                    JSONArray jsonArray = jObj.optJSONArray("Position");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        map.addMarker(new MarkerOptions().title(jsonObject.getString("name")).position(new LatLng(jsonObject.getDouble("position_x"),jsonObject.getDouble("position_y"))));

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        }
    }
}

