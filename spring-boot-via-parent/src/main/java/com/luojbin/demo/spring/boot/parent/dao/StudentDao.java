package com.luojbin.demo.spring.boot.parent.dao;

import com.luojbin.demo.spring.boot.parent.model.Clazz;
import com.luojbin.demo.spring.boot.parent.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    Student getStudentById(String id);

    List<Clazz> getAll();

    int saveStudent(Student student);

}
