package cn.henuer;

import java.util.Random;

/**
 * 说明：使用static+final修饰的字段的显示赋值的操作，到底是哪个阶段进行的赋值？
 * 情况1： 在连接阶段的准备环节赋值
 * 情况2：在初始化阶段<clinit>()中赋值
 *
 * 结论：
 *   在链接阶段的准备环节赋值的情况：
 *  1、对于基本数据类型的字段来说，如果使用static final修饰，则显示赋值（直接赋值常量，而不是调用方法）通常是在链接阶段的准备环节赋值
 *  2、对于String来说，如果使用字面量方法赋值，使用static final修饰的话，则显示赋值通常是在链接阶段的准备环节
 *
 *  在初始化阶段中赋值的情况：
 *  排除上述的在准备环节赋值的情况之外的情况
 *
 *  最终结论：使用static final修饰的变量，且显示赋值不涉及到任意类型方法或者构造器调用的基本数据类型或者String类型的显示赋值，是在链接阶段的准备环节进行
 */
public class InitializationTest1 {

    public static int a=1;//在初始化阶段<clinit>() 中赋值
    public static final int INT_CONST=10;//在连接准备阶段的环节赋值

    public static final Integer INTEGER_CONSTAN=Integer.valueOf(100);//在初始化阶段<clinit>() 中赋值
    public static Integer INTEGER_CONSTANT2=Integer.valueOf(1000);//在初始化阶段<clinit>() 中赋值

    public static final String s0="helloworld1";//在连接准备阶段的环节赋值
    public static final String s1=new String("helloworld2");//在初始化阶段<clinit>() 中赋值

    public static String s2="helloworld2";//在初始化阶段<clinit>() 中赋值

    public static final int NUM=new Random().nextInt(10);//在初始化阶段<clinit>() 中赋值
}
