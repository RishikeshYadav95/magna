package com.example.apple.magna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by admin1 on 4/1/2016.
 */
public class sessionrecord extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sessioonrecord);

    }


    public void pregister (View view)
    {
        startActivity(new Intent(sessionrecord.this, pregister.class));
    }

    public void pladylist (View view)
    {
        startActivity(new Intent(sessionrecord.this, pladylist.class));
    }

    public void fileofwoman (View view)
    {
        startActivity(new Intent(sessionrecord.this, file1.class));
    }

}
