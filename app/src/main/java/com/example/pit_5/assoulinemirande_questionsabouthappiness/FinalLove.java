package com.example.pit_5.assoulinemirande_questionsabouthappiness;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pit_5 on 15/12/2016.
 */

public class FinalLove extends Activity  implements View.OnClickListener  {
    TextView d;
    ImageView e;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finallove);
        Intent h = getIntent();

        View v = findViewById(R.id.exitLove);
        Button b = (Button) v;

        View zen = findViewById(R.id.buttonZ);
        Button b3 = (Button) zen;
        b3.setOnClickListener(this);


        View w = findViewById(R.id.textFriend);
        d = (TextView)w;

        e = (ImageView) findViewById(R.id.heart);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exitLove:
                Intent g = new Intent(FinalLove.this, MainActivity.class);
                startActivity(g);
                break;
            case R.id.buttonZ:
                Uri webpage = Uri.parse("https://www.youtube.com/watch?v=3JWTaaS7LdU");
                Intent j = new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(j);
                break;


        }
    }
}
