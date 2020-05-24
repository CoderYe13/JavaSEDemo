package cn.henuer.javase_base;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @author CoderYe
 * @version 2020年2月15日 上午11:13:06
 */

//自定义ClassLoader
class MyClassLoader extends ClassLoader{
	private final String MSG_CLASS_PATH = "D:"+File.separator+"BigDecimalUtil.class";

	public Class<?> loadData(String className) {
		byte [] data=this.loadClassData();
		if(data!=null) {
			return super.defineClass(className, data, 0,data.length);
		}
		return null;
	}

	private byte[] loadClassData() {
		InputStream input = null;
		ByteArrayOutputStream bos = null;// 内存输入流

		byte data[] = null;
		try {
			input = new FileInputStream(new File(MSG_CLASS_PATH));
			bos = new ByteArrayOutputStream();
			int len;
			byte[] temp = new byte[1024];
			while ((len = input.read(temp)) != -1) {
				bos.write(temp,0,len);
			}
			data = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}

public class CustomizeClassLoader {
	public static void main(String[] args) throws Exception {
		MyClassLoader classLoader=new MyClassLoader();
		Class<?> cls=classLoader.loadClass("cn.henuer.javase_base.BigDecimalUtil");
		
		Method method = cls.getMethod("add", double.class, double.class);
		System.out.println(method.invoke(BigDecimalUtil.class, 100.11, 100.22));
	}
}
