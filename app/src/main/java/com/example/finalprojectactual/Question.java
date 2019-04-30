package com.example.finalprojectactual;

import java.io.ByteArrayInputStream;
import org.w3c.dom.*;
import java.io.*;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Question extends MainActivity {
    /**
     * Query is the question
     * options are all 4 answers so use these for buttons
     * rightOne is for the function so dont use it.
     */
    private String query;
    private String[] options = new String[4];
    private String wrongOnes;
    private String rightOne;
    public Question(String xmlFromCarrot) {
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
}