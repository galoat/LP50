package projetlp50.utbm.com.belfortcity.calendar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import projetlp50.utbm.com.belfortcity.R;

/**
 * Created by galoat on 01/12/15.
 */
public class Calendar_MoreInformation extends AppCompatActivity {
    private int nbCommentaire;
    private int id;
    private  Intent intent;
    private LayoutInflater layoutInflater;
    private String name;
    private String comm;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_mor_information_in);
       intent= this.getIntent();
        layoutInflater=this.getLayoutInflater();
       id = intent.getIntExtra("ID", -1);
        GetElements task = new GetElements();
        task.execute(new String[]{});

        LinearLayout layoutPrincipal =(LinearLayout)findViewById(R.id.layoutAjout);
        ViewGroup ajout = (ViewGroup) this.getLayoutInflater().inflate(R.layout.activity_calendar_add_comment, null);
        final EditText pseudo =(EditText)ajout.findViewById(R.id.textpseudo);
        final EditText commentaire = (EditText)ajout.findViewById(R.id.textcomment);
        Button boutton =(Button)ajout.findViewById(R.id.envoyer);
        boutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LinearLayout layoutPrincipal = (LinearLayout) findViewById(R.id.layoutComm);

            if (pseudo.getText() != null && commentaire.getText() != null) {

                ViewGroup comment = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_calendar_more_info_comment, null);
                TextView commentairNom = (TextView) comment.findViewById(R.id.TextCommentaireNom);
                commentairNom.setText(pseudo.getText());
                name=pseudo.getText().toString();
                TextView commentcorp = (TextView) comment.findViewById(R.id.TextCommentaire);
                commentcorp.setText(commentaire.getText());
                comm = commentaire.getText().toString();
                AddElements task = new AddElements();
                task.execute(new String[]{});
                pseudo.append("");
                commentaire.append("");
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



    private class GetElements extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String output = null ;
            Calendar_Servlet sManager = new Calendar_Servlet();
            try {
                output = sManager.ListeComment(id);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return output;
        }

        @Override
        protected void onPostExecute(String output)
        {
            if (output =="")
            {

            }
            else
            {
                JSONObject jObj = null;
                try
                {
                    jObj = new JSONObject(output.toString());
                    nbCommentaire = (int)(jObj.getDouble("NbrComment")) ;
                     TextView titre =(TextView) findViewById(R.id.texteTitre);
                    titre.setText(jObj.getString("Name"));
                    final TextView  textDate=(TextView) findViewById(R.id.TextDate);
                    textDate.setText(jObj.getInt("HeureD")+"H"+jObj.getInt("MinuteD")+"--"+jObj.getInt("HeureF")+"H"+jObj.getInt("MinuteF"));
                    TextView  textDescription=(TextView) findViewById(R.id.TextDescription);
                    textDescription.setText(jObj.getString("Description"));
                    LinearLayout layoutPrincipal =(LinearLayout)findViewById(R.id.layoutComm);

                    JSONArray jsonArray = jObj.optJSONArray("ListeComment");
                    for(int i=0; i < jsonArray.length(); i++) {
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
    private class AddElements extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String output = null;
            Calendar_Servlet sManager = new Calendar_Servlet();
            try {
                output = sManager.addComment(id, name, comm);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return output;
        }
    }

}