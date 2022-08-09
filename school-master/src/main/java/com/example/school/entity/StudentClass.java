package com.example.school.entity;

/**
 * @author zhangzhengguang
 * @date 2022/7/23 4:58 下午
 * @description
 */
public class StudentClass {
    private long id;
    private long classId;
    private String studentName;
    private char studentSex;
    private Integer studentAge;
    private long schoolId;

    private String className;

    private String classDesc;

    private String schoolName;
    private String schoolAddress;
    private String schoolType;

    public StudentClass() {
    }

    public StudentClass(long id, long classId, String studentName, char studentSex, Integer studentAge, long schoolId, String className, String classDesc, String schoolName, String schoolAddress, String schoolType) {
        this.id = id;
        this.classId = classId;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentAge = studentAge;
        this.schoolId = schoolId;
        this.className = className;
        this.classDesc = classDesc;
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
        this.schoolType = schoolType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public char getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(char studentSex) {
        this.studentSex = studentSex;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", classId=" + classId +
                ", studentName='" + studentName + '\'' +
                ", studentSex=" + studentSex +
                ", studentAge=" + studentAge +
                ", schoolId=" + schoolId +
                ", className='" + className + '\'' +
                ", classDesc='" + classDesc + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolAddress='" + schoolAddress + '\'' +
                ", schoolType='" + schoolType + '\'' +
                '}';
    }
}
