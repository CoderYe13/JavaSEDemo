package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadNotStop {
    static boolean run=true;
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            while (run){
                log.debug(Thread.currentThread().getName());
            }
        });

        t.start();
        TimeUnit.SECONDS.sleep(1);
        run=false;
    }
}
