package com.example.school.service.impl;

import com.example.school.dao.StudentDao;
import com.example.school.entity.School;
import com.example.school.entity.StudentClass;
import com.example.school.service.SchoolStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolStudentServiceImpl implements SchoolStudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public void saveClass(StudentClass studentClass) {
        StudentClass classByName = null;
        try {
            classByName = studentDao.findStudentByName(studentClass.getStudentName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        if (classByName == null){
            studentDao.add(studentClass);
            return;
        }
        if ((classByName.getClassId() == studentClass.getClassId()) &&
            classByName.getStudentAge() == studentClass.getStudentAge() &&
            classByName.getStudentSex() == studentClass.getStudentSex() &&
            classByName.getSchoolId() == studentClass.getSchoolId()) {
            throw new RuntimeException("出现完全一致学生信息，请确认输入无误");
        }
        try {
            studentDao.add(studentClass);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateClass(StudentClass studentClass) {
        StudentClass classByName = null;
        try {
            classByName = studentDao.findStudentByName(studentClass.getStudentName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (classByName == null){
            studentDao.update(studentClass);
            return;
        }
        if ((classByName.getClassId() == studentClass.getClassId()) &&
                classByName.getStudentAge() == studentClass.getStudentAge() &&
                classByName.getStudentSex() == studentClass.getStudentSex() &&
                classByName.getSchoolId() == studentClass.getSchoolId()) {
            throw new RuntimeException("出现完全一致学生信息，请确认输入无误");
        }
        studentDao.update(studentClass);
    }

    @Override
    public List<StudentClass> listAllClass() {
        return studentDao.listAll();
    }

    @Override
    public StudentClass findStudentByname(String studentName) {
        return studentDao.findStudentByName(studentName);
    }



    @Override
    public void deleteStudent(String studentName) {
        if (studentDao.findStudentByName(studentName) == null) {
            throw new RuntimeException("不存在该名字的同学");
        }
        studentDao.delete(studentName);
    }

    @Override
    public List<StudentClass> queryStuByKeyStr(String keyString, Long pageId, Long pageSize) {
        Long n = ((pageId - 1) * pageSize);
        return studentDao.queryStuByKeyStr(keyString,n,pageSize);
    }


    @Override
    public List<School> querySchByKeyStr(String keyString,Long pageId, Long pageSize) {
        return studentDao.querySchByKeyStr(keyString,pageId,pageSize);
    }
}
