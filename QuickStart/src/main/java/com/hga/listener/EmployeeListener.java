package com.hga.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.hga.dao.EmployeeDao;
import com.hga.pojo.Employee;

import java.util.ArrayList;

/**
 * 监听器： 类似于回调函数，在开始前做什么操作，在完成后做什么操作等。
 */
public class EmployeeListener  implements ReadListener<Employee> {
    // 定义缓存集合的大小,我们默认为5，可以根据文件大小，自定义。
    private int count = 5;
    // 定义缓存数据集合
    private ArrayList<Employee> list = new ArrayList<>(count);

    // 导入dao层接口
    private EmployeeDao employeeDao;

    public EmployeeListener(EmployeeDao dao){
        this.employeeDao = dao;
    }


    // 每次读取一行数据都会执行监听器中的这个方法
    @Override
    public void invoke(Employee employee, AnalysisContext analysisContext) {
        // 如果每读一条数据，就执行插入数据库中，那么效率必定会慢，所以我们先将读取的数据，写入到缓存集合中，当缓存集合达到指定大小，再写入到数据库中，然后清空缓存集合。
        list.add(employee);
        // 判断
        if(list.size() >= count){
            // 写入数据库中，
            employeeDao.save(list);

            // 清空缓存集合
            list.clear();
        }
    }

    // 读取完整个excel之后，执行这个方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 可能读取完剩余几条数据没有达到缓存大小，所以在读取完整个sheet页后，再向数据库中写入当前缓存集合中剩余的数据
        // 写入数据库中，
        employeeDao.save(list);

        // 清空缓存集合
        list.clear();
    }
}
