package com.example.managestudent.model;

public class Student {
    private String mssv;
    private String fullName;
    private String email;
    private String birthday;

    public Student(String mssv, String fullName, String email, String birthday) {
        this.mssv = mssv;
        this.fullName = fullName;
        this.email = email;
        this.birthday = birthday;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
