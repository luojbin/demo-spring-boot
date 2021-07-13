package com.luojbin.demo.spring.boot.common.entity;

import lombok.Data;

@Data
public class Score {
    Integer id;
    Integer studentId;
    String course;
    Integer score;
}
