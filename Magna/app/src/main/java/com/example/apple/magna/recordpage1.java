package com.example.apple.magna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by APPLE on 25/03/16.
 */
public class recordpage1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recordpage1);

        //Button btn = (Button)findViewById(R.id.b1);

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pladylist.this, questions.class));
            }
        });*/


    }

    public void questions (View view)
    {
        startActivity(new Intent(this, questions.class));
    }

}
