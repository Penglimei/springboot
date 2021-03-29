package com.plm.dao;

import com.plm.pojo.Department;
import com.plm.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    // 模拟数据
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"AA","12345@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","67893@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1004,"CC","65345@qq.com",0,new Department(103,"市场部")));
        employees.put(1004,new Employee(1004,"DD","23637@qq.com",1,new Department(104,"研发部")));
        employees.put(1005,new Employee(1005,"EE","25153@qq.com",0,new Department(105,"后勤部")));
    }

    // 主键自增
    private static Integer initId = 1006;

    // 增加一个员工
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    // 查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 通过 id 查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    // 通过 id 删除员工
    public void delEmployee(Integer id){
        employees.remove(id);
    }
}
