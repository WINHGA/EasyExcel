package com.hga.utils;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 *  获取项目类路径-工具类
 */
public class FilePathUtil {
    /**
     * 获取项目类路径
     * @return 类路径地址
     */
    public static String getPath(){
        String path = FilePathUtil.class.getClassLoader().getResource("").getPath();
        // 设置路径字符集为 UTF-8
        path = URLDecoder.decode(path, StandardCharsets.UTF_8);
        return path;
    }

    /**
     * 获取项目路径
     * @return 项目路径地址
     */
    public static String getProjectPath(){
        return FilePathUtil.class.getResource("/").getPath().replace("classes/","");
    }

    /**
     * 用于测试输出路径
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getPath());   //  E:/Java/Study/EasyExcel/QuickStart/target/classes
        System.out.println(getProjectPath());  // E:/Java/Study/EasyExcel/QuickStart/target/
    }
}
