package com.plm.controller;

import com.plm.mapper.DeptMapper;
import com.plm.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptMapper deptMapper;

    @GetMapping("/dept/queryDeptList")
    public List<Dept> queryDeptList(){
        List<Dept> depts = deptMapper.queryDeptList();
        for(Dept dept : depts){
            System.out.println(dept);
        }
        return depts;
    }

    @GetMapping("/dept/queryDeptById/{id}")
    public Dept queryDeptById(@PathVariable("id") Integer id){
        Dept dept = deptMapper.queryDeptById(id);
        System.out.println(dept);
        return dept;
    }

    @GetMapping("/dept/addDept")
    public String addDept(){
        deptMapper.addDept(new Dept(60,"Java","China"));
        return "add-ok";
    }

    @GetMapping("/dept/updateDept")
    public String updateDept(){
        deptMapper.updateDept(new Dept(60,"C++","China"));
        return "update-ok";
    }

    @GetMapping("/dept/delDeptById/{id}")
    public String delDeptById(@PathVariable("id") Integer id){
        deptMapper.delDeptById(id);
        return "del-ok";
    }
}
