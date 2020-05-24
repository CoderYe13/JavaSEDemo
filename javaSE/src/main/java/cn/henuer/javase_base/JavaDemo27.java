package cn.henuer.javase_base;
/**
*@author CoderYe
*@version 2020年3月28日 下午5:25:56
*/
public class JavaDemo27 implements Runnable{

	@Override
	public void run() {
		//业务逻辑
		System.out.println("123");
	}

	public static void main(String[] args) {
		JavaDemo27 task=new JavaDemo27();
		new Thread(task).start();
	}
}
