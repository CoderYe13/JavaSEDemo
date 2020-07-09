package cn.henuer.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TakeNUM {
    static ExecutorService service = new ThreadPoolExecutor(4,
            6,
            1L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    private static volatile AtomicInteger countNum=new AtomicInteger(1);
    public static int task(){
        return countNum.getAndIncrement();
    }
    public static void main(String[] args) {
        try {
            for (int i = 0; i <1000; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"   "+task()+"： 号客户正在办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
    }
}
