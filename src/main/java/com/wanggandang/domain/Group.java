package com.wanggandang.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Group {
    private Test test;
    private User user;
}
