package com.example.apple.magna;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Lenovo on 4/2/2016.
 */
public class BackgroundWorker extends AsyncTask<String, Void, Void> {
    Context context;
    AlertDialog alertDialog;
    String result;
    String user_id;
    String password;
    String type;
    String see;
    String cid;
    //SharedPreferences sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    private static String MyPREFERENCES = "MyPREFERENCES";


    BackgroundWorker(Context ctx) {context = ctx.getApplicationContext();}

    @Override
    protected Void doInBackground(String... params) {
        //String a = "192.168.1.100";
        //String a ="10.16.0.176";
        String a="10.16.0.205";
        //String a="10.16.0.179";
        type = params[0];
        String login_url;


        if (type.equals("login"))
        {
            try {
                login_url="http://"+a+"/magna/login.php";
                user_id = params[1];
                password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("user_id", "UTF-8")+"="+URLEncoder.encode(user_id, "UTF-8")+"&"+
                            URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                result="";
                String line;

                while((line = bufferedReader.readLine())!= null)
                {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        else if (type.equals("cregister"))
        {
                try {
                    login_url="http://"+a+"/magna/cregister.php";
                    String fname = params[1];
                    String lname = params[2];
                    String age = params[3];
                    String telnoo = params[4];
                    String cpass = params[5];
                    String gender= params[6];

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);

                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    String post_data = URLEncoder.encode("fname", "UTF-8")+"="+URLEncoder.encode(fname, "UTF-8")+"&"+
                            URLEncoder.encode("lname", "UTF-8")+"="+URLEncoder.encode(lname, "UTF-8")+"&"+
                            URLEncoder.encode("age", "UTF-8")+"="+URLEncoder.encode(age, "UTF-8")+"&"+
                            URLEncoder.encode("telnoo", "UTF-8")+"="+URLEncoder.encode(telnoo, "UTF-8")+"&"+
                            URLEncoder.encode("cpass", "UTF-8")+"="+URLEncoder.encode(cpass, "UTF-8")+"&"+
                            URLEncoder.encode("gender", "UTF-8")+"="+URLEncoder.encode(gender, "UTF-8");

                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                    result="";
                    String line="";

                    while((line = bufferedReader.readLine())!= null)
                    {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

            }catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        else if (type.equals("pregister"))
        {
            try {
                login_url="http://"+a+"/magna/pregister.php";
                String fname = params[1];
                String mname = params[2];
                String lname = params[3];
                String area = params[4];
                String age = params[5];
                String trimester = params[6];
                String telnoo = params[7];
                String address = params[8];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("fname", "UTF-8")+"="+URLEncoder.encode(fname, "UTF-8")+"&"+
                        URLEncoder.encode("mname", "UTF-8")+"="+URLEncoder.encode(mname, "UTF-8")+"&"+
                        URLEncoder.encode("lname", "UTF-8")+"="+URLEncoder.encode(lname, "UTF-8")+"&"+
                        URLEncoder.encode("area", "UTF-8")+"="+URLEncoder.encode(area, "UTF-8")+"&"+
                        URLEncoder.encode("age", "UTF-8")+"="+URLEncoder.encode(age, "UTF-8")+"&"+
                        URLEncoder.encode("trimester", "UTF-8")+"="+URLEncoder.encode(trimester, "UTF-8")+"&"+
                        URLEncoder.encode("telnoo", "UTF-8")+"="+URLEncoder.encode(telnoo, "UTF-8")+"&"+
                        URLEncoder.encode("address", "UTF-8")+"="+URLEncoder.encode(address, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                see="in cregister";
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                result="";
                String line="";

                while((line = bufferedReader.readLine())!= null)
                {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            }catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("getpladylist"))
        {
            try {
                login_url="http://"+a+"/magna/getpladylist.php";
                String cids = params[1];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("cids", "UTF-8")+"="+URLEncoder.encode(cids, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                result="";
                String line;

                while((line = bufferedReader.readLine())!= null)
                {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onPostExecute(Void r)
        {
            if(type.equals("login"))
            {
                if (result.equals("Login successful"))
                {
                    Sharedpreferences.SavePreferences("cid",user_id,context);

                    Intent i = new Intent(context, pladylist.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                } else {
                    Toast.makeText(context, "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }
            else if(type.equals("cregister"))
            {
                //Toast.makeText(context, see, Toast.LENGTH_SHORT).show();
                if (result.equals("Register successful"))
                {
                    Toast.makeText(context, "Registered successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context,signin.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                } else {
                    Toast.makeText(context, "Registeration unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
            else if(type.equals("pregister"))
            {
                //Toast.makeText(context, see, Toast.LENGTH_SHORT).show();
                if (result.equals("Register successful"))
                {
                    Toast.makeText(context, "Registered successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context,pladylist.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                } else {
                    Toast.makeText(context, "Registeration unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
            else if(type.equals("getpladylist"))
            {
                //Toast.makeText(context, see, Toast.LENGTH_SHORT).show();
                if (!result.equals("null"))
                {
                    Toast.makeText(context, result, Toast.LENGTH_LONG).show();
                    /*Intent i = new Intent(context,pladylist.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);*/

                } else {
                    Toast.makeText(context, "OOPS!", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

