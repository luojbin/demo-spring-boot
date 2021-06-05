package com.luojbin.demo.spring.boot.parent.model;

import lombok.Data;

@Data
public class Score {
    Integer id;
    Integer studentId;
    String course;
    Integer score;
}
