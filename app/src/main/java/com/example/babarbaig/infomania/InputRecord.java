package com.example.babarbaig.infomania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputRecord extends AppCompatActivity {

    EditText aVal;
    EditText courseVal;
    EditText mObt;
    EditText tMarks;
    EditText comVal;

    int ind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_record);

        aVal = (EditText)findViewById(R.id.input_aInfo);
        courseVal = (EditText)findViewById(R.id.input_course);
        mObt = (EditText)findViewById(R.id.input_marksObt);
        tMarks = (EditText)findViewById(R.id.input_totalMarks);
        comVal = (EditText)findViewById(R.id.input_comments);


    }


    public void SaveRecord(View view) {

     String aValue = aVal.getText().toString();
        String cValue = courseVal.getText().toString();
        String marksValue = mObt.getText().toString();
        String tMarksValue = tMarks.getText().toString();
        String commentsValue = comVal.getText().toString();


        Intent i = getIntent();

        ind = i.getIntExtra("index",0);

        i.putExtra("assessment",aValue);
        i.putExtra("course",cValue);
        i.putExtra("marks",marksValue);
        i.putExtra("total",tMarksValue);
        i.putExtra("comments",commentsValue);

        i.putExtra("ind",ind);

        setResult(RESULT_OK,i);
        finish();
    }
}
