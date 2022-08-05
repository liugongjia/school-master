package com.example.school.service;


import com.example.school.entity.SchoolClass;

import java.util.List;

/**
 * @author zhangzhengguang
 * @date 2022/7/23 5:13 下午
 * @description
 */
public interface SchoolClassService {

    /**
     * 保存班级信息
     *
     * @param schoolClass
     */
    void saveClass(SchoolClass schoolClass);

    /**
     * 更新班级信息
     *
     * @param schoolClass
     */
    void updateClass(SchoolClass schoolClass);

    /**
     * 查询所有班级
     *
     * @return
     */
    List<SchoolClass> listAllClass();

    /**
     * 查询某个班级
     *
     * @param id
     * @return
     */
    SchoolClass findClass(Long id);

    /**
     * 删除班级
     *
     * @param id
     */
    void deleteClass(Long id);
}
