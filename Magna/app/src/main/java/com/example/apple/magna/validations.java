package com.example.apple.magna;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

//import java.sql.Date;
import java.util.Date;

/**
 * Created by APPLE on 04/04/16.
 */
public class validations {

    public boolean textonly(String s)
    {

            //$(element).val('');
            //int n= /^[a-zA-Z]+$/.test(s);
            return !s.matches("[a-zA-Z ]+");

    }

    public String dateonly(String s)
    {
        String dateEntered = s;

        if(dateEntered.substring(3,5).matches("02")) //For February.
        {
            if((Integer.parseInt(dateEntered.substring(6,10))%4)==0) //If a leap year.
            {
                if (dateEntered.matches("([0-2][0-9])-(02)-((19|20)[0-9]{2})"))
                    return "true feb leap year";
            }
            else    //if NOT a leap year.
            {
                if (dateEntered.matches("([0-2][0-8])-(02)-((19|20)[0-9]{2})"))
                    return "true feb not leap year";

            }

        }
        else
        {
            if (dateEntered.matches("([0-2][0-9]|(30))-(([0][469])|(11))-((19|20)[0-9]{2})") || dateEntered.matches("([0-2][0-9]|(30|31))-(([0][13578])|(10|12))-((19|20)[0-9]{2})"))
            {
                return "true normal date";
            }
        }
        return "out";
    }

    public int DateValidation(String s)
    {
        String dateEntered = s;
        String date = dateEntered.substring(0, 2);
        String month = dateEntered.substring(3, 5);
        String year = dateEntered.substring(6, 10);

        Date dateToCompare = new Date(s);
        Date currentDate = new Date();
        return dateToCompare.compareTo(currentDate);

    }

}
