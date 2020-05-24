package cn.henuer.javase_base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
*@author CoderYe
*@version 2020年1月30日 下午3:47:34
*/
public class JavaDemo3 {

	public static void main(String[] args) throws ParseException {
	long timeStamp=System.currentTimeMillis();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	System.out.println(sdf.format(timeStamp));
	
	Date date=sdf.parse("2020-01-01 00:00:00");
	System.out.println(date);
	
	}

}
