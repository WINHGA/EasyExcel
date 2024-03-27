package com.hga.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.hga.pojo.Employee;
import com.hga.utils.FilePathUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 快速入门： 写数据
 */
public class SimpleWrite {
    /**
     * 测试数据
     * @param count 条数
     * @return 数据集合
     */
    private List<Employee> data(int count) {
        List<Employee> list = ListUtils.newArrayList();    // alibaba 提供的工具类创建 集合
        for (int i = 1; i <= count; i++) {
            list.add(new Employee(i, "姓名"+i,new Date(),6.6 * i,""));
        }
        return list;
    }

    @Test
    public void write(){
        // 获取文件路径 并拼接文件名
        String fileName = FilePathUtil.getProjectPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Employee.class).sheet("sheet-写入的数据").doWrite(data(10));
    }
}
