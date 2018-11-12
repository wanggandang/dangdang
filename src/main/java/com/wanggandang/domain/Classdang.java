package com.wanggandang.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="classdang")
public class Classdang {
    @Id
    private Integer id;
    private String className;
}
