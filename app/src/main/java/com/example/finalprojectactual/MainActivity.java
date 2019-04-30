package com.example.finalprojectactual;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.net.URL;
import java.net.*;
import java.net.HttpURLConnection;
//package javax.net.ssl;
import java.net.MalformedURLException;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
/**need to add stuff
 *
 */
public class MainActivity extends AppCompatActivity {



    public String getApi() {
        String https_url = "https://opentdb.com/api.php?amount=1";
        URL url;
        String xml = "";
        try {
            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection(); //makes the connection to open tbd
            con.setRequestMethod("GET");
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                xml = xml + output;
            }
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }

    /**
     * Testing
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        findButtons();

    }

    public void findButtons() {
        findViewById(R.id.Quest).setOnClickListener(buttonClicked);
    }

     private View.OnClickListener buttonClicked = new View.OnClickListener() {
         public void onClick(View v)  {
             if (v.getId() == R.id.Quest) {
                 startActivity(new Intent(MainActivity.this, QuestionActivity.class));
             }
         }
     };

}
//kill myself

