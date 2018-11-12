package com.wanggandang.repository;

import com.wanggandang.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TestRepository extends JpaRepository<Test,Integer> {
}
