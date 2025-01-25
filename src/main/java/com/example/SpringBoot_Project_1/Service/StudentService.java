package com.example.SpringBoot_Project_1.Service;

import com.example.SpringBoot_Project_1.Dao.StudentDao;
import com.example.SpringBoot_Project_1.Model.Student;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public final StudentDao studentDao;

    public StudentService(Jdbi jdbi){
        this.studentDao=jdbi.onDemand(StudentDao.class);
    }

    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }
    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }
    public void createStudent(Student student){
        studentDao.createStudent(student);
    }

    public void updateStudent(Student student){
        studentDao.updateStudent(student);

    }

    public void deleteStudent(int id){
        studentDao.deleteStudent(id);

    }
}
