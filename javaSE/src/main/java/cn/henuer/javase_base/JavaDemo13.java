package cn.henuer.javase_base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author CoderYe
 * @version 2020年2月9日 下午3:33:03
 */

public class JavaDemo13 {

	public static void main(String[] args) {
		List<Person> all = new ArrayList<Person>();
		all.add(new Person("张三", 12));
		all.add(new Person("李四", 19));
		all.add(new Person("王五", 15));
		all.add(null);
		System.out.println(all.contains(new Person("张三", 12)));//此时对象必须要实现equals()方法
		all.remove(new Person("张三", 12));
		System.out.println(all);
		
		Iterator< Person> iter=all.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
