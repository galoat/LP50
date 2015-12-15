package projetlp50.utbm.com.belfortcity.calendar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import projetlp50.utbm.com.belfortcity.R;

/**
 * Created by galoat on 01/12/15.
 */
public class Calendar_MoreInformation extends AppCompatActivity {
    private int nbCommentaire;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_mor_information_in);
        final Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);
        nbCommentaire=10;

        TextView titre =(TextView) findViewById(R.id.texteTitre);
        titre.setText("LE TITRE");

        final TextView  textDate=(TextView) findViewById(R.id.TextDate);
        textDate.setText("l horraire !!");

        TextView  textDescription=(TextView) findViewById(R.id.TextDescription);
        textDescription.setText("la description");




        LinearLayout layoutPrincipal =(LinearLayout)findViewById(R.id.LayoutDescription);

        for (int i = 0; i <nbCommentaire; i++) {
            ViewGroup comment = (ViewGroup) this.getLayoutInflater().inflate(R.layout.activity_calendar_more_info_comment, null);
            TextView  commentairNom=(TextView) comment.findViewById(R.id.TextCommentaireNom);
            commentairNom.setText("le NOM ");
            TextView  commentcorp=(TextView) comment.findViewById(R.id.TextCommentaire);
            commentcorp.setText("le comm du mec ");
            layoutPrincipal.addView(comment);
        }



        ViewGroup ajout = (ViewGroup) this.getLayoutInflater().inflate(R.layout.activity_calendar_add_comment, null);
        final EditText pseudo =(EditText)ajout.findViewById(R.id.textpseudo);
        final EditText commentaire = (EditText)ajout.findViewById(R.id.textcomment);
        Button boutton =(Button)ajout.findViewById(R.id.envoyer);
    boutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LinearLayout layoutPrincipal = (LinearLayout) findViewById(R.id.LayoutDescription);

            if (pseudo.getText() != null && commentaire.getText() != null) {

                ViewGroup comment = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_calendar_more_info_comment, null);
                TextView commentairNom = (TextView) comment.findViewById(R.id.TextCommentaireNom);
                commentairNom.setText(pseudo.getText());
                TextView commentcorp = (TextView) comment.findViewById(R.id.TextCommentaire);
                commentcorp.setText(commentaire.getText());
                layoutPrincipal.addView(comment);
            }

        }
    }
    );

        layoutPrincipal.addView(ajout);



    }


    public int getNbCommentaire() {
        return nbCommentaire;
    }

    public void setNbCommentaire(int nbCommentaire) {
        this.nbCommentaire = nbCommentaire;
    }
}