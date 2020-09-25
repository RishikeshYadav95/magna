package com.example.apple.magna;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;

/**
 * Created by APPLE on 06/04/16.
 */
public class Sharedpreferences extends Activity {

    public static void SavePreferences(String key,String value, Context c){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static  void logout(Context c){
        /*SharedPreferences sharedpreferences = c.getSharedPreferences( c.getPackageName() , c.MODE_PRIVATE);
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();*/
    }

    public static String GetSavePreferences(String key,String value, Context c){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c.getApplicationContext());
        String  cid = sharedPreferences.getString(key, value) ;
        return cid;
    }

}
