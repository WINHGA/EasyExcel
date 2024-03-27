package com.hga.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.hga.dao.EmployeeDao;
import com.hga.listener.EmployeeListener;
import com.hga.pojo.Employee;
import com.hga.utils.FilePathUtil;
import org.junit.Test;

/**
 * 使用自定义监听器读取数据
 */
public class MyRead {

    @Test
    public void read(){
        // 读取文件的路径 sdfsdf
        String fileName = FilePathUtil.getProjectPath() + "repeatedWrite1711279182984.xlsx";
        // 构建excel读对象
        ExcelReader reader = EasyExcel.read(fileName, Employee.class, new EmployeeListener(new EmployeeDao())).build();
        // 构建easyExcel的sheet页读对象
        ReadSheet sheet = EasyExcel.readSheet().build();
        reader.read(sheet);
    }
}
