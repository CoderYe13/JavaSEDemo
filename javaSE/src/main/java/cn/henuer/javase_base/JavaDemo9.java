package cn.henuer.javase_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
*@author CoderYe
*@version 2020年2月6日 下午1:31:09
*/
//对象的序列化与反序列化使用ObjectInputStream和ObjectOutputStream
//java中的对象序列化和反序列化必须使用java提供的io流，因为可能涉及到对象自定义操作；如果想实现一组对象的序列化，可以使用对象数组来完成
public class JavaDemo9 {
	
	private static final File SAVE_FILE=new File("D:"+File.separator+"henu.person");
	
	public static void main(String[] args) throws Exception {
			//saveObject(new Person("小美", 25));
			System.out.println(loadObject());
	}
	
	public static void saveObject(Object obj) throws Exception {
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
		oos.writeObject(obj);//序列化
		oos.close();
	}
	
	public static Object loadObject() throws Exception {
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(SAVE_FILE));
		Object obj=ois.readObject();//反序列化
		ois.close();
		return obj;
	}

}
