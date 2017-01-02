package com.example.pit_5.assoulinemirande_questionsabouthappiness;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.TextP2;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.default_activity_button;
import static com.example.pit_5.assoulinemirande_questionsabouthappiness.R.id.toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatePickerDialog DPD;
    TextView d;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mytoolbar=(Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mytoolbar);

        Intent g = getIntent();


        View w = findViewById(TextP2);
        d = (TextView) w;

        View v = findViewById(R.id.begin);
        Button b = (Button) v;
        b.setOnClickListener(this);

        Button b2 = (Button) findViewById(R.id.buttonHelp);
        b2.setOnClickListener(this);


        DPD = new DatePickerDialog(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                return true;


            case R.id.action_refresh:
                return true;


            default :
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {

        Log.i("samuel", "onClick");
        switch (v.getId()) {
            case R.id.begin:
                Log.i("samuel", "begin");
                NotificationCompat.Builder mBuilder =
                        (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.android)
                                .setContentTitle("Notification")
                                .setContentText("You just started the quizz !");

                // Sets an ID for the notification
                int mNotificationId = 001;
                // Gets an instance of the NotificationManager service
                NotificationManager mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // Builds the notification and issues it.
                mNotifyMgr.notify(mNotificationId, mBuilder.build());
                Intent i = new Intent(MainActivity.this, FirstQ.class);
                startActivity(i);
                break;
            case R.id.buttonHelp:
                Log.i("samuel", "buttonHelp");
                Toast.makeText(getApplicationContext(), "This is just a game. \nCopyright Assouline/Mirande 2016-2017", Toast.LENGTH_LONG).show();
                break;

        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://www.google.com"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
