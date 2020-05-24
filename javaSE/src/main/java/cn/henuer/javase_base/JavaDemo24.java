package cn.henuer.javase_base;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author CoderYe
 * @version 2020年3月23日 下午6:32:03
 */
public class JavaDemo24 {

	public static void main(String[] args) {
		{
			List<String> lists = new ArrayList<String>();
			lists.add("123");
			lists.add("456");
			lists.add("789");
			Iterator<String> it = lists.iterator();
			while (it.hasNext()) {
				String s = it.next();
				if (s.equals("123")) {
					it.remove();
				}
			}
			System.out.println(lists.toString());
		}
		{
			Map<String, String> maps = new LinkedHashMap<>();
			maps.put("one", "1");
			maps.put("two", "2");
			maps.put("there", "3");

			Iterator<Map.Entry<String, String>> it = maps.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> s = it.next();
				if (s.getKey().equals("one")) {
					it.remove();
				}
			}
			System.out.println(maps);
		}

		String str = Base64.getEncoder().encodeToString("www.henu.cn".getBytes());
		System.out.println(str);

		
		System.out.println(Integer.toHexString(1000));
	}

}
