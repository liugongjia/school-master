# springboot学习demo

## 使用步骤
### 新建数据库表
```bash
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for school_class
-- ----------------------------
DROP TABLE IF EXISTS `school_class`;
CREATE TABLE `school_class` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `class_name` varchar(100) NOT NULL COMMENT '班级名称',
  `class_desc` varchar(255) DEFAULT NULL COMMENT '班级描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='学校班级表';

-- ----------------------------
-- Table structure for school_student
-- ----------------------------
DROP TABLE IF EXISTS `school_student`;
CREATE TABLE `school_student` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `class_id` bigint NOT NULL COMMENT '班级id',
  `student_name` varchar(255) NOT NULL COMMENT '学生名称',
  `student_sex` varchar(10) NOT NULL COMMENT '学生性别',
  `student_age` int NOT NULL COMMENT '学生年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校班级表';

SET FOREIGN_KEY_CHECKS = 1;

```
### 下载项目到本地
```bash
git clone -b master https://github.com/zhangzhengguang-ai/school.git
```
### 启动项目访问接口文档
```bash
http://localhost:8080/school/doc.html#/home
```

## 作业
```bash
请模仿班级管理,完成学生管理相关借口
```