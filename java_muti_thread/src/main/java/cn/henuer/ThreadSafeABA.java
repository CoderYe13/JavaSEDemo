package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

@Slf4j
public class ThreadSafeABA {
    //static AtomicReference<String> ref=new AtomicReference<>("A");

    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);
    public static void main(String[] args) {
        log.debug("main start ....");
        //获取值A
        //这个共享变量被其他线程修改过
//        String prev =ref.get();
        String prev =ref.getReference();
        // 获取版本号
        int stamp = ref.getStamp();
        log.debug("版本 {}", stamp);
        other();
        try {
            TimeUnit.SECONDS.sleep(2);
            log.debug("change A->C {}", ref.compareAndSet(prev, "C",stamp,stamp+1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    private static void otherABA() {
//        new Thread(()->{
//            log.debug("change A->B {}", ref.compareAndSet(ref.get(), "B"));
//        },"t1").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(()->{
//            log.debug("change B->A {}", ref.compareAndSet(ref.get(), "A"));
//        },"t2").start();
//    }

    private static void other() {
        new Thread(()->{
            log.debug("change A->B {}", ref.compareAndSet(ref.getReference(), "B",ref.getStamp(),ref.getStamp()+1));
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            log.debug("change B->A {}", ref.compareAndSet(ref.getReference(), "A",ref.getStamp(),ref.getStamp()+1));
        },"t2").start();
    }
}
