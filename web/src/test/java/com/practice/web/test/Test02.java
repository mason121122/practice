package com.practice.web.test;

/**
 * @author Mark Wang
 * @date 2022/4/21 23:39
 */
public class Test02 {

    public static void main(String[] args) {
        System.out.println(111);
        Test02 tst = new Test02();
        tst.test01();
        System.out.println(2222);
    }
    public void test01(){
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }
}
