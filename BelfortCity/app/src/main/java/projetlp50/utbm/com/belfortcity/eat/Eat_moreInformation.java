package projetlp50.utbm.com.belfortcity.eat;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import projetlp50.utbm.com.belfortcity.R;
import projetlp50.utbm.com.belfortcity.calendar.Calendar_Servlet;

/**
 * Created by galoat on 25/12/15.
 */
public class Eat_moreInformation extends AppCompatActivity {
    private int id;
    private int note;
    private  Intent intent;
    private String name;
    private String comm;
    private LayoutInflater layoutInflater;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_more_information);
        intent= this.getIntent();
        id = intent.getIntExtra("ID", -1);
        layoutInflater=this.getLayoutInflater();
        GetElements task = new GetElements();
        task.execute(new String[]{});

        LinearLayout layoutPrincipal =(LinearLayout)findViewById(R.id.layoutAjout);
        ViewGroup ajout = (ViewGroup) this.getLayoutInflater().inflate(R.layout.activity_eat_add_comment, null);
        final EditText pseudo =(EditText)ajout.findViewById(R.id.textpseudo);

        final RatingBar noteBar = (RatingBar)ajout.findViewById(R.id.Note);
        final EditText commentaire = (EditText)ajout.findViewById(R.id.textcomment);

        Button boutton =(Button)ajout.findViewById(R.id.envoyer);
        boutton.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           LinearLayout layoutPrincipal = (LinearLayout) findViewById(R.id.layoutComm);
                                           if (pseudo.getText().toString() != "" && commentaire.getText().toString() != "") {
                                               ViewGroup comment = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_calendar_more_info_comment, null);
                                               TextView commentairNom = (TextView) comment.findViewById(R.id.TextCommentaireNom);
                                               commentairNom.setText(pseudo.getText());
                                               name = pseudo.getText().toString();
                                               TextView commentcorp = (TextView) comment.findViewById(R.id.TextCommentaire);
                                               commentcorp.setText(commentaire.getText());
                                               comm = commentaire.getText().toString();
                                               AddElements task = new AddElements();
                                               task.execute(new String[]{});
                                               note = (int) noteBar.getRating();


                                               AddNote task2 = new AddNote();
                                               task2.execute(new String[]{});
                                             pseudo.setText("");
                                               commentaire.setText("");
                                               layoutPrincipal.addView(comment);
                                           }

                                       }
                                   }
        );

        layoutPrincipal.addView(ajout);

    }
    private class AddElements extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String output = null;
            Servlet_Eat sManager = new Servlet_Eat();
            try {
                output = sManager.addComment(id, name, comm);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return output;
        }
    }

    private class AddNote extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String output = null;
            Servlet_Eat sManager = new Servlet_Eat();
            try {
                output = sManager.addNote(note,id);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return output;
        }
    }

    private class GetElements extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String output = null;
            Servlet_Eat sManager = new Servlet_Eat();
            try {
                output = sManager.EnjoyID(id);
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

                    TextView titre =(TextView) findViewById(R.id.texteTitre);
                    titre.setText(jObj.getString("NAME"));
                   TextView  textDescription=(TextView) findViewById(R.id.TextDescription);
                    textDescription.setText(jObj.getString("DESCRIPTION")+" \n\n\n horraire Lundi "+jObj.getString("HORRAIRE_LUNDI")+"\n horraire mardi"+jObj.getString("HORRAIRE_MARDI")+ "\n horraire mercredi : "+jObj.getString("HORRAIRE_MERCREDI")+" \n horraire jeudi :"+jObj.getString("HORRAIRE_JEUDI")+"\n horraire vendredi :"+jObj.getString("HORRAIRE_VENDREDI")+"\n horraire samedi :"+jObj.getString("HORRAIRE_SAMEDI")+"\n horraire Dimanche "+jObj.getString("HORRAIRE_DIMANCHE"));


                    LinearLayout layoutPrincipal =(LinearLayout)findViewById(R.id.layoutComm);

                    JSONArray jsonArray = jObj.optJSONArray("ListeComment");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ViewGroup comment = (ViewGroup) layoutInflater.inflate(R.layout.activity_calendar_more_info_comment, null);
                        TextView  commentairNom=(TextView) comment.findViewById(R.id.TextCommentaireNom);
                        commentairNom.setText(jsonObject.getString("user"));
                        TextView  commentcorp=(TextView) comment.findViewById(R.id.TextCommentaire);
                        commentcorp.setText(jsonObject.getString("commentaire"));
                        layoutPrincipal.addView(comment);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        }
    }
}
