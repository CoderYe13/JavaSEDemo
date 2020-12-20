package cn.henuer.method_area;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Object> threadLocal=new ThreadLocal<>();
        String string="111111111111";
        threadLocal.set(string);
        System.out.println(threadLocal.get());
        System.gc();
        threadLocal.remove();
        System.out.println(threadLocal.get());

        TimeUnit.SECONDS.sleep(1000000);
    }
}