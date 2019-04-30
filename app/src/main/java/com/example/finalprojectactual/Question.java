package com.example.finalprojectactual;
import android.app.AppComponentFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;
import android.widget.ImageView;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
public class Question extends AppCompatActivity {
    /**
     * Query is the question
     * options are all 4 answers so use these for buttons
     * rightOne is for the function so dont use it.
     */
    private String query;
    private String[] options = new String[4];
    private String wrongOnes;
    private String rightOne;
    public Question(String xmlFromCarrot) throws ParserConfigurationException, IOException, SAXException {
        if (xmlFromCarrot == null) {
            System.out.println("invalid input");
            return;
        }
        DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
        DocumentBuilder doc = build.newDocumentBuilder();
        StringBuilder build2 = new StringBuilder();
        build2.append("<?xml version= 1.0?> <class> </class>");
        ByteArrayInputStream carrot = new ByteArrayInputStream(build2.toString().getBytes("UTF-8"));
        Document dokument = doc.parse(carrot);
        Element root = dokument.getDocumentElement();
        org.w3c.dom.NamedNodeMap parsed = dokument.getAttributes();
        query = parsed.getNamedItem("question").toString();
        rightOne = parsed.getNamedItem("correct_answer").toString();
        wrongOnes = parsed.getNamedItem("incorrect_answers").toString();
        options = wrongOnes.split(", ");
        options[3] = rightOne;
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button question = findViewById(R.id.Quest);
        question.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), query,Toast.LENGTH_LONG).show();
            }
        });

    }
    /**
     *
     * @param answer the answer that the player selected
     * @return true if it is the right answer, false otherwise
     */
    public boolean isCorrect(String answer) {
        if (answer.equals(rightOne)) {
            return true;
        }
        return false;
    }

}