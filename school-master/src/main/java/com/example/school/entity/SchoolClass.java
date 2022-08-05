package com.example.school.entity;

/**
 * @author zhangzhengguang
 * @date 2022/7/23 4:58 下午
 * @description
 */
public class SchoolClass {

    /**
     * id
     */
    private Long id;
    /**
     * 班级名称
     */
    private String className;

    /**
     * 班级描述
     */

    private String classDesc;


    public void setId(Long id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public Long getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public String getClassDesc() {
        return classDesc;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", classDesc='" + classDesc + '\'' +
                '}';
    }
}
