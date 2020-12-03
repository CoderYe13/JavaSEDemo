package cn.henuer.threadpool;

import cn.henuer.concurrency.example.singleton.*;

import java.util.concurrent.*;

public class ThreadPoolTest {
    //    ExecutorService executorService= Executors.newFixedThreadPool(10);
//    ExecutorService executorService1=Executors.newSingleThreadExecutor();
//    ExecutorService executorService2=Executors.newCachedThreadPool();

    static ExecutorService service = new ThreadPoolExecutor(2,
            5,
            1L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {

        try {
            for ( int i = 0; i < 10; i++) {
//                service.execute(() -> {
//                    System.out.println(Thread.currentThread().getName() + "  办理业务");
//                    System.out.println(SingletonExcemple7.getInstance().toString());
//                });
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "  办理业务");
                    System.out.println(SingletonExcemple7.getInstance().toString());
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
