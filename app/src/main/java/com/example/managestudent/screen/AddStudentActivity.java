package com.example.managestudent.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.managestudent.MainActivity;
import com.example.managestudent.R;
import com.example.managestudent.database.DatabaseHandler;
import com.example.managestudent.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    EditText etMSSV, etName, etEmail, etBirth;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);



        etMSSV = findViewById(R.id.etMSSV);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etBirth = findViewById(R.id.etBirth);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewStudent();
            }
        });


    }

    void addNewStudent() {
        DatabaseHandler database = ManageActivity.database;
        String mssv, name, email, birth;
        mssv = etMSSV.getText().toString().trim();
        name = etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        birth = etBirth.getText().toString().trim();

        if (mssv.isEmpty() || name.isEmpty() || email.isEmpty() || birth.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
        } else {
            database.addStudent(new Student(mssv, name, email, birth));
            ManageActivity.loadData();
            startActivity(new Intent(this, ManageActivity.class));
        }
    }
}