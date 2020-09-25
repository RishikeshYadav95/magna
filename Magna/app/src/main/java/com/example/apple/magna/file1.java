package com.example.apple.magna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by admin1 on 4/1/2016.
 */
public class file1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file1);

    }


    public void sessionrecord(View view) {
        startActivity(new Intent(file1.this, sessionrecord.class));
    }

    public void pregister (View view)
    {
        startActivity(new Intent(file1.this, pregister.class));
    }

    public void pladylist (View view)
    {
        startActivity(new Intent(file1.this, pladylist.class));
    }

    public void fileofwoman (View view)
    {
        startActivity(new Intent(file1.this, file1.class));
    }

}
