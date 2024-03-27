package com.hga.dao;

import com.hga.pojo.Employee;
import java.util.List;

/**
 * 模拟操作数据库方法
 */
public class EmployeeDao {

    public void save(List<Employee> list){
        // 模拟写入到数据中
        list.forEach(System.out::println);
    }
}
