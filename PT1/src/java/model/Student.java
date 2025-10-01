/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hieuchu
 */
public class Student {
    private int studentID;
    private String studentName ;
    private int studentAge ;
    private String studentGender ;
    private String studentAddress ;
    private int studentScore ;

    public Student() {
    }

    public Student(int studentID, String studentName, int studentAge, String studentGender, String studentAddress, int studentScore) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.studentAddress = studentAddress;
        this.studentScore = studentScore;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }

    
}
