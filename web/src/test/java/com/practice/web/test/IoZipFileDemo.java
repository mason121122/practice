package com.practice.web.test;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IoZipFileDemo {

    public static void main(String[] args) {

    }

    @Test
    public void testCompressByZip() {
        try (
                //指定压缩完成后zip文件的存储路径
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("/Users/wangfeng/Desktop/test/myFavorites.zip"))
        )
        {
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
