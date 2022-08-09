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
    private Long classId;
    /**
     * 班级名称
     */
    private String className;

    /**
     * 班级描述
     */

    private String classDesc;


    public SchoolClass() {
    }

    public SchoolClass(Long classId, String className, String classDesc) {
        this.classId = classId;
        this.className = className;
        this.classDesc = classDesc;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classDesc='" + classDesc + '\'' +
                '}';
    }
}
