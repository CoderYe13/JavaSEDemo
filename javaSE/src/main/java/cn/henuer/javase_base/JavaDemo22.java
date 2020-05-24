package cn.henuer.javase_base;

import java.util.HashMap;
import java.util.Map;

/**
*@author CoderYe
*@version 2020年2月26日 下午5:53:21
*/
public class JavaDemo22 {

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		System.out.println(map.put("one","one"));
		//Map的put()第二次覆盖某个key时会返回上一个key的value值
		System.out.println(map.put("one","two"));
	}

}
