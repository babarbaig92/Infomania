package com.example.babarbaig.infomania;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    String cVal;
    String aVal;
    String mObtVal;
    String totalMarksVal;
    String comVal;

    SearchView sView;
    ListView lv;


    ArrayAdapter<StudentResult> adp;

    //CustomListAdapter adp;
    ArrayList<StudentResult> SData = new ArrayList<StudentResult>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sView = (SearchView) findViewById(R.id.searchView);
        //lv.setTextFilterEnabled(true);
//        setupSearchMethod();

        populateStudentList();
        populateListView();

        sView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                adp.getFilter().filter(s);
                return false;
            }

        });


    }

    private void populateStudentList()
    {
        SData.add(new StudentResult("SMD","QUIZ 1","12","15","Yes You Do!"));
        SData.add(new StudentResult("SMD","QUIZ 2","11","15","No You don't!"));

        SData.add(new StudentResult("HCI","QUIZ 1","13","15","Really?"));
        SData.add(new StudentResult("HCI","QUIZ 2","8","15","Not Really!"));

        SData.add(new StudentResult("ALGO","MID 1","12","30","OH ho"));

    }

//    private void setupSearchMethod()
//    {
//        sView.setIconifiedByDefault(false);
//        sView.setSubmitButtonEnabled(true);
//        sView.setQueryHint("Search Records Here");
//    }

    public void AddRecordAct(View view)
    {
        Intent i = new Intent(this, InputRecord.class);
        i.putExtra("index",0);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                //get the data
                //Toast.makeText(this,"in on Activity Result", Toast.LENGTH_LONG).show();
                cVal = data.getStringExtra("course");
                aVal = data.getStringExtra("assessment");
                mObtVal = data.getStringExtra("marks");
                totalMarksVal = data.getStringExtra("total");
                comVal = data.getStringExtra("comments");

                //add this student to record
                SData.add(new StudentResult(cVal, aVal, mObtVal, totalMarksVal, comVal));
                adp.notifyDataSetChanged();
            }
        }
        else if(requestCode == 2)
        {
            if(resultCode == RESULT_OK)
            {
                cVal = data.getStringExtra("course");
                aVal = data.getStringExtra("assessment");
                mObtVal = data.getStringExtra("marks");
                totalMarksVal = data.getStringExtra("total");
                comVal = data.getStringExtra("comments");

                int ind = data.getIntExtra("ind",0);

                StudentResult s = SData.get(ind);

                s.setAssessmentName(aVal);
                s.setCommentsName(comVal);
                s.setCourseName(cVal);
                s.setTotalMarks(totalMarksVal);
                s.setMarksObtained(mObtVal);

                adp.notifyDataSetChanged();

            }

        }
    }

    private void populateListView()
    {
       //Toast.makeText(this,"in on Activity Result", Toast.LENGTH_LONG).show()
        adp = new CustomListAdapter(this,R.layout.item_view,SData);
        //adp = new CustomListAdapter(this,SData);
        lv = (ListView) findViewById(R.id.itemListView);
        lv.setAdapter(adp);
    }

}