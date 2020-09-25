package com.example.apple.magna;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.String;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {
    TextView textView;
    EditText editText;
    private ImageButton imageButton;
    public Button b;
    protected static final int RESULT_SPEECH = 1;
    public String s;
    public String message;
    public String txtfile[][];
    Bundle bundle;

    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.page_fragment_layout,container,false);
        textView=(TextView)view.findViewById(R.id.t1);
        editText=(EditText)view.findViewById(R.id.e1);
        imageButton = (ImageButton)view.findViewById(R.id.ib1);
        b = (Button)view.findViewById(R.id.b1);
        bundle=getArguments();
        message=Integer.toString(bundle.getInt("questionnumber"));
        textView.setText("Question " + message);
        editText.setHint("Answer " + message);
        if(bundle.getInt("questionnumber")<SwipeAdapter.numberofquestions) {

            b.setVisibility(View.GONE);
        }

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "hi-IN");
                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    editText.setText("");
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getActivity().getApplicationContext(),
                            "Oops! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        /*b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    File root = new File(Environment.getExternalStorageDirectory(), "Notes");
                    if (!root.exists()) {
                        root.mkdirs();
                    }
                    File gpxfile = new File(root, "first.text");
                    FileWriter writer = new FileWriter(gpxfile,true);
                    for(int i=0;i<SwipeAdapter.numberofquestions;i++)
                    {
                        writer.append(txtfile[i][0] + "\n"+txtfile[i][1]+ "\n\n");
                    }
                    writer.flush();
                    writer.close();
                    Toast.makeText(getActivity().getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});*/



        return view;
    }

    /*public void makingDoc(View v)
    {
        makeDoc1(getActivity().getApplicationContext(),"first.txt",s);
    }
    public void makeDoc1(Context context, String sFileName, String sBody)
    {
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
        //Date now = new Date();
        //String fileName = formatter.format(now) + ".txt";//like 2016_01_12.txt
        /*try {
            //File root = new File(Environment.getExternalStorageDirectory() + File.separator + "Doc_Folder", "Report Files");
            File root = new File(Environment.getExternalStorageDirectory(),"Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "trying1.txt");


            FileWriter writer = new FileWriter(gpxfile, true);
            writer.append(sBody + "\n\n");
            writer.flush();
            writer.close();
            Toast.makeText(this, "Data has been written to Report File", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();

        }*/

       /* try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile,true);
            writer.append("Question "+message+"\nAnswer- "+sBody+ "\n\n");
            writer.flush();
            writer.close();
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    // @Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    //  getMenuInflater().inflate(R.layout.activity_main, menu);
    //return true;
    //}

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == Activity.RESULT_OK && null != data)
                {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    s=text.get(0);


                    /*txtfile[(bundle.getInt("questionnumber"))][0]="Question " + message;
                    txtfile[(bundle.getInt("questionnumber"))][1] = "Answer- " + s;*/

                    /*try {
                        File root = new File(Environment.getExternalStorageDirectory(), "Notes");
                        if (!root.exists()) {
                            root.mkdirs();
                        }
                        File gpxfile = new File(root, "first.text");
                        FileWriter writer = new FileWriter(gpxfile,true);
                        //for(int i=0;i<SwipeAdapter.numberofquestions;i++)
                        //{
                            writer.append("Question " + message + "\nAnswer- " + s + "\n\n");
                        //}
                        writer.flush();
                        writer.close();
                        //Toast.makeText(getActivity().getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                    editText.setText(text.get(0));

                    String ans=editText.getText().toString();

                    
                    }
                }
                break;
            }

        }
    }


