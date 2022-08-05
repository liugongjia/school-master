package com.example.school.dao;

import com.example.school.entity.SchoolClass;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhangzhengguang
 * @date 2022/7/23 12:26 下午
 * @description
 */
@Mapper
public interface ClassDao {

    /**
     * 新增班级
     *
     * @param schoolClass
     * @return
     */
    @Insert("insert into school_class (class_name, class_desc) values (#{className}, #{classDesc})")
    int add(SchoolClass schoolClass);

    /**
     * 更新班级
     *
     * @param schoolClass
     * @return
     */
    @Update("update school_class set class_name=#{className}, class_desc=#{classDesc} where id=#{id}")
    int update(SchoolClass schoolClass);

    /**
     * 查询所有班级
     *
     * @return
     */
    @Select("select * from school_class")
    List<SchoolClass> listAll();

    /**
     * 查询某个班级
     *
     * @param id
     * @return
     */
    @Select("select * from school_class where id=#{id}")
    SchoolClass findClassById(Long id);

    /**
     * 根据班级名称查询班级
     *
     * @param className
     * @return
     */
    @Select("select * from school_class where class_name=#{className}")
    SchoolClass findClassByName(String className);

    /**
     * 删除班级
     *
     * @param id
     * @return
     */
    @Delete("delete from school_class where id=#{id}")
    int delete(Long id);
}
