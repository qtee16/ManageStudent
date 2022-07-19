package com.example.managestudent.screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.managestudent.R;
import com.example.managestudent.adapter.StudentAdapter;
import com.example.managestudent.database.DatabaseHandler;
import com.example.managestudent.model.Student;

import java.util.ArrayList;

public class ManageActivity extends AppCompatActivity {

    ListView lvListStudent;

    public static ArrayList<Student> data;
    public static StudentAdapter adapter;
    static DatabaseHandler database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        database = new DatabaseHandler(this);

//        database.addStudent(new Student("20194173", "Tran Kim Quoc Thang", "thangsv01@gmail.com", "01/06/2001"));
//        database.addStudent(new Student("20192423", "Nguyen Van C", "ddd@gmail.com", "05/01/2001"));
//        database.addStudent(new Student("20191342", "Le Van A", "aaa@gmail.com", "31/01/2001"));
//        database.addStudent(new Student("20199091", "Nguyen Thi T", "ttt@gmail.com", "01/06/2001"));

        lvListStudent = findViewById(R.id.lvListStudent);

        data = (ArrayList<Student>) database.getAllStudents();

        adapter = new StudentAdapter(this, R.layout.detail_student, data);

        lvListStudent.setAdapter(adapter);
    }

    static void loadData() {
        data = (ArrayList<Student>) database.getAllStudents();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_student:
                startActivity(new Intent(this, AddStudentActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }
}