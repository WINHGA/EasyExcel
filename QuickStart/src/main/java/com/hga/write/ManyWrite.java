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
 * 批量写数据
 */
public class ManyWrite {

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
        // 方法2: 如果写到不同的sheet 同一个对象
        String fileName = FilePathUtil.getProjectPath() + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 指定文件
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, Employee.class).build()) {
            // 统计开始写前的时间
            long startTime = System.currentTimeMillis();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            for (int i = 0; i < 5; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<Employee> data = data(1000000);
                excelWriter.write(data, writeSheet);
            }
            // 统计结束的时间
            long entTime = System.currentTimeMillis();

            System.out.println("最后耗时时间："+ (entTime - startTime) + "毫秒");
        }
    }
}
