package projetlp50.utbm.com.belfortcity.getIp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import projetlp50.utbm.com.belfortcity.MeteoActivity;
import projetlp50.utbm.com.belfortcity.R;
import projetlp50.utbm.com.belfortcity.mainPage.MainActivity;

/**
 * Created by galoat on 15/12/15.
 */
public class activiityIp extends AppCompatActivity {
    EditText ip;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_adresse_ip);
        ip =(EditText)findViewById(R.id.adresseIP);
        Button validé =(Button)findViewById(R.id.button);
        validé.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdresseIp.IP=ip.getText().toString();
                Intent intent = new Intent(activiityIp.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
