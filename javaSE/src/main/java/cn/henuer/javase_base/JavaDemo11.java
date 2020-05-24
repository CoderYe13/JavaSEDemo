package cn.henuer.javase_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.UUID;

/**
 * @author CoderYe
 * @version 2020年2月6日 下午4:33:27
 */

//InputStream和OutputStream、Reader和Writer

//字节流在操作过程中没有使用到缓冲区，字符流使用到了缓冲区，字符流更适合处理中文
public class JavaDemo11{

	public static void main(String[] args) throws Exception {
		File file = new File("D:" + File.separator + "hello" + File.separator + "he.txt");
		if (!file.getParentFile().exists()) {
			System.out.println(file.getParent() + "  " + file.getParentFile());
			file.getAbsoluteFile().mkdirs();
		}
		//copyImg(file);

		// readerAndWriter(new File("D:" + File.separator + "hello" + File.separator +
		// "he.txt"));
		
		//new FileUtil("D:\\hello\\U105P28T3D2048907F326DT20080604225106.jpg","D:\\hello\\hello.png").copy();
		//new FileUtil("D:\\baidu","D:\\hello").copyDir();
		
		inputAndOutput(file);
	}

	// 字节流
	public static void inputAndOutput(File file) throws Exception {
		OutputStream output = new FileOutputStream(file, true);
		String str = "hello world";
		output.write(str.getBytes());
		output.close();
		InputStream input = new FileInputStream(file);
		byte[] data = new byte[1024];
		int len = input.read(data);
		input.close();
		System.out.println("[" + new String(data, 0, len, "UTF-8") + "]");
	}

	// 拷贝图片
	public static void copyImg(File file) throws Exception {
		InputStream input = new FileInputStream(file);
		OutputStream output = new FileOutputStream(
				file.getParent() + File.separator + UUID.randomUUID().toString() + ".jpg", true);
		System.out.println(file.getParent());
		byte[] data = new byte[1024];
		int len = 0;
		while ((len = input.read(data)) != -1) {
			output.write(data, 0, len);
		}
		input.close();
		output.close();
	}

	// 字符流
	public static void readerAndWriter(File file) throws Exception {
		Writer writer = new FileWriter(file, true);
		writer.write("中国人");
		Reader reader = new FileReader(file);
		char[] data = new char[2];
		int len = 0;
		while ((len = reader.read(data))!= -1) {
			System.out.print(new String(data, 0, len));
		}
		// writer.close();//字符流如果不关闭会造成数据无法写入，与字节流的区别
		writer.flush();// 使用flush()方法强制刷新缓冲区中的字符流，此时可以实现数据保存
		reader.close();
	}

	// 字节流和字符流转换，转换流
}

class FileUtil {
	private File srcFile;
	private File desFile;

	public FileUtil(File srcFile, File desFile) {
		this.srcFile = srcFile;
		this.desFile = desFile;
	}

	public FileUtil(String src, String des) {
		this(new File(src), new File(des));
	}
	//拷贝文件
	public boolean copy() throws Exception {
		if (!this.srcFile.exists()) {// 源文件必须存在
			return false;
		}
		if (this.desFile.getParentFile().exists()) {
			desFile.getParentFile().mkdirs();
		}
		byte data[] = new byte[1024];
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(this.srcFile);
			output = new FileOutputStream(this.desFile);
			int len = 0;
			//1、读取数据到数组之中，随后返回读取的个数len = input.read(data);
			//2、判断个数是否是-1，如果不是则写入数据
			while ((len = input.read(data))!= -1) {
				// len = input.read(data);
				output.write(data,0,len);// 可能会出现字节不足情况，按照读取多少写入多少来做
			}
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}
	}// copy
	
	//拷贝文件夹
	public boolean copyDir()throws Exception {
		try {
			this.copyImpl(this.srcFile);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	private void copyImpl(File file) throws Exception{
		if(file.isDirectory()) {//是目录
			File results[]=file.listFiles();
			if(results!=null) {
				for(int x=0;x<results.length;x++) {
					copyImpl(results[x]);
				}
			}
		}else {//是文件
			String newFilePath=file.getPath().replace(this.srcFile.getPath()+File.separator,"");
			File newFile=new File(this.desFile,newFilePath);//拷贝的目标路径,把父路径和子路径组合创建新的文件实例
			this.copyFileImpl(file, newFile);
		}
	}//copyImpl(File file)
	private boolean copyFileImpl(File srcFile,File desFile) throws Exception{
		if(!desFile.getParentFile().exists()) {
			desFile.getParentFile().mkdirs();
		}
		byte data[] = new byte[1024];
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(srcFile);
			output = new FileOutputStream(desFile);
			int len = 0;
			//1、读取数据到数组之中，随后返回读取的个数len = input.read(data);
			//2、判断个数是否是-1，如果不是则写入数据
			while ((len = input.read(data))!= -1) {
				output.write(data,0,len);// 可能会出现字节不足情况，按照读取多少写入多少来做
			}
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}
	}
	
	
}
