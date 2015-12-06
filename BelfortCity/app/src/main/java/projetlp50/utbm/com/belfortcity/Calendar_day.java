package projetlp50.utbm.com.belfortcity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

/**
 * Created by galoat on 24/11/15.
 */
public class Calendar_day extends AppCompatActivity {
    private int day;
    private int month;
    private int year;
    private int NbEvenement;
    protected final static SimpleDateFormat dateSortie = new SimpleDateFormat("EEE ,d,MMM");
    @Override
       public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_day);
        final Intent intent= getIntent();
         day=intent.getIntExtra("day", -1);
         month =intent.getIntExtra("month",-1);
        year = intent.getIntExtra("year",-1);
        TextView texteJournée = (TextView)findViewById(R.id.Journée);

        java.util.Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
         texteJournée.setText(formatDate(cal.getTime()));



        NbEvenement= 3;
        setTextView();
    }
    public static String formatDate(Date date){
      return  dateSortie.format(date);
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    /*

         */
    protected void setTextView(){
        TextView [] text = new TextView[NbEvenement];
        LinearLayout[] ligne = new LinearLayout[NbEvenement];
        LinearLayout insideScroll =(LinearLayout) findViewById(R.id.scrollLayout);

        for(int i =0;i<NbEvenement;i++){
            text[i] = new TextView(this);
            ligne[i]= new LinearLayout(this);
            text[i].setTextSize(25);
            text[i].setText(" je suis une textView nufrefuirbgbvrtuibcierbfvfhsbdvu rtbdgfivbtdfigbvtiufbv idbvfibdwfuicbdifbviugbvuifbtxgcivbgfixcbvixdbfgvijkbdxfjikbvngficjbnvuifdbgxvij");
            text[i].setClickable(true);
            text[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Calendar_day.this, Calendar_MoreInformation.class);
                    intent.putExtra("ID", getDay());
                    startActivity(intent);
                }
            });
   //         text[i].setSingleLine();
            text[i].setEllipsize(TextUtils.TruncateAt.MARQUEE);
            ligne[i].addView(text[i]);

            insideScroll.addView(ligne[i]);
           }

    }



}
