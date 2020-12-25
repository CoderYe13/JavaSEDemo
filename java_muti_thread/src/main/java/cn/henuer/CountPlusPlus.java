package cn.henuer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountPlusPlus {
    static int counter = 0;
    Object object=new Object();
    Object object1=new Object();
    public static void main(String[] args) throws InterruptedException {
       CountPlusPlus countPlusPlus=new CountPlusPlus();
       countPlusPlus.sync3();
    }

    /**
     * counter++不具备原子性，线程不安全
     * @throws InterruptedException
     */
    public void non_sync() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter++;
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter--;
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("{}",counter);
    }

    /**
     * synchronized 实际是用对象锁保证了临界区内代码的原子性，
     * 临界区内的代码对外是不可分割的，不会被线程切换所打断。
     * @throws InterruptedException
     */
    public void sync() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (object){
                    counter++;
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
              synchronized (object){
                  counter--;
              }

            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("{}",counter);
    }

    /**
     * 把  synchronized(obj) 放在 for 循环的外面,仍然保证counter++具有原子性线程安全
     * @throws InterruptedException
     */
    public void sync1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (this){
            for (int i = 0; i < 5000; i++) {
                    counter++;
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (this){
            for (int i = 0; i < 5000; i++) {

                    counter--;
                }

            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("{}",counter);
    }

    /**
     * t1  synchronized(obj1) 而 t2  synchronized(obj2) 会怎样运作 ，无法保证代码原子性，线程不安全
     * @throws InterruptedException
     */
    public void sync2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (object){
                for (int i = 0; i < 5000; i++) {
                    counter++;
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (object1){
                for (int i = 0; i < 5000; i++) {

                    counter--;
                }

            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("{}",counter);
    }

    /**
     * 线程t1获得了锁，线程t2没有获得锁，此时无法保证临界区counter++的原子性
     * @throws InterruptedException
     */
    public void sync3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (object){
                for (int i = 0; i < 5000; i++) {
                    counter++;
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
                for (int i = 0; i < 5000; i++) {
                    counter--;
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("{}",counter);
    }
}
