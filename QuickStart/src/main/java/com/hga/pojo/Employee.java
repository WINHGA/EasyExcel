package com.hga.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 与 excel 文件相对应的模型类
 *
 * 解释： excel 中每一列 对应于 模型中的每一个属性
 */
@Data                                // lombok 中的注解 : 帮助我们构建setter、getter、toString、equals、hashcode 方法
@NoArgsConstructor                   // lombok 中的注解 ： 生成无参构造方法
@AllArgsConstructor                  // lombok 中的注解 : 生成全参数构造方法 顺序为属性编写的顺序
public class Employee {
    /*
        @ExcelProperty("文字")  easyExcel 中的注解： 添加到对应的属性上，对应文字，将是生成的excel的列名
        @ExcelIgnore           easyExcel 中的注解： 添加到对应的属性上，忽略当前字段，将不会生成对应的excel的列
     */
    // 成员变量
    @ExcelProperty("员工工号")
    private Integer id;
    @ExcelProperty("员工姓名")
    private String name;
    @ExcelProperty("入职日期")
    private Date date;
    @ExcelProperty("员工工资")
    private Double salary;
    /**
     * 忽略的属性
     */
    @ExcelIgnore
    private String ignore;

}
