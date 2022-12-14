package com.example.school.controller;

import com.example.school.entity.StudentClass;
import com.example.school.service.SchoolStudentService;
import com.example.school.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangzhengguang
 * @date 2022/7/23 10:33 上午
 * @description
 */
@Api(value = "学生管理", tags = "学生管理")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private SchoolStudentService studentService;

    /**
     * 新增学生
     *
     * @return
     */
    @ApiOperation(value = "新增学生")
    @PostMapping("/add")
    public R addStudent(@RequestBody StudentClass studentClass) {
        studentService.saveClass(studentClass);
        return R.ok();
    }

    /**
     * 更新学生信息
     *
     * @return
     */
    @ApiOperation(value = "更新学生信息")
    @PutMapping("/update")
    public R updateStudent(@RequestBody StudentClass studentClass) {
        studentService.updateClass(studentClass);
        return R.ok();
    }

    /**
     * 查询所有学生
     *
     * @return
     */
    @ApiOperation(value = "查询所有学生")
    @GetMapping("/list")
    public R listStudent() {
        return R.ok(studentService.listAllClass());
    }

    /**
     * 根据id查询某个学生
     *
     * @return
     */
    @ApiOperation(value = "根据名字查询某个学生")
    @GetMapping("/{studentName}")
    public R findStudent(@PathVariable String studentName) {
        return R.ok(studentService.findStudentByname(studentName));
    }

    /**
     * 删除学生
     *
     * @return
     */
    @ApiOperation(value = "删除学生")
    @DeleteMapping("/{pageId}")
    public R delClass(@PathVariable String studentName) {
        studentService.deleteStudent(studentName);
        return R.ok();
    }


    @ApiOperation(value = "根据学生姓名模糊查寻")
    @RequestMapping(name = "/test2/{keyString}/{pageId}/{pageSize}")
    public R queryStuByKeyStr(@PathVariable String keyString, @PathVariable Long pageId, @PathVariable Long pageSize) {
        return R.ok(studentService.queryStuByKeyStr(keyString,pageId,pageSize));
    }

    @ApiOperation(value = "根据学校类型模糊查寻")
    @RequestMapping(name = "/test3/{keyString}/{pageId}/{pageSize}")
    public R querySchByKeyStr(@PathVariable String keyString, @PathVariable Long pageId, @PathVariable Long pageSize) {
        return R.ok(studentService.querySchByKeyStr(keyString,pageId,pageSize));
    }
}
