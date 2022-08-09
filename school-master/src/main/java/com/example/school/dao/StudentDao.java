package com.example.school.dao;

import com.example.school.entity.School;
import com.example.school.entity.StudentClass;
import org.apache.ibatis.annotations.*;
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
    @Insert("insert into school_student (class_id, student_name, student_sex, student_age,school_id) values (#{classId}, #{studentName}," +
            "#{studentSex}, #{studentAge},#{schoolId})")
    int add(StudentClass studentClass);

    /**
     * 更新学生
     *根据id更新
     * @param studentClass
     * @return
     */
    @Update("update school_student set class_id=#{classId}, student_name=#{studentName}," +
            "student_sex=#{studentSex}, student_age=#{studentAge} ,school_id=#{schoolId} where id=#{id}")
    int update(StudentClass studentClass);

    /**
     * 查询所有学生
     *
     * @return
     */
    @Select("select *" +
            " from (school_student left join school_class using (class_id)) left join school using (school_id)")
    List<StudentClass> listAll();
    /**
     * 根据学生名字查询学生
     *
     * @param studentName
     * @return
     */
    @Select("select * from ((select * from school_student where student_name = #{studentName}) as a " +
            "left join school_class using (class_id)) left join school using(school_id)")
    StudentClass findStudentByName(String studentName);



    /**
     * 根据班级id和姓名删除学生
     *
     * @param studentName
     * @return
     */
    @Delete("delete from school_student where student_name=#{studentName}")
    int delete(String studentName);



    /**
     * 按照输入页号查询某一页,一页五行数据
     *
     * @param pageId
     * @return
     */
    @Select("select *" +
            " from (school_student left join school_class using (class_id)) left join school using (school_id)" +
            " limit #{pageId} , 5")
    List<StudentClass> queryByPage(Long pageId);

    /**
     * 学生姓名的模糊查询
     *查询名字包含某个或多个字符的学生的信息
     * @param keyString
     * @param pageId
     * @param pageSize
     * @return
     */
    @Select("select *" +
            " from (school_student left join school_class using (class_id)) left join school using (school_id)" +
            " where student_name like concat('%',#{keyString},'%') limit #{pageId}, #{pageSize}")
    List<StudentClass> queryStuByKeyStr(@Param("keyString") String keyString, @Param("pageId") Long pageId, @Param("pageSize") Long pageSize);

    /**
     * 学校类型的模糊查询
     * 师范类和理工类两类学校的模糊查询
     * @param keyString
     * @param pageId
     * @param pageSize
     * @return
     */
    @Select("select *" +
            " from school where school_name like concat('%',#{keyString},'%') limit #{pageId}, #{pageSize}")
    List<School> querySchByKeyStr(@Param("keyString") String keyString, @Param("pageId") Long pageId, @Param("pageSize") Long pageSize);
}
