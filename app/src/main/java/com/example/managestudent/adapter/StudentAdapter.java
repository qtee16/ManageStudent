package com.example.managestudent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.managestudent.R;
import com.example.managestudent.model.Student;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Student> listStudent;

    public StudentAdapter(Context context, int layout, List<Student> listStudent) {
        this.context = context;
        this.layout = layout;
        this.listStudent = listStudent;
    }

    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout, viewGroup, false);

        TextView tvDataName = (TextView) rowView.findViewById(R.id.tvDataName);
        TextView tvDataMSSV = (TextView) rowView.findViewById(R.id.tvDataMSSV);
        TextView tvDataEmail = (TextView) rowView.findViewById(R.id.tvDataEmail);
        TextView tvDataBirth = (TextView) rowView.findViewById(R.id.tvDataBirth);

        tvDataMSSV.setText(listStudent.get(i).getMssv());
        tvDataName.setText(listStudent.get(i).getFullName());
        tvDataEmail.setText(listStudent.get(i).getEmail());
        tvDataBirth.setText(listStudent.get(i).getBirthday());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + listStudent.get(i).getFullName(), Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}
