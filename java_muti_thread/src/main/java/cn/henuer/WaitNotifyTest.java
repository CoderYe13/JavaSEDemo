package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class WaitNotifyTest {
    final static Object obj = new Object();

    public static void main(String[] args){
    WaitNotifyTest waitNotifyTest=new WaitNotifyTest();
    waitNotifyTest.test();
    }

    /**
     * wait()方法会释放掉对象的锁，进入WaitSet等待区。从而让其他线程就有机会获取到对象的锁，无限制等待，
     * 直到notify()为止
     * wait(n) 有时限的等待，到n毫秒后结束等待
     *
     * wait/notify只能在synchronized (obj)代码块中执行
     * @throws InterruptedException
     */
    public void test() {
        new Thread(()->{
            synchronized (obj){
                log.debug("执行。。。。");
                try {
                    obj.wait();//让线程在object一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码。。。。");
            }
        },"t1").start();

        new Thread(()->{
            synchronized (obj){
                log.debug("执行。。。。");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码。。。。");
            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("唤醒object上的其他线程");
        synchronized (obj){
            obj.notify();//唤醒obj上的一个线程
            //obj.notifyAll();//唤醒所有线程
        }
    }
}
