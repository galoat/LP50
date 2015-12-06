package projetlp50.utbm.com.belfortcity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by galoat on 17/11/15.
 */
public class Calendar extends AppCompatActivity {
        

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calendar);
            SetDateTextView();
        }
    public void SetDateTextView(){
        CalendarView c =(CalendarView)  findViewById(R.id.calendarView);
        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){

            public void onSelectedDayChange(CalendarView view,int year,int month,int dayOfMonth){
                Intent i = new Intent(Calendar.this,Calendar_day.class);

                i.putExtra("day",dayOfMonth);
                i.putExtra("month",month);
                i.putExtra("year",year);
                startActivity(i);
            }
        });
    }
}






