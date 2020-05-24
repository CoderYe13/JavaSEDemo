package cn.henuer.javase_base;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * @author CoderYe
 * @version 2020年3月27日 下午9:58:36
 */
class Task {
	public static void task(int i) {
		System.out.println(Thread.currentThread().getName() + "  ," + i + "正在运行");
	}
}

public class JavaDemo26 {
 volatile static int count=0;
	public static void main(String[] args) throws InterruptedException{
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 10L, TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>(1000), new ThreadPoolExecutor.AbortPolicy());
		
		  final Semaphore semaphore=new Semaphore(3);
		  long start=System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			int j = i;
			executor.execute(() -> {
				try {
					semaphore.acquire(1);
					//Task.task(j);
					task(j);
					semaphore.release(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		
		executor.shutdown();
		System.out.println((System.currentTimeMillis()-start));
		System.out.println(count);
	}
	public static void task(int i) {
		count=count+1;
		//System.out.println(Thread.currentThread().getName() + "  ," + i + "正在运行" +count);
	}
}
