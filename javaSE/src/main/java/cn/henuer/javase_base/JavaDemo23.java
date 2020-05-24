package cn.henuer.javase_base;
/**
*@author CoderYe
*@version 2020年3月4日 下午3:26:23
*/
class Hellos{
	
	{
		System.out.println("父类构造代码块");
	}
	public Hellos() {
		System.out.println("执行构造方法");
	}
	static{
		System.out.println("执行static代码块");
	}
//	try {
//		
//	}catch(Exception e){
//		e.printStackTrace();
//	}finally {
//		System.out.println("执行finally");
//	}
	
}
public class JavaDemo23 {

	public static void main(String[] args) {
		new Hellos();
	}

}
