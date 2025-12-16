package com.tweiy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweiy.pojo.Dept;
import com.tweiy.pojo.Result;
import com.tweiy.service.DepService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DepController {

    @Autowired
    private DepService depService;

    /**
     * 查询所有部门
     */
    @GetMapping
    public Result list() {
        log.info("查询所有部门");
        List<Dept> deptList = depService.findAll();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门
     */
    @DeleteMapping
    public Result deleteById(Integer id) {
        log.info("根据id删除部门, id={}", id);
        Integer deleteCount = depService.deleteById(id);
        if (deleteCount == 0) {
            return Result.error("删除失败, id不存在");
        }
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门, dept={}", dept);
        depService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询部门, id={}", id);
        Dept dept = depService.getById(id);
        if (dept == null) {
            return Result.error("查询失败, id不存在");
        }
        return Result.success(dept);
    }

    /**
     * 修改部门
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门, dept={}", dept);
        Integer updateCount = depService.update(dept);
        if (updateCount == 0) {
            return Result.error("更新失败, id不存在");
        }
        return Result.success();
    }
}
