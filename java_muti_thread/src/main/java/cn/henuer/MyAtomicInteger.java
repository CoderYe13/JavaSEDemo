package cn.henuer;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public class MyAtomicInteger implements Account {
    private volatile int value;
    private static final long valueOffset;
    private static final Unsafe UNSAFE;

    static {
        try {
            UNSAFE = UnsafeAccessor.getUnsafe();
            // data 属性在 MyAtomicInteger 对象中的偏移量，用于 Unsafe通过offset定位到属性，直接访问该属性
            valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public MyAtomicInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void decrement(int amount) {
        while (true) {
            //获取旧值
            int prev = this.value;
            //需要被修改的新值
            int next = prev - amount;
            if (UNSAFE.compareAndSwapInt(this, valueOffset, prev, next)) {
                break;
            }
        }
    }

    @Override
    public Integer getBalance() {
        return getValue();
    }

    @Override
    public void withdraw(Integer amount) {
        decrement(amount);
    }


    public static void main(String[] args) throws InterruptedException {
        Account.demo(new MyAtomicInteger(10000));
//        TimeUnit.SECONDS.sleep(1000000);
    }
}

class UnsafeAccessor {
    /**
     * Unsafe类是通过Bootstrap类加载器得到的，普通方法得不到，只有通过Unsafe的一个属性然后利用反射得到对象实例
     */
    private static final Unsafe unsafe;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);//设置私有属性可见
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }
    }

    public static Unsafe getUnsafe() {
        return unsafe;
    }
}