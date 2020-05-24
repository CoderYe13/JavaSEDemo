package cn.henuer.javase_base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
*@author CoderYe
*@version 2020年2月13日 下午5:29:30
*/
public class SynchronizedExample {
	//修饰整个代码块
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
               System.out.println(j+i);
            }
        }
    }

    //修饰一个方法
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println(j+i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample example1 = new SynchronizedExample();
        SynchronizedExample example2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test2(1);
        });
        executorService.execute(() -> {
            example2.test2(2);
        });
    }
}
