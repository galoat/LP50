package projetlp50.utbm.com.myapplicationservlet;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private TextView textViewToChange ;
    private static  String url ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewToChange = (TextView) findViewById(R.id.textView);

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText  mEdit   = (EditText)findViewById(R.id.edittext);
                String ip = mEdit.getText().toString() ;

                url = "http://" +ip + ":8084/WebServiceLp50/Evenement";
                GetXMLTask task = new GetXMLTask();
                task.execute(new String[] { url });
            }
        });
    }

    private class GetXMLTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls)
        {
            String output = null;
            for (String url : urls)
            {
                output = getOutputFromUrl(url);
            }
            return output;
        }

        private String getOutputFromUrl(String url)
        {
            StringBuffer output = new StringBuffer("");
            try
            {
                InputStream stream = getHttpConnection(url);
                BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
                String s = "";
                while ((s = buffer.readLine()) != null)
                    output.append(s);
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
            return output.toString();
        }

        // Makes HttpURLConnection and returns InputStream
        private InputStream getHttpConnection(String urlString) throws IOException
        {
            InputStream stream = null;
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            try
            {
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestMethod("GET");
                httpConnection.connect();

                if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
                {
                    stream = httpConnection.getInputStream();
                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
            return stream;
        }

        @Override
        protected void onPostExecute(String output)
        {
            try
            {
                JSONObject jsonObject = new JSONObject(output);
                JSONArray array = new JSONArray(jsonObject.getString("Evenement"));
                for (int i = 0; i < array.length(); i++)
                {
                    JSONObject obj = new JSONObject(array.getString(i));
                    textViewToChange.setText(textViewToChange.getText() + " " + obj.getString("ID") + " " +obj.getString("Name"));

                }

            } catch (Exception e)
            {
                e.printStackTrace();
            }

           // textViewToChange.setText(output);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
