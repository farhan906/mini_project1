package com.example.throosb1.model;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

@IgnoreExtraProperties
public class Student {
    @PropertyName("DOB")
    private String DOB;
    @PropertyName("RFID")
    private String RFID;
    @PropertyName("class")
    private String classname;
    @PropertyName("parent_name")
    private String parent_name;
    @PropertyName("parent_phoneNo")
    private String parent_phoneNo;
    @PropertyName("password")
    private String password;
    @PropertyName("student_address")
    private String student_address;
    @PropertyName("student_id")

    private String student_id;
    @PropertyName("student_name")
    private String student_name;

    public Student(){
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getParent_phoneNo() {
        return parent_phoneNo;
    }

    public void setParent_phoneNo(String parent_phoneNo) {
        this.parent_phoneNo = parent_phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
