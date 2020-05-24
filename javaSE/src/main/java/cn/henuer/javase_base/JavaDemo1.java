package cn.henuer.javase_base;

/**
 * @author CoderYe
 * @version 2020年1月30日 下午2:45:21
 */

//泛型通配符，解决一些应用传递问题

//class Message<T>{
//	private T content;
//
//	public T getContent() {
//		return content;
//	}
//
//	public void setContent(T content) {
//		this.content = content;
//	}
//}

//class Message<T extends Number>{//设置泛型上限
//	private T content;
//
//	public T getContent() {
//		return content;
//	}
//
//	public void setContent(T content) {
//		this.content = content;
//	}
//}

class Message<T> {// 设置泛型下限
	private T content;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}

public class JavaDemo1 {

	public static void main(String[] args) {
		Message<Integer> msgA = new Message<Integer>();
		// Message<String> msgB=new Message<String>();

		msgA.setContent(110);
		fun(msgA);
//		msgB.setContent("Hello world");
//		fun(msgB);

	}

//	public static void fun (Message<? > temp) {
//		System.out.println(temp.getContent());
//	}

//	public static void fun(Message<? extends Number> temp) {//设置泛型上限
//		System.out.println(temp.getContent());
//	}

	public static void fun(Message<? super Integer> temp) {// 设置泛型下限
		System.out.println(temp.getContent());
	}

}
