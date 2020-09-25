package com.example.apple.magna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by APPLE on 25/03/16.
 */
public class pregister extends AppCompatActivity {

    EditText fname;
    EditText mname;
    EditText lname;
    EditText area;
    EditText age;
    EditText trimester;
    EditText telno;
    EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregister);
        fname = (EditText) findViewById(R.id.fname);
        mname = (EditText) findViewById(R.id.mname);
        lname = (EditText) findViewById(R.id.lname);
        area = (EditText) findViewById(R.id.area);
        age = (EditText) findViewById(R.id.age);
        trimester = (EditText) findViewById(R.id.trimester);
        telno = (EditText) findViewById(R.id.telno);
        address = (EditText) findViewById(R.id.address);

        Button btn = (Button)findViewById(R.id.b1);


    }

    public String backtohomescreen(View view)
    {

        validations v=new validations();
        if(fname.length()==0)
        {
            //username.setError("Please enter username");
            Toast.makeText(this, "Please enter first name", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if(v.textonly(fname.getText().toString()))
        {
            Toast.makeText(this, "Please enter alphabets only in first name", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if(mname.length()==0)
        {
            //username.setError("Please enter username");
            Toast.makeText(this, "Please enter middle name", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if(v.textonly(mname.getText().toString()))
        {
            Toast.makeText(this, "Please enter alphabets only in middle name", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if (lname.length()==0)
        {
            //password.setError("Please enter password");
            Toast.makeText(this, "Please enter last name", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if(v.textonly(lname.getText().toString()))
        {
            Toast.makeText(this, "Please enter alphabets only in last name", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if(area.length()==0)
        {
            //username.setError("Please enter username");
            Toast.makeText(this, "Please enter area", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if (age.length()==0)
        {
            //password.setError("Please enter password");
            Toast.makeText(this, "Please enter age", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if (Integer.parseInt(age.getText().toString())<=0||Integer.parseInt(age.getText().toString())>=50)
        {
            //password.setError("Please enter password");
            Toast.makeText(this, "Please enter valid age", Toast.LENGTH_SHORT).show();
            return null;
        }
        /*else if(v.dateonly(dob.getText().toString()))
        {
            Toast.makeText(this, "Please enter valid date in the form dd-mm-yyyy", Toast.LENGTH_LONG).show();
            return null;
        }*/
        else if (trimester.length()==0)
        {
            //password.setError("Please enter password");
            Toast.makeText(this, "Please enter trimester", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if(Integer.parseInt(trimester.getText().toString())>3)
        {
            //username.setError("Please enter username");
            Toast.makeText(this, "Please enter valid trimester", Toast.LENGTH_SHORT).show();
            return null;
        }

        /*else if(v.DateValidation(dob.getText().toString())!=0)
        {
            Toast.makeText(this, "DOB can not be greater than or equal to today's date", Toast.LENGTH_LONG).show();
            return null;
        }*/
        else if (telno.length()!=10)
        {
            //password.setError("Please enter password");
            Toast.makeText(this, "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if(address.length()==0)
        {
            //username.setError("Please enter username");
            Toast.makeText(this, "Please enter full address", Toast.LENGTH_SHORT).show();
            return null;
        }
        else
        {
            String fnamee = fname.getText().toString();
            String mnamee = mname.getText().toString();
            String lnamee = lname.getText().toString();
            String areaa = area.getText().toString();
            String agee= age.getText().toString();
            String trimesterr = trimester.getText().toString();
            String telnoo=telno.getText().toString();
            String addresss=address.getText().toString();
            String type = "pregister";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, fnamee, mnamee, lnamee, areaa, agee,trimesterr, telnoo, addresss);
        }
        return null;

    }

    public void pregister (View view)
    {
        startActivity(new Intent(pregister.this, pregister.class));
    }

    public void pladylist (View view)
    {
        startActivity(new Intent(pregister.this, pladylist.class));
    }


    public void fileofwoman (View view)
    {
        startActivity(new Intent(pregister.this, file1.class));
    }





}
