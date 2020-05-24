package cn.henuer.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 传统版的多线程生产者消费者模式，不加synchronized ,使用Lock
 */
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() {
        lock.lock();
        try {//1、判断
            while (number != 0) {//多线程被唤醒时要重新判断条件，防止虚假唤醒
                //等待，不能生产
                condition.await();
            }
            //2、干活
            number++;
            System.out.println(Thread.currentThread().getName() + " " + number);
            //3、唤醒另一个线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {//1、判断
            while (number == 0) {
                //等待，不能消费
                condition.await();
            }
            //2、干活
            number--;
            System.out.println(Thread.currentThread().getName() + " " + number);
            //3、唤醒另一个线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData data=new ShareData();
        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                data.increment();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                data.decrement();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                data.increment();
            }
        },"CC").start();
        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                data.decrement();
            }
        },"DD").start();
    }
}
