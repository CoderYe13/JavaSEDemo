package cn.henuer.javase_base;
/**
*@author CoderYe
*@version 2020年1月31日 下午2:15:50
*/
//匿名内部类
interface IMessage1{
	public void say();
}

public class JavaDemo5 {
	public static void main(String[] args) {
		new IMessage1() {
			@Override
			public void say() {
				System.out.println("hello world");
			}
		}.say();
	}
}
