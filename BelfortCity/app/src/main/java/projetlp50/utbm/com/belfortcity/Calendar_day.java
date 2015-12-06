package projetlp50.utbm.com.belfortcity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

import static java.util.Calendar.DAY_OF_MONTH;

/**
 * Created by galoat on 24/11/15.
 */
public class Calendar_day extends FragmentActivity {
    // TO DO Creer une Date de Base
    private static final int NUM_PAGES=14;
    protected static    java.util.Calendar cal;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
       public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_calendat_day_for_scroll);
           mPager =(ViewPager) findViewById(R.id.view_pager);
            mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
           mPager.setAdapter(mPagerAdapter);
            mPager.setCurrentItem(7);


           final Intent intent= getIntent();

           int year =intent.getIntExtra("year", -1);
           int month =intent.getIntExtra("month", -1);
           int day =intent.getIntExtra("day", -1);
           cal = java.util.Calendar.getInstance();
           cal.set(year, month, day);

    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Calendar_day_fragment aEnvoyer = null ;
            switch (position){
                case 0 :aEnvoyer =functionJour(-7);
                        break;
                case 1 :aEnvoyer =functionJour(-6);
                    break;
                case 2 :aEnvoyer = functionJour(-5);
                    break;
                case 3 :aEnvoyer =functionJour(-4);
                    break;
                case 4 :aEnvoyer =functionJour(-3);
                    break;
                case 5 :aEnvoyer =functionJour(-2);
                    break;
                case 6 :aEnvoyer =functionJour(-1);
                    break;
                case 7 :aEnvoyer =functionJour(0);
                    break;
                case 8 :aEnvoyer =functionJour(1);
                    break;
                case 9 :aEnvoyer =functionJour(2);
                    break;
                case 10 :aEnvoyer =functionJour(3);
                    break;
                case 11 :aEnvoyer =functionJour(4);
                    break;
                case 12 :aEnvoyer =functionJour(5);
                    break;
                case 13 :aEnvoyer =functionJour(6);
                    break;
                case 14 :aEnvoyer =functionJour(7);
                    break;

            }

            return aEnvoyer;
        }
        private Calendar_day_fragment functionJour(int pos){
            Bundle bundle = new Bundle();
            final Intent intent= getIntent();
            cal.add(Calendar.DATE,pos);
            bundle.putInt("day",cal.get(DAY_OF_MONTH));
            bundle.putInt("month",cal.get(Calendar.MONTH));
            bundle.putInt("year", cal.get(Calendar.YEAR));
            Calendar_day_fragment aEnvoyer =  new Calendar_day_fragment();
            aEnvoyer.setArguments(bundle);
            cal.add(Calendar.DATE,-pos);
            return aEnvoyer;
        }
        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


}
