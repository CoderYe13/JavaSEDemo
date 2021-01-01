package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TestDeadlock {
    static Object A=new Object();
   static Object B=new Object();
    public static void main(String[] args) {
      Thread t1=  new Thread(()->{
            synchronized (A){
                log.debug("lock A");
                log.debug("操作...");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    log.debug("lock B");
                    log.debug("操作...");
                }
            }
        },"t1");

       Thread t2= new Thread(()->{
            synchronized (B){
                log.debug("lock B");
                log.debug("操作...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A){
                    log.debug("lock A");
                    log.debug("操作...");
                }
            }
        },"t1");

       t1.start();
       t2.start();
    }
}
