/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author hieuchu
 */
public class StudentDao {

    public List<Student> getALLStudent() {
        List<Student> newStudent = new ArrayList<>();
        newStudent.add(new Student(1, "Nguyen Van A", 20, "Male", "Ha Noi", 8));
        newStudent.add(new Student(2, "Tran Thi B", 19, "Female", "Hai Phong", 9));
        newStudent.add(new Student(3, "Le Van C", 21, "Male", "Da Nang", 7));
        newStudent.add(new Student(4, "Pham Thi D", 22, "Female", "Hue", 6));
        newStudent.add(new Student(5, "Hoang Van E", 20, "Male", "HCM City", 10));
        newStudent.add(new Student(6, "Vu Thi F", 19, "Female", "Can Tho", 5));
        newStudent.add(new Student(7, "Dang Van G", 23, "Male", "Nam Dinh", 4));
        newStudent.add(new Student(8, "Ngo Thi H", 21, "Female", "Quang Ninh", 7));
        newStudent.add(new Student(9, "Bui Van I", 20, "Male", "Thanh Hoa", 3));
        newStudent.add(new Student(10, "Do Thi J", 22, "Female", "Nghe An", 9));
        return newStudent;
    }

    public List<Student> getFemaleStudent() {
        List<Student> list = getALLStudent();
        List<Student> femaleStudent = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentGender().equalsIgnoreCase("Female")) {
                femaleStudent.add(list.get(i));
            }
        }
        return femaleStudent;
    }

    public List<Student> getStudentWithHighestScore() {
        int maxScore = 0;
        List<Student> list = new ArrayList<>();
        for (Student x : getALLStudent()) {
            if (x.getStudentScore() >= maxScore) {
                maxScore = x.getStudentScore();
            }
        }
        for (Student x2 : getALLStudent()) {
            if (x2.getStudentScore() == maxScore) {
                list.add(x2);
            }
        }
        return list;
    }

    public List<Student> sortStudentByScore() {
        List<Student> sortStudent = getALLStudent();
        sortStudent.sort((student1, student2) -> Integer.compare(student1.getStudentScore(), student2.getStudentScore()));
        return sortStudent;               
    }
    
    public Student searchStudentByName(String name){
        for(Student x : getALLStudent()){
           if(x.getStudentName().equalsIgnoreCase(name)){
               return x ;
           }
        }
        return null ;
    }
}
