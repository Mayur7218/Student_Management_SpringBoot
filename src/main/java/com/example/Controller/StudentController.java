package com.example.Controller;

import com.example.Model.Student;
import com.example.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private Logger logger= LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        logger.info("Getting all the students");
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        logger.info("Getting student data by Id");
        return studentService.getStudentById(id);
    }

    @PostMapping
    public String createStudent(@RequestBody Student student){
        logger.info("Student is now creating");
         studentService.createStudent(student);
         return "Student created successfully";
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student){
        student.setId(id);
        logger.info("Student is now updating");
        studentService.updateStudent(student);
        return "Student updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        logger.info("Student is now deleting");
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }


}
