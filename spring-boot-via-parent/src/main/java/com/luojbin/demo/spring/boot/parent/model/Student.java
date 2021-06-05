package com.luojbin.demo.spring.boot.parent.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {

    Integer id;
    Integer classId;
    String studentName;
    Integer age;
    String address;
    List<Score> scoreList;
}
