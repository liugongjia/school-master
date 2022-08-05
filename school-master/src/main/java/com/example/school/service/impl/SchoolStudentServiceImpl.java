package com.example.school.service.impl;

import com.example.school.dao.StudentDao;
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
            classByName = studentDao.findClassByName(studentClass.getStudentName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        if ((classByName.getClassId() == studentClass.getClassId()) &&
            classByName.getStudentAge() == studentClass.getStudentAge() &&
            classByName.getStudentSex() == studentClass.getStudentSex()) {
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
            classByName = studentDao.findClassByName(studentClass.getStudentName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if ((classByName.getClassId() == studentClass.getClassId()) &&
                classByName.getStudentAge() == studentClass.getStudentAge() &&
                classByName.getStudentSex() == studentClass.getStudentSex()) {
            throw new RuntimeException("出现完全一致学生信息，请确认输入无误");
        }
        studentDao.update(studentClass);
    }

    @Override
    public List<StudentClass> listAllClass() {
        return studentDao.listAll();
    }

    @Override
    public StudentClass findClass(String studentName) {
        return studentDao.findClassByName(studentName);
    }

    @Override
    public void deleteStudent(String studentName) {
        if (studentDao.findClassByName(studentName) == null) {
            throw new RuntimeException("不存在该名字的同学");
        }
        studentDao.delete(studentName);
    }
}
