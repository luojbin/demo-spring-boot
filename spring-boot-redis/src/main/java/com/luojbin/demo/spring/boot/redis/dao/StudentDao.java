package com.luojbin.demo.spring.boot.redis.dao;

import com.luojbin.demo.spring.boot.common.entity.Clazz;
import com.luojbin.demo.spring.boot.common.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    Student getStudentById(String id);

    List<Clazz> getAll();

    int saveStudent(Student student);

}
