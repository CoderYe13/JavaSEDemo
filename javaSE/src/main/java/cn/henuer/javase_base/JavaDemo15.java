package cn.henuer.javase_base;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author CoderYe
 * @version 2020年2月10日 下午3:27:54
 */

//Map操作
public class JavaDemo15 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		
		for (String string : map.keySet()) {
			System.out.println(string);
		}

		for (Integer num : map.values()) {
			System.out.println(num);
		}

		Set<Map.Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> iter = set.iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> mn = iter.next();
			System.out.println(mn.getKey() + "-" + mn.getValue());
		}

		for (Entry<String, Integer> entry : set) {
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
		
		//线程不安全，允许为空，输出与插入顺序不一致
		Map<Person, Integer> personMap = new HashMap<Person, Integer>();
		personMap.put(new Person("小钱", 12), 1);
		personMap.put(new Person("小李", 15), 0);
		personMap.put(new Person("小王", 10), null);
		System.out.println("HashMap: "+personMap);
		
		//Hashtable不允许空值，Hashtable是线程安全的
		Map<Person, Integer> personTable = new Hashtable<Person, Integer>();
		personTable.put(new Person("小钱", 12), 1);
		personTable.put(new Person("小李", 15), 0);
		personTable.put(new Person("小王", 10), 1);
		System.out.println("HashTable: "+personTable);
		
		//线程不安全，允许为空，输出与插入顺序一致
		Map<Person, Integer> personLink = new LinkedHashMap<Person, Integer>();
		personLink.put(new Person("小钱", 12), 1);
		personLink.put(new Person("小李", 15), 0);
		personLink.put(new Person("小王", 10), null);
		System.out.println("LinkedHashMap: "+personLink);
	}
}
