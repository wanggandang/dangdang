package com.wanggandang.service;

import com.wanggandang.domain.Group;
import com.wanggandang.domain.Test;
import com.wanggandang.domain.User;
import com.wanggandang.repository.TestRepository;
import com.wanggandang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestRepository testRepository;

    @Transactional
    public String userSave(Group group) {

        try {
            User user = group.getUser();

            List<User> list = userRepository.findFirstByOrderByTestIdDesc();
            Integer testId = list.get(0).getTestId();

            if (testId == null) {
                testId = 1;
            } else {
                testId++;
            }
            user.setTestId(testId);
            userRepository.save(user);

            Test test = group.getTest();
            test.setId(user.getTestId());
            testRepository.save(test);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }


}
