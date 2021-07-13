package com.luojbin.demo.spring.boot.redis.service;

import com.luojbin.demo.spring.boot.common.entity.Clazz;
import com.luojbin.demo.spring.boot.common.entity.Student;
import com.luojbin.demo.spring.boot.redis.dao.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class StudentService {

    @Resource
    private StudentDao studentDao;

    public Student getStudentById(String id) {
        return studentDao.getStudentById(id);
    }

    public List<Clazz> getAll() {
        return studentDao.getAll();
    }

    public int saveStudentThrowRTExp() {
        Student student = new Student();
        student.setId(100 + (int) (Math.random() * 99));
        student.setClassId(4);
        student.setStudentName("运行异常");
        student.setAddress("运行时异常, 应该回滚");
        student.setAge(12);
        int result = studentDao.saveStudent(student);
        log.info("已经存入数据库, 受影响行数:" + result);
        if (true) {
            log.info("抛出运行时异常");
            throw new RuntimeException("运行时异常, 能否回滚");
        }
        return result;
    }

    public int saveStudent() {
        Student student = new Student();
        student.setId(100 + (int) (Math.random() * 99));
        student.setClassId(4);
        student.setStudentName("正常插入");
        student.setAddress("正常插入没问题系列");
        student.setAge(12);
        return studentDao.saveStudent(student);
    }

}
