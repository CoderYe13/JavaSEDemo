package cn.henuer.javase_base;

import cn.henuer.javase_base.util.ValidIpAddress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
*@author CoderYe
*@version 2020年2月4日 下午4:47:55
*/

//正则表达式
public class JavaDemo6 {

	public static void main(String[] args) {
		String str="hcdsciswab49$%&%dcnei877R%T%R$5R%&9bY";
		String regex="[^a-zA-Z0-9]+";
		System.out.println(str.replaceAll(regex, ""));
		
		System.out.println(validNum("100.11"));
		
		System.out.println(new ValidIpAddress("256.158.125.1").isIpAddress());
		
		System.out.println(validEmail("_yey0909@163.com"));
		
		
		validContent("insert into user(name,age) values(#{name},#{age})");
	}
	//校验数字是不是小数
	public static boolean validNum(String str) {
		String regex="\\d+(\\.\\d+)?";
		if(str.matches(regex)) {
			return true;
		}
		return false;
	}
	//校验邮箱
	public static boolean validEmail(String emailAddr) {
		String regex="[a-zA-Z0-9]\\w+@\\w+\\.(cn|com|net|gov)";
		if(emailAddr.matches(regex)) {
			return true;
		}
		return false;
	}
	//取出#{内容}中的内容
	public static void validContent(String str) {
		String regex="#\\{\\w+\\}";
		Pattern pat=Pattern.compile(regex);
		Matcher mat=pat.matcher(str);
		while(mat.find()) {
			System.out.println(mat.group(0).replaceAll("#|\\{|\\}", ""));
		}
	}
}
