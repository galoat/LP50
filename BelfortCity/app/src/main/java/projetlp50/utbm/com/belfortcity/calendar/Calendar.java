package projetlp50.utbm.com.belfortcity.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

import java.util.Date;

import projetlp50.utbm.com.belfortcity.R;

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
        java.util.Calendar calendrier = java.util.Calendar.getInstance();

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






