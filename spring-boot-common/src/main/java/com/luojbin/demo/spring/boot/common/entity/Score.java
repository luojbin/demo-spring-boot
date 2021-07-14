package com.luojbin.demo.spring.boot.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Score implements Serializable {
    Integer id;
    Integer studentId;
    String course;
    Integer score;
}
