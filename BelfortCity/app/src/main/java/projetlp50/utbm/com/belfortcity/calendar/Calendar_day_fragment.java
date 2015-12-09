package projetlp50.utbm.com.belfortcity.calendar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.*;

import projetlp50.utbm.com.belfortcity.R;

/**
 * Created by galoat on 06/12/15.
 */
public class Calendar_day_fragment extends Fragment {



    protected final static SimpleDateFormat dateSortie = new SimpleDateFormat("EEEE d,MMMMMMM");
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_calendar_day,container,false);
        Bundle savedInstanceStates = this.getArguments();
       int  day=savedInstanceStates.getInt("day");
        int month =savedInstanceStates.getInt("month");
        int year = savedInstanceStates.getInt("year");
       TextView texteJournée = (TextView)rootView.findViewById(R.id.Journée);

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, day);

        texteJournée.setText(formatDate(cal.getTime()));

       int  NbEvenement= 3;

        LinearLayout insideScroll =(LinearLayout) rootView.findViewById(R.id.scrollLayout);

        for(int i =0;i<NbEvenement;i++){
            ViewGroup vueText =(ViewGroup)  inflater.inflate(R.layout.activity_calendar_layout_scroll, container, false);
            TextView textTitre =(TextView)vueText.findViewById(R.id.texteTitre);
            textTitre.setText("LE TITRE");
            TextView textDate =(TextView)vueText.findViewById(R.id.TextDate);
            textDate.setText(" 10 H 00");

            TextView textDescription =(TextView)vueText.findViewById(R.id.textDescription);
            textDescription.setText("Mandatum multorum villam occiduntur scilicet fractis per actitata nulla suam est fortunas dilatata Crateras lapide villam ad non cum ut occiduntur quarto dilatata ambo multiplices fortunas ad ambigerentur ut vicensimo scilicet scilicet et ad ab acti ut et occiduntur lapide filius cum Crateras post igitur acti suam Crateras filius et exilium ut et quaedam ambigerentur villam villam et nulla pater acti suam multorum quae multiplices disiungitur cruribus scilicet ab scilicet ambigerentur per cum in lapide exilium et pater levius lapide constaret igitur multiplices occiduntur clades et occiduntur cum est ambo Apollinares cum Antiochia ab ambigerentur fractis acti scilicet cruribus post.Mandatum multorum villam occiduntur scilicet fractis per actitata nulla suam est fortunas dilatata Crateras lapide villam ad non cum ut occiduntur quarto dilatata ambo multiplices fortunas ad ambigerentur ut vicensimo scilicet scilicet et ad ab acti ut et occiduntur lapide filius cum Crateras post igitur acti suam Crateras filius et exilium ut et quaedam ambigerentur villam villam et nulla pater acti suam multorum quae multiplices disiungitur cruribus scilicet ab scilicet ambigerentur per cum in lapide exilium et pater levius lapide constaret igitur multiplices occiduntur clades et occiduntur cum est ambo Apollinares cum Antiochia ab ambigerentur fractis acti scilicet cruribus post.");
            textDescription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Calendar_MoreInformation.class);
                    intent.putExtra("ID", 1);
                    startActivity(intent);
                }
            });



            insideScroll.addView(vueText);

        }
        return  rootView;
    }

    public static String formatDate(Date date){
        return  dateSortie.format(date);
    }


}
