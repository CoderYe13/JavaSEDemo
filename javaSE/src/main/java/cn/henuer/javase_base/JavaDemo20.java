package cn.henuer.javase_base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author CoderYe
 * @version 2020年2月14日 下午3:40:35
 */

public class JavaDemo20 {

	public static void main(String[] args) {
		try {
			{
				Class<?> cls = Class.forName("cn.henuer.javase_base.BigDecimalUtil");
				Constructor<?> constructor = cls.getDeclaredConstructor();
				constructor.setAccessible(true);// 解除private封装处理
				Method method = cls.getMethod("add", double.class, double.class);
				System.out.println(method.invoke(BigDecimalUtil.class, 100.11, 100.22));
			}
			// Class类的类表示正在运行的Java应用程序中的类和接口
			// 当获取一个类的Class对象之后就可以获取该类的一切继承结构信息
			{
				Class<?> clazz = Class.forName("cn.henuer.javase_base.Person");
				System.out.println(clazz.getConstructors()[0]);// 获取公共构造方法
				System.out.println(clazz.getDeclaredConstructors()[0].newInstance("xiaomei", 12));// 调用构造方法实例化对象
				System.out.println(clazz.getSuperclass().getName());// 获取父类
				System.out.println(clazz.getInterfaces()[0]);// 获取该类实现的接口
				System.out.println("-----反射获取方法-----");
				Method methods[] = clazz.getDeclaredMethods();// 没有继承父类的所有方法
				for (Method met : methods) {
					int mod = met.getModifiers();
					System.out.print(Modifier.toString(mod) + " ");
					System.out.print(met.getReturnType() + " ");
					System.out.print(met.getName() + "( )");

					System.out.println();
				}
			}

			System.out.println("-----类加载器-----");

			{// 反射获取类加载器
				Class<?> clazz = Person.class;
				//应用类加载器(System classLoader):又称为系统类加载器,主要用于加载CLASSPATH路径下我们自己写的类，是拓展类加载器的子类。
				System.out.println(clazz.getClassLoader());
				//拓展类加载器(Extension classLoader):主要加载JAVA中的一些拓展类，位于<JAVA_HOME>/lib/ext中,是启动类加载器的子类。
				System.out.println(clazz.getClassLoader().getParent());
				//启动类加载器(Bootstrap classLoader):又称为引导类加载器，由C++编写，无法通过程序得到。主要负责加载JAVA中的一些核心类库，主要是位于<JAVA_HOME>/lib/rt.jar中。
				System.out.println(clazz.getClassLoader().getParent().getParent());//结果为null
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
