package com.wanggandang.controller;

import com.wanggandang.domain.User;
import com.wanggandang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarkController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询班级成绩接口（测试通过）
     * @param classId
     * @return
     */
    @GetMapping("getMark")
    public List<User> getMark(String classId){
        List<User> classes = userRepository.findByClassesOrderByGradeDesc(classId);
        return classes;
    }
}
