package com.example.school.service;

import com.example.school.entity.SchoolClass;
import com.example.school.entity.StudentClass;

import java.util.List;

/**
 * @author zhangzhengguang
 * @date 2022/7/23 5:13 下午
 * @description
 */
public interface SchoolStudentService {

    /**
     * 保存学生信息
     *
     * @param studentClass
     */
    void saveClass(StudentClass studentClass);

    /**
     * 更新学生信息
     *
     * @param studentClass
     */
    void updateClass(StudentClass studentClass);

    /**
     * 查询所有学生
     *
     * @return
     */
    List<StudentClass> listAllClass();

    /**
     * 根据名字查询某个学生
     *
     * @param studentName
     * @return
     */
    StudentClass findClass(String studentName);

    /**
     * 根据姓名删除学生
     *
     * @param studentName
     */
    void deleteStudent(String studentName);
}
