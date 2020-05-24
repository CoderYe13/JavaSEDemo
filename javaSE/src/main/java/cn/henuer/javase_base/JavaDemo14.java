package cn.henuer.javase_base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author CoderYe
 * @version 2020年2月10日 上午11:06:57
 */

//将Set集合输出的常用方法
public class JavaDemo14 {

	public static void main(String[] args) {
		Set<String> set = new TreeSet<>();
		set.add("hello");
		set.add("world");
		// 使用将其转换为list
		List<String> list = new ArrayList<String>(set);
		for (int i = 0; i < set.size(); i++) {
			System.out.println(list.get(i));
		}
		// 使用Iterator
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		// 使用foreach
		for (String str : set) {
			System.out.println(str);
		}
	}

}
