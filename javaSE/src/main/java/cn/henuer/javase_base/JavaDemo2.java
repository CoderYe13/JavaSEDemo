package cn.henuer.javase_base;

/**
 * @author CoderYe
 * @version 2020年1月30日 下午3:12:52
 */

//单例设计
//class Singleton{//对象仍然可以被再次实例化
//	private static Singleton instance=new Singleton();
//	
//	private Singleton() {}
//	
//	public static Singleton getInstance() {
//		return instance;
//	}
//	
//	public void print() {
//		System.out.println("hello world");
//	}
//}

//class Singleton{//饿汉式单例模式
//	private static final Singleton INSTANCE=new Singleton();
//	
//	private Singleton() {}
//	
//	public static Singleton getInstance() {
//		return INSTANCE;
//	}
//	
//	public void print() {
//		System.out.println("hello world");
//	}
//}

class Singleton {// 懒汉式单例模式
	private static final Singleton instance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			return new Singleton();
		} else {
			return instance;
		}
	}
	public void print() {
		System.out.println("hello world");
	}
}

public class JavaDemo2 {

	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();

		instance.print();
	}

}
