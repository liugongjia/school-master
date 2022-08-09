package com.example.school.service;

import com.example.school.entity.School;
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
    StudentClass findStudentByname(String studentName);



    /**
     * 根据姓名删除学生
     *
     * @param studentName
     */
    void deleteStudent(String studentName);


    /**
     * 学生姓名的模糊查询
     *查询名字包含某个或多个字符的学生的信息,并分页展示
     * @param keyString,
     * @param pageId,
     * @param pageSize
     * @return
     */
   List<StudentClass> queryStuByKeyStr(String keyString,Long pageId,Long pageSize);

    /**
     * 学校类型的模糊查询
     * 师范类和理工类两类学校的模糊查询
     * @param keyString
     * @param pageId
     * @param pageSize
     * @return
     */
    List<School> querySchByKeyStr(String keyString, Long pageId, Long pageSize);
}
