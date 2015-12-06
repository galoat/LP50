package projetlp50.utbm.com.belfortcity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by galoat on 06/12/15.
 */
public class Calendar_day_fragment extends Fragment {
    @Nullable

    protected final static SimpleDateFormat dateSortie = new SimpleDateFormat("EEE ,d,MMM");
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
        TextView [] text = new TextView[NbEvenement];
        LinearLayout[] ligne = new LinearLayout[NbEvenement];
        LinearLayout insideScroll =(LinearLayout) rootView.findViewById(R.id.scrollLayout);

        for(int i =0;i<NbEvenement;i++){
            text[i] = new TextView(getActivity());
            ligne[i]= new LinearLayout(getActivity());
            text[i].setTextSize(25);
            text[i].setText(" je suis une textView nufrefuirbgbvrtuibcierbfvfhsbdvu rtbdgfivbtdfigbvtiufbv idbvfibdwfuicbdifbviugbvuifbtxgcivbgfixcbvixdbfgvijkbdxfjikbvngficjbnvuifdbgxvij");
            text[i].setClickable(true);
            text[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(  getActivity(),Calendar_MoreInformation.class);
                    intent.putExtra("ID", 1);
                    startActivity(intent);
                }
            });
            //         text[i].setSingleLine();
            text[i].setEllipsize(TextUtils.TruncateAt.MARQUEE);
            ligne[i].addView(text[i]);

            insideScroll.addView(ligne[i]);
        }
        return  rootView;
    }

    public static String formatDate(Date date){
        return  dateSortie.format(date);
    }


}
