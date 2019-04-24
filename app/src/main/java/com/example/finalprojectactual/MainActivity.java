package com.example.finalprojectactual;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.net.URL;
import java.net.*;
import java.net.HttpURLConnection;
//package javax.net.ssl;
import javax.net.*;
import java.net.MalformedURLException;
import java.security.cert.Certificate;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
/**need to add stuff
 *
 */
public class MainActivity extends AppCompatActivity {


    public String getApi() {
        String https_url = "https://opentdb.com/api.php?amount=10";
        URL url;
        try {
            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //HttpsURLConnection triviaConnection("https://opentdb.com/api.php?amount=10");
    //InputStream triviaStream = triviaConnection.getInputStream();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * functions for button (onClickListener etc)
         */
        final Context context = getApplicationContext();
        final Button choice = findViewById(R.id.Category);
        final int duration = Toast.LENGTH_LONG;
        choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Category Button",duration).show();
            }
        });
    }
}