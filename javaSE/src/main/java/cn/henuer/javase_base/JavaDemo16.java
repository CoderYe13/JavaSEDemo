package cn.henuer.javase_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
*@author CoderYe
*@version 2020年2月10日 下午4:59:24
*/

//Properties一般只用于读取配置文件
public class JavaDemo16 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop=new Properties();
//		prop.setProperty("beijing","北京");
//		prop.setProperty("shanghai", "上海");
//		try {
//			prop.store(new FileOutputStream(new File("D:"+File.separator+"hello"+File.separator+"info.properties")), "hello");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
		prop.load(new FileInputStream(new File("D:"+File.separator+"hello"+File.separator+"info.properties")));
	
		System.out.println(prop.getProperty("beijing"));
	}
}
