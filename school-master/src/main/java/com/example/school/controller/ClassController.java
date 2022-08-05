package com.example.school.controller;

import com.example.school.entity.SchoolClass;
import com.example.school.service.SchoolClassService;
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
@Api(value = "班级管理", tags = "班级管理")
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private SchoolClassService schoolClassService;

    /**
     * 新增班级
     *
     * @return
     */
    @ApiOperation(value = "新增班级")
    @PostMapping("/add")
    public R addClass(@RequestBody SchoolClass schoolClass) {
        schoolClassService.saveClass(schoolClass);
        return R.ok();
    }

    /**
     * 更新班级信息
     *
     * @return
     */
    @ApiOperation(value = "更新班级信息")
    @PutMapping("/update")
    public R updateClass(@RequestBody SchoolClass schoolClass) {
        schoolClassService.updateClass(schoolClass);
        return R.ok();
    }

    /**
     * 查询所有班级
     *
     * @return
     */
    @ApiOperation(value = "查询所有班级")
    @GetMapping("/list")
    public R listClass() {
        return R.ok(schoolClassService.listAllClass());
    }

    /**
     * 查询id查询某个班级
     *
     * @return
     */
    @ApiOperation(value = "查询id查询某个班级")
    @GetMapping("/{id}")
    public R findClass(@PathVariable Long id) {
        return R.ok(schoolClassService.findClass(id));
    }

    /**
     * 删除班级
     *
     * @return
     */
    @ApiOperation(value = "删除班级")
    @DeleteMapping("/{id}")
    public R delClass(@PathVariable Long id) {
        schoolClassService.deleteClass(id);
        return R.ok();
    }

}
