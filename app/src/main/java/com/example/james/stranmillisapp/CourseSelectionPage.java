package com.example.james.stranmillisapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class CourseSelectionPage extends MainPage {

    TabHost tabHost;

    String JSON_STRING;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_selection_page);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1 - Key
        TabHost.TabSpec spec = host.newTabSpec("");
        spec.setContent(R.id.tab1);
        spec.setIndicator("");
        host.addTab(spec);

        //Tab 2 - Culture and Arts
        spec = host.newTabSpec("1");
        spec.setContent(R.id.tab2);
        spec.setIndicator("1");
        host.addTab(spec);
        loadJSON();

        //Tab 3 - General Interest
        spec = host.newTabSpec("2");
        spec.setContent(R.id.tab3);
        spec.setIndicator("2");
        host.addTab(spec);

        //Tab 4 - Health
        spec = host.newTabSpec("3");
        spec.setContent(R.id.tab4);
        spec.setIndicator("3");
        host.addTab(spec);

        //Tab 4 - History
        spec = host.newTabSpec("4");
        spec.setContent(R.id.tab5);
        spec.setIndicator("4");
        host.addTab(spec);

        //Tab 4 - Languages
        spec = host.newTabSpec("5");
        spec.setContent(R.id.tab6);
        spec.setIndicator("5");
        host.addTab(spec);

        //Tab 4 - Literature
        spec = host.newTabSpec("6");
        spec.setContent(R.id.tab7);
        spec.setIndicator("6");
        host.addTab(spec);

        //Tab 4 - Visual Arts
        spec = host.newTabSpec("7");
        spec.setContent(R.id.tab8);
        spec.setIndicator("7");
        host.addTab(spec);
    }

    public void loadJSON() {

        new BackgroundTask().execute();

    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String json_url;

        @Override
        protected void onPreExecute() {
            json_url = "http://10.0.2.2/stran_app/select_from_table.php";
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while((JSON_STRING = bufferedReader.readLine()) != null) {

                    stringBuilder.append(JSON_STRING+"\n");

                }

                String finalJson = stringBuilder.toString();

                JSONObject parentObject = new JSONObject(finalJson);

                JSONArray parentArray = parentObject.getJSONArray("result");

                JSONObject finalObject = parentArray.getJSONObject(0);

                String email = finalObject.getString("email_address");
                String name = finalObject.getString("name");
                String password = finalObject.getString("password");


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return email + " " + name + " " + password;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = (TextView)findViewById(R.id.json);
            textView.setText(result);

        }
    }

    public void backButtonClick(View v) {
        startActivity(new Intent(CourseSelectionPage.this, MainPage.class));
    }

}
