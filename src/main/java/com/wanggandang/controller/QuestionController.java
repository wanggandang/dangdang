package com.wanggandang.controller;

import com.wanggandang.domain.Question;
import com.wanggandang.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    /**
     * 获取所有题目接口 （测试通过）
     * @return
     */
    @GetMapping("getQuestion")
    public List<Question> getQuestion(){
        List<Question> all = questionRepository.findAll();
        return all;
    }
}
