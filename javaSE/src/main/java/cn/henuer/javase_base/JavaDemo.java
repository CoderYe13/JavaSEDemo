package cn.henuer.javase_base;

/**
 * @author CoderYe
 * @version 2020年1月29日 下午5:26:16
 */

interface IMessage {
	public String say(String t);
}

class IMessageImpl implements IMessage {

	@Override
	public String say(String s) {
		return "hello " + s;
	}
}

class Factory {
	// 定义泛型方法的规则：
	// 所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的<E>）。
	// 每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
	// 类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
	// 泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）。
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String className) {
		if ("imessageimpl".equalsIgnoreCase(className)) {
			return (T) new IMessageImpl();
		}
		return null;
	}
}

public class JavaDemo {
	public static void main(String[] args) {
		// IMessage<String> msg=new IMessageImpl<String>();
		IMessage msg = (IMessage) Factory.getInstance("imessageimpl");
		System.out.println(msg.say("world").toUpperCase());

//		Integer[] num=fun(1,2,3);
//		for (Integer i : num) {
//			System.out.println(i);
//		}
	}

//	public static <T> T[] fun(T ... args) {
//		return args;
//	}
}
