package com.luojbin.demo.spring.boot.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Student implements Serializable {

    Integer id;
    Integer classId;
    String studentName;
    Integer age;
    String address;
    List<Score> scoreList;
}
