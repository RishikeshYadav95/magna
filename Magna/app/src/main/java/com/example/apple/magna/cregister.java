package com.example.apple.magna;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.lang.String;

/**
 * Created by APPLE on 25/03/16.
 */
public class cregister extends AppCompatActivity
{
    EditText fname;                             //GLOBAL VARIABLES
    EditText lname;
    EditText age;
    EditText telno;
    RadioGroup gender;
    RadioButton selectedRadioButton;
    EditText password;
    EditText cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cregister);                //cregister.xml layout

        fname=(EditText) findViewById(R.id.fname);              //Initialising views
        lname=(EditText) findViewById(R.id.lname);
        age=(EditText) findViewById(R.id.age);
        telno=(EditText) findViewById(R.id.telno);
        gender=(RadioGroup) findViewById(R.id.gender);
        password=(EditText) findViewById(R.id.password);
        cpassword=(EditText) findViewById(R.id.cpassword);
        // get selected radio button from radioGroup
        //selectedId = gender.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        //selectedRadioButton = (RadioButton)findViewById(selectedId);

    }

    public String backtosignin (View view)
    {
                                                                    //VALIDATIONS!
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
       /* else if(v.dateonly(age.getText().toString())=="true feb leap year"||v.dateonly(age.getText().toString())=="true feb not leap year"||v.dateonly(age.getText().toString())=="true normal date"||v.dateonly(age.getText().toString())=="out")
        {
            Toast.makeText(this, v.dateonly(age.getText().toString()), Toast.LENGTH_LONG).show();
            return null;
        }

        else if(v.DateValidation(age.getText().toString())!=0)
        {
            Toast.makeText(this, "DOB can not be greater than or equal to today's date", Toast.LENGTH_LONG).show();
            return null;
        }*/
        else if(gender.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
            return null;
        }
        /*else if(gender.getCheckedRadioButtonId()!=-1)
        {
            // get selected radio button from radioGroup
            int selectedId = gender.getCheckedRadioButtonId();
// find the radiobutton by returned id
            selectedRadioButton = (RadioButton)findViewById(selectedId);
            Toast.makeText(getApplicationContext(), selectedRadioButton.getText().toString()+" is selected", Toast.LENGTH_SHORT).show();
            return null;
        }*/
        else if (telno.length()!=10)
        {
            //password.setError("Please enter password");
            Toast.makeText(this, "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if (password.length()==0)
        {
            //password.setError("Please enter password");
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if (password.length()<6)
        {
            //password.setError("Please enter password");
            Toast.makeText(this, "Please enter password atleast 6 characters", Toast.LENGTH_LONG).show();
            return null;
        }
        else if (cpassword.length()==0)
        {
            //password.setError("Please enter password");
            Toast.makeText(this, "Please enter confirm password", Toast.LENGTH_SHORT).show();
            return null;
        }
        else if ((password.getText().toString()).compareTo(cpassword.getText().toString())!=0)
        {
            //password.setError("Please enter password");
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return null;
        }
        else
        {
            int selectedId = gender.getCheckedRadioButtonId();
            String gender;
            selectedRadioButton = (RadioButton)findViewById(selectedId);
            if((selectedRadioButton.getText().toString()).equalsIgnoreCase("Male"))
            {
                gender="M";
            }
            else
            {
                gender="F";
            }
            String fnamee = fname.getText().toString();
            String lnamee = lname.getText().toString();
            String agee=age.getText().toString();
            String telnoo=telno.getText().toString();
            String cpass=cpassword.getText().toString();
            String type = "cregister";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);             //Calling ASYNC task
            backgroundWorker.execute(type,fnamee,lnamee,agee,telnoo,cpass,gender);
        }
        return null;
    }

}