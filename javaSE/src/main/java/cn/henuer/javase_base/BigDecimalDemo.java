package cn.henuer.javase_base;

import java.math.BigDecimal;

/**
*@author CoderYe
*@version 2020年1月30日 下午4:09:46
*/

class BigDecimalUtil{
	private BigDecimalUtil() {}
	
	public static BigDecimal add(double v1,double v2) {
		BigDecimal b1=new BigDecimal(Double.toString(v1));
		BigDecimal b2=new BigDecimal(Double.toString(v2));
		
		return b1.add(b2);
	}
	public static BigDecimal add(String v1,String v2) {
		BigDecimal b1=new BigDecimal(v1);
		BigDecimal b2=new BigDecimal(v2);
		
		return b1.add(b2);
	}
}
public class BigDecimalDemo {

	public static void main(String[] args) {
		System.out.println(BigDecimalUtil.add(1.112345,2.555555));
		System.out.println(1.1123+2.555555+'\n');
		System.out.println(BigDecimalUtil.add("1.112345","2.555555"));
	}

}
