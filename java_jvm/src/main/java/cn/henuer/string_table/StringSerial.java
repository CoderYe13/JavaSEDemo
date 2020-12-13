package cn.henuer.string_table;

public class StringSerial {
    public static void main(String[] args) {
        String s1 = "abc";//字面量定义的方式，"abc"存储在字符串常量池中
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1 == s2);//判断地址：false

        System.out.println(s1);//hello
        System.out.println(s2);//abc
    }
}
