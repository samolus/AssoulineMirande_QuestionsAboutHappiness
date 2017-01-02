package com.example.pit_5.assoulinemirande_questionsabouthappiness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Extension;
import java.security.spec.ECField;

import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.checkBox2B;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.checkBox2C;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.checkBox3A;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.checkBox3B;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.checkBox3C;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.checkBoxQ1A;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.checkBoxQ1B;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.checkBoxQ1C;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.checkBoxQ2A;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.q1Love;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.q1P;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.q2P;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.q3P;

/**
 * Created by pit_5 on 15/12/2016.
 */



public class PartyQ extends Activity implements View.OnClickListener {
    CheckBox a1;
    CheckBox a2;
    CheckBox a3;
    CheckBox b1;
    CheckBox b2;
    CheckBox b3;
    CheckBox c1;
    CheckBox c2;
    CheckBox c3;
    TextView que1;
    TextView que2;
    TextView que3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partyq);
        Intent g = getIntent();

        View qu1 = findViewById(q1P);
        que1 = (TextView) qu1;
        View qu2 = findViewById(q2P);
        que2 = (TextView) qu2;
        View qu3 = findViewById(q3P);
        que3 = (TextView) qu3;



        View v1a = findViewById(checkBoxQ1A);
        a1 = (CheckBox) v1a;
        View v1b = findViewById(checkBoxQ1B);
        a2 = (CheckBox) v1b;
        View v1c = findViewById(checkBoxQ1C);
        a3 = (CheckBox) v1c;
        View v2a = findViewById(checkBoxQ2A);
        b1 = (CheckBox) v2a;
        View v2b = findViewById(checkBox2B);
        b2 = (CheckBox) v2b;
        View v2c = findViewById(checkBox2C);
        b3 = (CheckBox) v2c;
        View v3a = findViewById(checkBox3A);
        c1 = (CheckBox) v3a;
        View v3b = findViewById(checkBox3B);
        c2 = (CheckBox) v3b;
        View v3c = findViewById(checkBox3C);
        c3 = (CheckBox) v3c;

        load();
        load2();
        load3();

    }
    public void load() {
        Log.d("samuel","Quizz download 5 ");

        JSONObject jsonobj = getQuestionFromFile();

        try {
            JSONObject jsonobj2 = jsonobj.getJSONObject("Quiz about happiness");

            JSONObject jsonObjTheme = jsonobj2.getJSONObject("Party");
            JSONObject quest1 = jsonObjTheme.getJSONObject("Question");
            String q1 = quest1.getString("Q1.");
            Log.i("sam","q1. "+q1);
            que1.setText(q1);
            JSONArray op1 = quest1.getJSONArray("Options");
            String op1_0 = (String)op1.get(0);
            String op1_1 = (String)op1.get(1);
            String op1_2 = (String)op1.get(2);
            a1.setText(op1_0);
            a2.setText(op1_1);
            a3.setText(op1_2);


        } catch (Exception e) {
            Log.i("sam","e.get");
        }

    }
    public void load2() {
        Log.d("samuel", "Quizz download 5 ");

        JSONObject jsonobj = getQuestionFromFile();

        try {
            JSONObject jsonobj2 = jsonobj.getJSONObject("Quiz about happiness");

            JSONObject jsonObjTheme = jsonobj2.getJSONObject("Party");
            JSONObject quest2 = jsonObjTheme.getJSONObject("Question2");
            String q2 = quest2.getString("Q2.");
            Log.i("sam", "q2. " + q2);
            que2.setText(q2);
            JSONArray op2 = quest2.getJSONArray("Options");
            String op2_0 = (String) op2.get(0);
            String op2_1 = (String) op2.get(1);
            String op2_2 = (String) op2.get(2);
            b1.setText(op2_0);
            b2.setText(op2_1);
            b3.setText(op2_2);
        } catch (Exception e) {
            Log.i("sam", "e.get");
        }
    }

    public void load3() {
        Log.d("samuel", "Quizz download 5 ");

        JSONObject jsonobj = getQuestionFromFile();

        try {
            JSONObject jsonobj2 = jsonobj.getJSONObject("Quiz about happiness");

            JSONObject jsonObjTheme = jsonobj2.getJSONObject("Party");
            JSONObject quest3 = jsonObjTheme.getJSONObject("Question3");
            String q3 = quest3.getString("Q3.");
            Log.i("sam", "q3. " + q3);
            que3.setText(q3);
            JSONArray op3 = quest3.getJSONArray("Options");
            String op3_0 = (String) op3.get(0);
            String op3_1 = (String) op3.get(1);
            String op3_2 = (String) op3.get(2);
            c1.setText(op3_0);
            c2.setText(op3_1);
            c3.setText(op3_2);
        } catch (Exception e) {
            Log.i("sam", "e.get");
        }
    }

    public JSONObject getQuestionFromFile() {
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "Quiz.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONObject(new String(buffer, "UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONObject();
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
        return null;
    }

    @Override
    public void onClick(View v) {
        Log.i("samuel", "onClick");
        switch (v.getId()) {
            case R.id.confirmParty:
                Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_LONG).show();
                Intent i = new Intent(PartyQ.this, FinalParty.class);
                startActivity(i);
                break;

        }
    }
}
