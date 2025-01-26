package com.example.Dao;

import com.example.Model.Student;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface StudentDao {

    @SqlQuery("select * from students")
    @RegisterBeanMapper(Student.class)
    List<Student> getAllStudents();

    @SqlQuery("select * from students where id =:id")
    @RegisterBeanMapper(Student.class)
    Student getStudentById(@Bind("id") int id);

    @SqlUpdate("insert into students (id,name, age, subject) values (:id, :name,:age,:subject)")
    void createStudent(@BindBean Student student);

    @SqlUpdate("update students set name=:name,age=:age,subject=:subject where id =:id")
    void updateStudent(@BindBean Student student);

    @SqlUpdate("delete from students where id =:id")
    void deleteStudent(@Bind("id") int id);

}
