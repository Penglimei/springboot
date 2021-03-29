package com.plm.mapper;

import com.plm.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    List<Dept> queryDeptList();
    Dept queryDeptById(int id);
    int addDept(Dept dept);
    int updateDept(Dept dept);
    int delDeptById(int id);
}
