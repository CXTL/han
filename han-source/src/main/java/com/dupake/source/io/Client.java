package com.dupake.source.io;

import java.io.*;

/**
 * @description: io
 * @author: dupake
 * @created: 2021-03-04 17:04
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //适配器模式 字节流适配成字符流操作文件字符串
        InputStream inputStream = new FileInputStream(new File(""));
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        //装饰着模式 将 inputStreamReader 装饰成 BufferedReader 具备缓冲功能
        BufferedReader bf = new BufferedReader(inputStreamReader);

    }



}
