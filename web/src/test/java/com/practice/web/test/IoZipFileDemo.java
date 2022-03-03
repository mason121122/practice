package com.practice.web.test;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class IoZipFileDemo {

    public static void main(String[] args) throws IOException {
        String aa = "123123123 bububu 你好！   我好！  他好! 啊哈哈ususus   设计师记事本想";
        byte[] b = aa.getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);
        ZipEntry entry = new ZipEntry("111.txt");
        entry.setSize(b.length);
        zos.putNextEntry(entry);
        zos.write(b);
        zos.closeEntry();
        zos.close();

        System.out.println(Arrays.toString(baos.toByteArray()));
        new FileOutputStream("/Users/wangfeng/Desktop/test/myFavorites.zip").write(baos.toByteArray());

    }

    @Test
    public void testCompressByZip() {
        try (
                //指定压缩完成后zip文件的存储路径
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("/Users/wangfeng/Desktop/test/myFavorites.zip"))
        ) {
            //待压缩文件/目录所在的目录
            File fileFolder = new File("/Users/wangfeng/Desktop/test/");
            //获取目录下的所有文件
            File[] files = fileFolder.listFiles();

            ZipEntry zipEntry;
            byte[] byteArray;
            int len;
            //遍历目录下的所有文件/目录，并将它们添加到压缩文件中
            assert files != null;
            for (File file : files) {
                //一个ZipEntry对应压缩文件中的一项
                zipEntry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(zipEntry);
                try (FileInputStream in = new FileInputStream(file)) {
                    byteArray = new byte[1024];
                    while ((len = in.read(byteArray)) != -1) {
                        zipOutputStream.write(byteArray, 0, len);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                zipOutputStream.closeEntry();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
