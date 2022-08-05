package com.example.school.service.impl;

import com.example.school.dao.ClassDao;
import com.example.school.entity.SchoolClass;
import com.example.school.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangzhengguang
 * @date 2022/7/23 5:17 下午
 * @description
 */
@Service
public class SchoolClassServiceImpl implements SchoolClassService {
    @Autowired
    private ClassDao classDao;

    @Override
    public void saveClass(SchoolClass schoolClass) {
        SchoolClass existClass = classDao.findClassByName(schoolClass.getClassName());
        if (existClass != null) {
            throw new RuntimeException("班级名称不能重复！");
        }
        classDao.add(schoolClass);
    }

    @Override
    public void updateClass(SchoolClass schoolClass) {
        // TODO 更新时候保证班级名称不能重复，补充完整
        SchoolClass existClass = classDao.findClassByName(schoolClass.getClassName());
        if (existClass != null) {
            throw new RuntimeException("班级名称不能重复！");
        }
        classDao.update(schoolClass);
    }

    @Override
    public List<SchoolClass> listAllClass() {
        return classDao.listAll();
    }

    @Override
    public SchoolClass findClass(Long id) {
        if (classDao.findClassById(id) == null) {
            throw new RuntimeException("不存在本id的班级");
        }
        return classDao.findClassById(id);
    }


    @Override
    public void deleteClass(Long id) {
        if (classDao.findClassById(id) == null) {
            throw new RuntimeException("不存在本id的班级");
        }
        classDao.delete(id);
    }
}
