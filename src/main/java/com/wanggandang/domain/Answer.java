package com.wanggandang.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="answer")
public class Answer {

    @Id
    private Integer id;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;
    private String answer7;
    private String answer8;
    private String answer9;
    private String answer10;
    private String answer11;
    private String answer12;
    private String answer13;
    private String answer14;
    private String answer15;
    private String answer16;
    private String answer17;
    private String answer18;
    private String answer19;
    private String answer20;


}
