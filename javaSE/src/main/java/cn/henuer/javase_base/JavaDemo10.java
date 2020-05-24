package cn.henuer.javase_base;

import java.io.File;

/**
*@author CoderYe
*@version 2020年2月6日 下午2:41:19
*/

//文件File
//给一个路径进行文件的名称或路径的批量修改操作
public class JavaDemo10 {
	
	public static void main(String[] args) {
		File file=new File("D:"+File.separator);
		listDir(file);
	}
	//设置一个路径，而后将这个路径下的所有的文件列出，包括子目录下的文件
	public static void listDir(File file) {
		if(file.isDirectory()) {
			File results[]=file.listFiles();
			if(results!=null) {
				for(int x=0;x<results.length;x++) {
					listDir(results[x]);
				}
			}
		}
		System.out.println(file.getAbsolutePath());
	}
	//将一个目录下的文件全部修改成txt文件
	public static void renameDir(File file) {
		if(file.isDirectory()) {
			File results[]=file.listFiles();
			if(results!=null) {
				for(int x=0;x<results.length;x++) {
					renameDir(results[x]);
				}
			}
		}else {
			if(file.isFile()) {
				String fileName=null;
				if(file.getName().contains(".")) {//如果路径中包含“.”
					fileName=file.getName().substring(0,file.getName().lastIndexOf("."));
				}else {
					fileName=file.getAbsolutePath()+".txt";
				}
				
				File newFile=new File(file.getParentFile(),fileName);//新文件命名
				file.renameTo(newFile);//重命名
			}
		}
	}
	
	
	
}
