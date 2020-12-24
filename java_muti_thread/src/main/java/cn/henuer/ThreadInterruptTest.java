package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j
public class ThreadInterruptTest {

    public static void main(String[] args) {
        ThreadInterruptTest test = new ThreadInterruptTest();
        test.test4();
    }

    /**
     * 打断 sleep，wait，join 的线程
     * 这几个方法都会让线程进入阻塞状态
     * 打断 sleep 的线程, 会清空打断状态，以 sleep 为例
     */
    public void test1() {
        Thread t1 = new Thread(() -> {
            log.debug("sleep....");
            try {
                TimeUnit.SECONDS.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("线程中断：{}", Thread.currentThread().isInterrupted());
            }
        }, "t1");
        t1.start();
        log.debug("interrupt");
        t1.interrupt();
    }

    /**
     * 打断正常运行的线程, 不会清空打断状态
     */
    public void test2() {
        Thread t1 = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                boolean interrupt = current.isInterrupted();
                if (interrupt) {
                    log.debug("线程中断：{}", current.isInterrupted());
                    break;
                }
            }
        }, "t1");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打断 park 线程, 不会清空打断状态 Thread.currentThread().isInterrupted()==true
     */
    public void test3(){
        Thread t1=new Thread(()->{
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark....");
            log.debug("打断状态：{}",Thread.currentThread().isInterrupted());
        },"t1");

        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 如果打断标记已经是 true, 则 park 会失效
     *
     * 可以使用  Thread.interrupted() 清除打断状态
     */
    public void test4(){
        Thread t1=new Thread(()->{
            for (int i=0;i<5;i++){
                log.debug("park...");
                LockSupport.park();
                //log.debug("打断状态：{}",Thread.currentThread().isInterrupted());
            }
        },"t1");

        t1.start();
        t1.interrupt();
    }
}
