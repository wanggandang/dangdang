package com.wanggandang.controller;

import com.wanggandang.domain.Classdang;
import com.wanggandang.domain.Group;
import com.wanggandang.repository.ClassdangRepository;
import com.wanggandang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ClassdangRepository classdangRepository;

    /**
     * 传入所有题目答案进行保存（未测试）
     *
     * @param group
     * @return
     */
    @PostMapping("user/save")
    public String userSave(@RequestBody Group group) {
        String result = userService.userSave(group);
        return result;
    }

    /**
     * 获取班级列表
     *
     * @return
     */
    @GetMapping("findClass")
    public List<Classdang> findClassList() {
        List<Classdang> list = classdangRepository.findAll();
        return list;
    }

    /**
     * 保存列表班级
     * @param className
     * @return
     */
    @GetMapping("saveClass")
    public String save(String className) {
        Classdang classdang = classdangRepository.findFirstByOrderByIdDesc();
        Classdang classdang1 = new Classdang();
        classdang1.setId(classdang.getId()+1);
        classdang1.setClassName(className);
        try {
            classdangRepository.save(classdang1);
            return "添加成功";
        } catch (Exception e) {
            return "添加失败";
        }
    }

    /**
     * 删除列表班级
     * @param className
     * @return
     */
    @GetMapping("deleteClass")
    public String delete(String className) {
        List<Classdang> classdangs = classdangRepository.findByClassName(className);
        try {
            classdangRepository.delete(classdangs.get(0));
            return "删除成功";
        } catch (Exception e) {
            return "删除失败";
        }
    }
}


