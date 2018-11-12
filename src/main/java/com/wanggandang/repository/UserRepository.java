package com.wanggandang.repository;

import com.wanggandang.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String>{
   List<User> findFirstByOrderByTestIdDesc();
   List<User> findByClassesOrderByGradeDesc(String id);
   List<User> findByClasses(String id);
   User findByTestId(Integer id);
}
