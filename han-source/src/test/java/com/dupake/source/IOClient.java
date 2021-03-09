package com.dupake.source;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @description: test
 * @author: dupake
 * @created: 2021-03-05 10:20
 */
public class IOClient {

    private final static String PATH = "/Users/xt/Desktop/data/doc/";
    private final static String FILE_NAME = "Dump20200827.sql";

    /**
     * io流文件复制
     * @throws Exception
     */
    @Test
    public void testIO() throws Exception {
        System.out.println("开始: ... ");
        FileInputStream fis = new FileInputStream(PATH+FILE_NAME);
        FileOutputStream fos = new FileOutputStream(PATH+"output-testIO.sql");
        int read=0;
        long start =System.currentTimeMillis();
        while((read=fis.read())!=-1){
            fos.write(read);
        }
        System.out.println("耗时: "+(System.currentTimeMillis()-start) );//520 ms
        fis.close();
        fos.close();
    }


    @Test
    public void testNIO1(){
        try (
                FileInputStream fis = new FileInputStream(PATH+FILE_NAME);
                FileOutputStream fos = new FileOutputStream(PATH+"output-testNIO1.sql");
        ){
            //1.获取通道
            FileChannel inChannel = fis.getChannel();
            FileChannel   outChannel = fos.getChannel();

            //2.分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            long start = System.currentTimeMillis();
            //3.将通道中的数据缓冲区中
            while (inChannel.read(buffer) != -1) {
                buffer.flip();//切换成都数据模式
                //4.将缓冲区中的数据写入通道中
                outChannel.write(buffer);
                buffer.clear();//清空缓冲区
            }
            System.out.println("总耗时:" + (System.currentTimeMillis() - start)); // 20 ms
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test
    public void testNIO2() throws Exception{
        // 直接获取通道
        FileChannel inChannel2 = FileChannel.open(Paths.get(PATH+FILE_NAME), StandardOpenOption.READ);
        FileChannel outChannel2 = FileChannel.open(Paths.get(PATH+"output-testNIO2.sql"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel2.map(FileChannel.MapMode.READ_ONLY, 0, inChannel2.size());
        MappedByteBuffer outMappedBuf = outChannel2.map(FileChannel.MapMode.READ_WRITE, 0, inChannel2.size());
        //直接对缓冲区进行数据读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        long start = System.currentTimeMillis();
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);
        System.out.println("耗费的时间为：" + ( System.currentTimeMillis() - start));//9 ms

        inChannel2.close();
        outChannel2.close();

    }



    @Test
    public void testNIO3() throws Exception{
        /*
         * 通道之间的数据传输（直接缓冲区）
         */
        FileChannel inChannel3 = FileChannel.open(Paths.get(PATH+FILE_NAME), StandardOpenOption.READ);
        FileChannel outChannel3 = FileChannel.open(Paths.get(PATH+"output-testNIO3.sql"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        long start = System.currentTimeMillis();
        inChannel3.transferTo(0, inChannel3.size(), outChannel3);
        System.out.println("耗时: "+(System.currentTimeMillis()-start) );//14 ms

        //等价于
        // outChannel3.transferFrom(inChannel3, 0, inChannel3.size());

        inChannel3.close();
        outChannel3.close();
    }




}
