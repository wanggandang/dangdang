package com.wanggandang.controller;

import com.wanggandang.domain.User;
import com.wanggandang.repository.UserRepository;
import com.wanggandang.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestService testService;

    /**
     * 得分接口传入班级进行班级评分（未测试）
     * @param classId
     * @return
     */
    @GetMapping("sorce")
    public String setSorce(String classId){
        List<User> users = userRepository.findByClasses(classId);
        String result = testService.setSorce(users);

        return result;
    }
}
