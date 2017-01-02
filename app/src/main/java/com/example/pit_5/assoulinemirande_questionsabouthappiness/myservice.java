package com.example.pit_5.assoulinemirande_questionsabouthappiness;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pit_5 on 15/12/2016.
 */

public class myservice extends IntentService {
    public myservice() {
        super("toto");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("samuel", "service");
        URL url =null;
        try {
            url=new URL ("http://happinessquiz.alwaysdata.net/Quiz.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (HttpURLConnection.HTTP_OK==conn.getResponseCode()){
                copyInputStreamToFile((conn.getInputStream()), new File(getCacheDir(), "Quiz.json"));
                Log.d("samuel","Quizz download");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("assouline"));


    }


    private void copyInputStreamToFile(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte [1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
