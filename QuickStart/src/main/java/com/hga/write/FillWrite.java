package com.hga.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.hga.pojo.Employee;
import com.hga.utils.FilePathUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 填充代码： 使用模板
 */
public class FillWrite {
    /**
     * 测试数据
     * @param count 条数
     * @return 数据集合
     */
    private List<Employee> data(int count) {
        List<Employee> list = ListUtils.newArrayList();    // alibaba 提供的工具类创建 集合
        for (int i = 1; i <= count; i++) {
            list.add(new Employee(i, "张三"+i,new Date(),6.6 * i,""));
        }
        return list;
    }

    @Test
    public void write(){
        // 方案2 分多次 填充 会使用文件缓存（省内存）
        // 获取文件路径 并拼接文件名
        String fileName = FilePathUtil.getProjectPath() + "listFill" + System.currentTimeMillis() + ".xlsx";
        // 读取模板文件
        String templateFileName = FilePathUtil.getProjectPath() + "template.xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            excelWriter.fill(data(10), writeSheet);
        }
    }

}
