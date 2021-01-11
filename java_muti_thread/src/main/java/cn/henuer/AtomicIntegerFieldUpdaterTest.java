package cn.henuer;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
    private volatile  int field;

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater fieldUpdater
                =AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterTest.class,"field");
        AtomicIntegerFieldUpdaterTest test=new AtomicIntegerFieldUpdaterTest();
        fieldUpdater.compareAndSet(test,0,10);

        // 修改成功 field = 10
        System.out.println(test.field);
        // 修改成功 field = 20
        fieldUpdater.compareAndSet(test,10,20);
        System.out.println(test.field);
        // 修改失败 field = 20
        fieldUpdater.compareAndSet(test,10,30);
        System.out.println(test.field);
    }
}
