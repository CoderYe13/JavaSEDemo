package cn.henuer.javase_base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
*@author CoderYe
*@version 2020年3月23日 下午9:17:57
*/
class MyThread implements Callable<Object>{

	@Override
	public Object call() throws Exception {
		StringBuilder sb=new StringBuilder();
		sb.append("123456");
		return sb;
	}
	
}
public class JavaDemo25 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Object> ft=new FutureTask<Object>(new MyThread());
		new Thread(ft).run();
		System.out.println(ft.get());
	}

}
