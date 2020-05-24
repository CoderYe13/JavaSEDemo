package cn.henuer.javase_base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author CoderYe
 * @version 2020年2月8日 下午2:58:00
 */

//内存流
//实现子类ByteArrayInputStream、ByteArrayOutputStream和ByteArrayReader、ByteArraywriter
public class JavaDemo12 {

	public static void main(String[] args) throws Exception {
		String str = "www.henu.cn";
		InputStream input = new ByteArrayInputStream(str.getBytes());
		// OutputStream output=new ByteArrayOutputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int data = 0;
		while ((data = input.read()) != -1) {
			output.write(Character.toUpperCase(data));
		
			System.out.println(new String(output.toByteArray()));
		}
		input.close();
		output.close();
	}

}
