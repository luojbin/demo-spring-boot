package com.luojbin.demo.spring.boot.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Clazz implements Serializable {
    Integer id;
    String className;
    Integer studentAmount;
    List<Student> studentList;
}
