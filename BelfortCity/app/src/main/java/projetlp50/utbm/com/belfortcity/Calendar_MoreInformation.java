package projetlp50.utbm.com.belfortcity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by galoat on 01/12/15.
 */
public class Calendar_MoreInformation extends AppCompatActivity {
    private int nbCommentaire;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_more_nformation);
        final Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);
        nbCommentaire=2;
        TextView [] text = new TextView[nbCommentaire];
        LinearLayout[] ligne = new LinearLayout[nbCommentaire];
        LinearLayout insideScroll =(LinearLayout) findViewById(R.id.LinearLayoutScrollVIewCalendarMoreInformation);

        for (int i = 0; i <nbCommentaire; i++) {
            text[i] = new TextView(this);
            ligne[i]= new LinearLayout(this);
            text[i].setTextSize(25);
            text[i].setText("uirtgunun   "+ id );
            ligne[i].addView(text[i]);
            insideScroll.addView(ligne[i]);
        }

    }

    public int getNbCommentaire() {
        return nbCommentaire;
    }

    public void setNbCommentaire(int nbCommentaire) {
        this.nbCommentaire = nbCommentaire;
    }
}