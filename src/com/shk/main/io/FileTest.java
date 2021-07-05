package com.shk.main.io;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\宏坤\\Desktop\\sqlldr配置\\user1.txt");
        String name = file.getName();
        System.out.println(name);
    }
}
