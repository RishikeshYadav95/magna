package com.example.apple.magna;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.String;

public class signin extends AppCompatActivity {

    EditText username;
    EditText password;
    Context ct = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.Password);
    }


    public void activity_main(View view) {
        if (username.length() == 0) {
            //username.setError("Please enter username");
            Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
        } else if (password.length() == 0) {
            //password.setError("Please enter password");
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String userid = username.getText().toString();
            String passwrd = password.getText().toString();
            String type = "login";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, userid, passwrd);
        }
    }


    public void cregister(View view)
    {
        startActivity(new Intent(this, cregister.class));
    }
}



    //*****************************************************
/*
    public class BackgroundWorker extends AsyncTask<String, Void, Integer> {
        Context context;
        AlertDialog alertDialog;
        int r;
        String result;

        BackgroundWorker(Context ctx) {context = ctx;}

        @Override
        protected Integer doInBackground(String... params) {
            String a = "192.168.1.101";
            //String a ="10.16.0.176";
            //String a="10.16.0.29";
            String type = params[0];
            String login_url="http://"+a+"/magna/login.php";

            if (type.equals("login"))
            {
                try {
                    String user_id = params[1];
                    String password = params[2];
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);

                  /*  //OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter out = new OutputStreamWriter(httpURLConnection.getOutputStream(),"UTF-8");

                    ab="nolala";
                    //BufferedWriter br= new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(),"UTF-8"));
                    BufferedWriter br= new BufferedWriter(out);

                    String post_data = URLEncoder.encode("user_id", "UTF-8")+"="+URLEncoder.encode(user_id, "UTF-8")+"&"+
                            URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                    */

              /*      OutputStream outputStream = httpURLConnection.getOutputStream();
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
                    String line="";

                    while((line = bufferedReader.readLine())!= null)
                    {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    if (result.compareTo("Login successful")==0)
                    {
                        return 1;
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Login Status");
        }

        @Override
        protected void onPostExecute(Integer fromdoInbackgroud) {
        /*String a=result.toString();
        if(result == 1)
        {
            a="Login complete";
        }*/
            //String result=r.toString();
            //alertDialog.setMessage(result);
            //alertDialog.show();
     /*       afterasync(fromdoInbackgroud);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
*/





