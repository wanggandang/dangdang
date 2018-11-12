package com.wanggandang.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="question")
public class Question {

    @Id
    private Integer id;
    private String questionName;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

}
