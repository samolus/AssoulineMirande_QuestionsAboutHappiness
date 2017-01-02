package com.example.pit_5.assoulinemirande_questionsabouthappiness;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.Liste;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.TextTest;

/**
 * Created by pit_5 on 13/12/2016.
 */

public class FirstQ extends Activity {

    TextView d;
    RecyclerView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_q);
        Intent i = getIntent();

        View w =findViewById(TextTest);
        d = (TextView)w;

        View v = findViewById(Liste);
        r = (RecyclerView)v;
        r.setLayoutManager(new GridLayoutManager(this, 1));
        r.setAdapter(new QuizzAdapter(this));
    }


    public BroadcastReceiver getBroadcastReceiverBroadcastReceiver()
    {
        return new Appreceiver();
    }

    public class Appreceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("samuel","Quizz download 2 ");

            JSONObject jsonobj = getQuestionFromFile();

                try {
                    JSONObject jsonobj2 = jsonobj.getJSONObject("Quiz about happiness");

                    JSONObject jsonObjThemeL = jsonobj2.getJSONObject("Love");
                    JSONObject quest1 = jsonObjThemeL.getJSONObject("Question");

                    String q1 = quest1.getString("Q1.");
                    JSONArray op1 = quest1.getJSONArray("Options");
                    String op1_0 = (String)op1.get(0);
                    String op1_1 = (String)op1.get(1);
                    String op1_2 = (String)op1.get(2);

                    JSONObject quest2 = jsonObjThemeL.getJSONObject("Question2");
                    String q2 = quest2.getString("Q2.");
                    JSONArray op2 = quest2.getJSONArray("Options");
                    String op2_0 = (String)op2.get(0);
                    String op2_1 = (String)op2.get(1);
                    String op2_2 = (String)op2.get(2);

                    JSONObject quest3 = jsonObjThemeL.getJSONObject("Question3");
                    String q3 = quest3.getString("Q3.");
                    JSONArray op3 = quest3.getJSONArray("Options");
                    String op3_0 = (String)op3.get(0);
                    String op3_1 = (String)op3.get(1);
                    String op3_2 = (String)op3.get(2);

                    JSONObject jsonObjThemeF = jsonobj2.getJSONObject("Friendship");
                    JSONObject questF1 = jsonObjThemeF.getJSONObject("Question");
                    String qF1 = questF1.getString("Q1.");
                    JSONArray opF1 = quest1.getJSONArray("Options");
                    String opF1_0 = (String)opF1.get(0);
                    String opF1_1 = (String)opF1.get(1);
                    String opF1_2 = (String)opF1.get(2);

                    JSONObject questF2 = jsonObjThemeF.getJSONObject("Question2");
                    String qF2 = questF1.getString("Q2.");
                    JSONArray opF2 = questF2.getJSONArray("Options");
                    String opF2_0 = (String)opF2.get(0);
                    String opF2_1 = (String)opF2.get(1);
                    String opF2_2 = (String)opF2.get(2);

                    JSONObject questF3 = jsonObjThemeL.getJSONObject("Question3");
                    String qF3 = questF1.getString("Q3.");
                    JSONArray opF3 = questF3.getJSONArray("Options");
                    String opF3_0 = (String)opF3.get(0);
                    String opF3_1 = (String)opF3.get(1);
                    String opF3_2 = (String)opF3.get(2);

                    JSONObject jsonObjThemeP = jsonobj2.getJSONObject("Party");
                    JSONObject questP1 = jsonObjThemeP.getJSONObject("Question");
                    String qP1 = questP1.getString("Q1.");
                    JSONArray opP1 = questP1.getJSONArray("Options");
                    String opP1_0 = (String)opP1.get(0);
                    String opP1_1 = (String)opP1.get(1);
                    String opP1_2 = (String)opP1.get(2);

                    JSONObject questP2 = jsonObjThemeF.getJSONObject("Question2");
                    String qP2 = questP2.getString("Q2.");
                    JSONArray opP2 = questP2.getJSONArray("Options");
                    String opP2_0 = (String)opP2.get(0);
                    String opP2_1 = (String)opP2.get(1);
                    String opP2_2 = (String)opP2.get(2);

                    JSONObject questP3 = jsonObjThemeL.getJSONObject("Question3");
                    String qP3 = questF1.getString("Q3.");
                    JSONArray opP3 = questP3.getJSONArray("Options");
                    String opP3_0 = (String)opP3.get(0);
                    String opP3_1 = (String)opP3.get(1);
                    String opP3_2 = (String)opP3.get(2);



                } catch (JSONException e) {
                    e.printStackTrace();
                }

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
    }


