package com.example.babarbaig.infomania;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import java.util.ArrayList;


/**
 * Created by Babar Baig on 2/12/2016.
 */
//public class CustomListAdapter extends BaseAdapter implements Filterable {
//
//    Context context;
//    int layoutFile;
//    ArrayList<StudentResult> students;
//    ArrayList<StudentResult> filterList;
//    ValueFilter filter;
//
//
//    public CustomListAdapter(Context c, ArrayList<StudentResult> s)
//    {
//        //super(c,f,s);
//        context = c;
//        //layoutFile = f;
//        students = s;
//        filterList = s;
//    }
//
//    @Override
//    public int getCount() {
//        return students.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return students.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return students.indexOf(getItem(i));
//    }
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent)
//    {
//        View itemView = convertView;
//
//        final int pos = position;
//
//        if (itemView == null)
//        {
//            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
//            itemView = inflater.inflate(layoutFile, parent, false);
//        }
//        else
//        {
//            itemView = (View)convertView;
//        }
//
//        StudentResult currRes = students.get(position);
//        //Now fill the view
//
//        Button eBtn = (Button)itemView.findViewById(R.id.EditBtn);
//        Button dBtn = (Button)itemView.findViewById(R.id.deleteBtn);
//
//
//        TextView c = (TextView) itemView.findViewById(R.id.tvCourse);
//        TextView a = (TextView) itemView.findViewById(R.id.tvAssessment);
//        TextView m = (TextView) itemView.findViewById(R.id.tvMarksObt);
//        TextView t = (TextView) itemView.findViewById(R.id.tvTotal);
//        TextView cBox = (TextView) itemView.findViewById(R.id.tvComment);
//
//        c.setText(currRes.getCourseName());
//        a.setText(currRes.getAssessmentName());
//        m.setText(currRes.getMarksObtained());
//        t.setText(currRes.getTotalMarks());
//        cBox.setText(currRes.getCommentsName());
//
//
//        eBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context,InputRecord.class);
//                i.putExtra("index",position);
//                ((Activity)context).startActivityForResult(i, 2);
//            }
//        });
//
//        dBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                students.remove(pos);
//                notifyDataSetChanged();
//            }
//        });
//
//
//        return itemView;
//    }
//
//
//    @Override
//    public Filter getFilter()
//    {
//        if(filter == null)
//            filter = new ValueFilter();
//        return filter;
//    }
//
//
//    private class ValueFilter extends Filter {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint)
//        {
//            FilterResults results = new FilterResults();
//            //students=filterList;
//            if(constraint!= null && constraint.length()>0)
//            {
//                constraint = constraint.toString().toUpperCase();
//                ArrayList<StudentResult> filters = new  ArrayList<StudentResult>();
//                for(int i=0; i<filterList.size(); i++)
//                {
//                    if(filterList.get(i).getCourseName().toUpperCase().contains(constraint))
//                    {
//                        StudentResult sNew = new StudentResult(filterList.get(i).getCourseName(),filterList.get(i).getAssessmentName(),
//                                filterList.get(i).getMarksObtained(),filterList.get(i).getTotalMarks(),filterList.get(i).getCommentsName());
//                        filters.add(sNew);
//                    }
////                    if(students.get(i).getCourseName().toLowerCase().contains(constraint.toString().toLowerCase())){
////                        filterList.add(new StudentResult(students.get(i).getCourseName(),students.get(i).getAssessmentName()
////                                , students.get(i).getMarksObtained(),students.get(i).getTotalMarks(),students.get(i).getCommentsName()));
////                    }
//                }
//                results.count=filters.size();
//                results.values=filters;
//            }
//            else
//            {
//                results.count=filterList.size();
//                results.values=filterList;
//            }
//
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults result){
//
//            students= (ArrayList<StudentResult>) result.values;
//            notifyDataSetChanged();
//        }
//    }
//
//
//}








public class CustomListAdapter extends ArrayAdapter<StudentResult> {

    Context context;
    int layoutFile;
    ArrayList<StudentResult> students;
    ArrayList<StudentResult> origStudentList;
    Filter valueFilter;

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint){
            FilterResults result = new FilterResults();
            students=origStudentList;

//            for(int x=0;x<origStudentList.size();x++)
//            {
//                students.add(origStudentList.get(x));
//            }


            if(constraint!= null && constraint.length()>0){
                ArrayList<StudentResult> filterList = new  ArrayList<StudentResult>();
                for(int i=0; i<students.size(); i++) {
                    if(students.get(i).getCourseName().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filterList.add(new StudentResult(students.get(i).getCourseName(),students.get(i).getAssessmentName()
                                , students.get(i).getMarksObtained(),students.get(i).getTotalMarks(),students.get(i).getCommentsName()));
                    }
                }
                result.count=filterList.size();
                result.values=filterList;
            }
            else{
                result.count=students.size();
                result.values=students;
            }

            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults result){

            students= (ArrayList<StudentResult>) result.values;
            notifyDataSetChanged();
        }
    }

    @Override
    public Filter getFilter()
    {
        if(valueFilter == null)
            valueFilter = new ValueFilter();
        return valueFilter;
    }

    public CustomListAdapter(Context c, int f, ArrayList<StudentResult> s)
    {
        super(c,f,s);
        context = c;
        layoutFile = f;
        students = s;
        origStudentList = s;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        View itemView = convertView;

        final int pos = position;

        if (itemView == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            itemView = inflater.inflate(layoutFile, parent, false);
        }
        else
        {
            itemView = (View)convertView;
        }

        StudentResult currRes = students.get(position);
        //Now fill the view

        Button eBtn = (Button)itemView.findViewById(R.id.EditBtn);
        Button dBtn = (Button)itemView.findViewById(R.id.deleteBtn);


        TextView c = (TextView) itemView.findViewById(R.id.tvCourse);
        TextView a = (TextView) itemView.findViewById(R.id.tvAssessment);
        TextView m = (TextView) itemView.findViewById(R.id.tvMarksObt);
        TextView t = (TextView) itemView.findViewById(R.id.tvTotal);
        TextView cBox = (TextView) itemView.findViewById(R.id.tvComment);

        c.setText(currRes.getCourseName());
        a.setText(currRes.getAssessmentName());
        m.setText(currRes.getMarksObtained());
        t.setText(currRes.getTotalMarks());
        cBox.setText(currRes.getCommentsName());


        eBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,InputRecord.class);
                i.putExtra("index",position);
                ((Activity)context).startActivityForResult(i, 2);
            }
        });

        dBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.remove(pos);
                notifyDataSetChanged();
            }
        });


        return itemView;
    }
}