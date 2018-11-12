package com.wanggandang.service;

import com.wanggandang.domain.Answer;
import com.wanggandang.domain.Test;
import com.wanggandang.domain.User;
import com.wanggandang.repository.AnswerRepository;
import com.wanggandang.repository.TestRepository;
import com.wanggandang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    private Integer  ANSWERID=1;
    private Integer  TESTNUM=20;


    @Autowired
    private TestRepository testRepository;

    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private AnswerRepository answerRepository;
    /**
     * 一键评分功能
     * @param users 将所有的学生人数传入，然后获取所有人的试题答案，然后再将所有人的答案获取进行比对
     */
    public String setSorce(List<User> users) {

        for (User user : users) {
            Integer testId = user.getTestId();
            Test test = testRepository.findById(testId).get();
//            Optional<Answer> answer = answerRepository.findById(ANSWERID);
            Answer answer = answerRepository.findById(ANSWERID).get();
            try {
                    int grade = getMethod(test,answer);
                    user.setGrade(grade);
                    userRepository.save(user);
                    return "评分成功";
                } catch (Exception e) {
                    return "评分失败";
                }
            }

        return null;
    }

    /**
     *
     * @param test
     * @return    返回值为总分数
     * @throws Exception
     */
    public int getMethod(Test test,Answer answer) throws Exception {
        Class<?> t1 = Class.forName("com.wanggandang.domain.Test");
        Class<?> t2 = Class.forName("com.wanggandang.domain.Answer");
//        Object testObj = t1.newInstance();
//        Object answerObj = t2.newInstance();
        int grade = 0;
        for (int i = 1; i <= TESTNUM; i++) {
            Method method1=t1.getMethod("getTest"+i);
            Method method2=t2.getMethod("getAnswer"+i);
            String studentAnswer = (String) method1.invoke(test);
            String tureAnswer = (String) method2.invoke(answer);
            if (tureAnswer.equals(studentAnswer)){
                grade+=2;
            }
        }
        return grade;
    }


}
