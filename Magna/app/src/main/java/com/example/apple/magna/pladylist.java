package com.example.apple.magna;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by APPLE on 25/03/16.
 */
public class pladylist extends AppCompatActivity{

    Context context=this;
    TextView dp;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pladylist);

        dp=(TextView)findViewById(R.id.displaypregladiesdetails);

        Sharedpreferences s=new Sharedpreferences();
        String cid=s.GetSavePreferences("cid",null,context);
        //SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //String  cid = sharedPreferences.getString("cid", "null") ;
        //dp.setText(cid);

        BackgroundWorker backgroundWorker=new BackgroundWorker(this);

        backgroundWorker.execute("getpladylist",cid );

       // Button btn = (Button)findViewById(R.id.b1);

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pladylist.this, questions.class));
            }
        });*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.logout:
                Toast.makeText(this, "Logout selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.manageaccount:
                Toast.makeText(this, "Manage account selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }


    public void recordpage1 (View view)
    {
        startActivity(new Intent(pladylist.this, recordpage1.class));
    }

    public void pregister (View view)
    {
        startActivity(new Intent(pladylist.this, pregister.class));
    }

    public void pladylist (View view)
    {
        startActivity(new Intent(pladylist.this, pladylist.class));
    }

    public void fileofwoman (View view)
    {
        startActivity(new Intent(pladylist.this,  file1.class));
    }


}