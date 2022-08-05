package com.example.school.dao;

import com.example.school.entity.StudentClass;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author zhangzhengguang
 * @date 2022/7/23 12:26 下午
 * @description
 */
@Repository
@Mapper
public interface StudentDao {

    /**
     * 新增学生
     *
     * @param studentClass
     * @return
     */
    @Insert("insert into school_student (class_id, student_name, student_sex, student_age) values (#{classId}, #{studentName}," +
            "#{studentSex}, #{studentAge})")
    int add(StudentClass studentClass);

    /**
     * 更新学生
     *根据id更新
     * @param studentClass
     * @return
     */
    @Update("update school_student set class_id=#{classId}, student_name=#{studentName}," +
            "student_sex=#{studentSex}, student_age=#{studentAge} where id=#{id}")
    int update(StudentClass studentClass);

    /**
     * 查询所有学生
     *
     * @return
     */
    @Select("select * from school_student")
    List<StudentClass> listAll();
    /**
     * 根据学生名字查询学生
     *
     * @param studentName
     * @return
     */
    @Select("select * from school_student where student_name=#{studentName}")
    StudentClass findClassByName(String studentName);


    /**
     * 根据学生名字和班级id查询学生
     *
     * @param classId,studentName
     * @return
     */
    @Select("select * from school_student where student_name=#{studentName} and class_id=#{classId}")
    StudentClass findClassByNameAndClassId(Long classId, String studentName);

    /**
     * 根据班级id和姓名删除学生
     *
     * @param studentName
     * @return
     */
    @Delete("delete from school_student where student_name=#{studentName}")
    int delete(String studentName);
}
