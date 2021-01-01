package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.locks.LockSupport;

/**
 * 线程顺序打印字符
 */
@Slf4j
public class PrintNumSerial {

    static final Object lock = new Object();
    static boolean t2runned = false;

    public static void main(String[] args) {
       PrintNumSerial print=new PrintNumSerial();
       print.test3();
    }

    /**
     * 使用 wait()/notify()
     */
    public void test1(){
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (!t2runned) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                log.debug("2");
                t2runned = true;
                lock.notify();
            }

        }, "t2");

        t1.start();
        t2.start();
    }

    /**
     * park()/unpark()
     */
    public void test2(){
        Thread t1=new Thread(()->{
            LockSupport.park();
            log.debug("1");
        },"t1");
        Thread t2=new Thread(()->{
            log.debug("2");
            LockSupport.unpark(t1);
        },"t2");

        t1.start();
        t2.start();
    }

    /**
     * 三个线程分别打印a b c，循环5次
     */
    public void test3(){
        WaitNotify waitNotify=new WaitNotify(1,5);
        new Thread(()->{
            waitNotify.print("a",1,2);
        }).start();
        new Thread(()->{
            waitNotify.print("b",2,3);
        }).start();
        new Thread(()->{
            waitNotify.print("c",3,1);
        }).start();
    }
}
class WaitNotify{
    //打印
    public void print(String str,int waitFlag,int nextFlag){
        for (int i=0;i<loopNumber;i++){
            synchronized (this){
                while (flag!=waitFlag){
                    try{
                        this.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag=nextFlag;
                this.notifyAll();
            }
        }
    }
    //等待标记
    private int flag;

    //循环次数
    private int loopNumber;

    public WaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }
}