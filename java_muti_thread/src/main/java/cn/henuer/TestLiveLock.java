package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 多线程活锁
 * 线程持有对方的结束条件不停的改变，导致一直运行结束不了
 */
@Slf4j
public class TestLiveLock {
    static volatile int count=10;
    static final Object lock=new Object();
    public static void main(String[] args) {
        new Thread(()->{
            while (count>0){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    count--;
                    log.debug("count:{}",count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
        new Thread(()->{
            while (count<20){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    count++;
                    log.debug("count:{}",count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }
}
