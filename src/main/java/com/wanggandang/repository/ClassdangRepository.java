package com.wanggandang.repository;

import com.wanggandang.domain.Classdang;
import com.wanggandang.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassdangRepository extends JpaRepository<Classdang,Integer>{
    List<Classdang> findByClassName(String className);
    Classdang findFirstByOrderByIdDesc();


}
