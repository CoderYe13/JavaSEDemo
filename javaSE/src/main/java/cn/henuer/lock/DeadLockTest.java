package cn.henuer.lock;

import java.util.concurrent.TimeUnit;

class MyDeadLock implements Runnable{
    private String lockA;
    private String lockB;
    public MyDeadLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"获得"+lockA+"等待"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"获得"+lockB+"等待"+lockA);
            }
        }
    }
}
public class DeadLockTest {
    public static void main(String[] args) {
         String lockA="lockA";
        String lockB="lockB";
        new Thread(new MyDeadLock(lockA,lockB),"AA").start();
        new Thread(new MyDeadLock(lockB,lockA),"BB").start();
    }
}
