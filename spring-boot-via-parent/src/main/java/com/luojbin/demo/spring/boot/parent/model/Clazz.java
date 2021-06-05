package com.luojbin.demo.spring.boot.parent.model;

import lombok.Data;

import java.util.List;

@Data
public class Clazz {
    Integer id;
    String className;
    Integer studentAmount;
    List<Student> studentList;
}
