package com.hga.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.hga.pojo.Employee;
import com.hga.utils.FilePathUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 *  快速入门： 读数据
 */
@Slf4j
public class SimpleRead {
    @Test
    public void read(){
        String fileName = FilePathUtil.getProjectPath() + "simpleWrite1711471685051.xlsx";
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`监听器的构造函数设置（默认提供的监听器） 可以自己实现
        EasyExcel.read(fileName, Employee.class, new PageReadListener<Employee>(dataList -> {
            for (Employee data : dataList) {
                System.out.println(data.toString());
            }
        })).sheet().doRead();
    }
}
