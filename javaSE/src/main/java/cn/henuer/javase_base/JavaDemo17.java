package cn.henuer.javase_base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
*@author CoderYe
*@version 2020年2月10日 下午8:08:30
*/
public class JavaDemo17 {

	public static void main(String[] args) {
		List<String> all=new ArrayList<>();
		Collections.addAll(all, "hello","world","nihao");
		Collections.sort(all);
		System.out.println(all);
		System.out.println(Collections.binarySearch(all, "hello"));
		Collections.reverse(all);
		System.out.println(all);
	}

}
