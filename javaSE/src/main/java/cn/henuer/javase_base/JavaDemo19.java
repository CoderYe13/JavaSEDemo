package cn.henuer.javase_base;

/**
 * @author CoderYe
 * @version 2020年2月13日 下午4:26:38
 */
//饿汉式
class EagerSingleton {
	private static EagerSingleton EAGER_SINGLETON = new EagerSingleton();

	private EagerSingleton() {
	}

	public static EagerSingleton getInstance() {
		return EAGER_SINGLETON;
	}
}
//懒汉式
class LazySingleton {
	private static LazySingleton lazySingleton=null;

	private LazySingleton() {
	}

	public static LazySingleton getInstance() {
		if (lazySingleton == null) {
			synchronized (LazySingleton.class) {
				if (lazySingleton == null) {
					lazySingleton= new LazySingleton();
				}
			}
		}
		return lazySingleton;
	}
}

public class JavaDemo19 {

	public static void main(String[] args) {
		for (int x = 0; x < 10; x++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread() +"\\"+ LazySingleton.getInstance());
			}).start();
		}
	}

}
