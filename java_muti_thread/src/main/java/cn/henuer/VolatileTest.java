package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VolatileTest {
    volatile static boolean run = true;

    final static Object lock = new Object();

    static int i=0;

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.test3();

    }

    /**
     * static boolean run=true;
     * final static Object lock=new Object();
     *
     * @throws InterruptedException
     */
    public void test() throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                if (!run) {
                    break;
                }
                log.debug("{} 运行", Thread.currentThread().getName());
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        log.debug("{} 停止", Thread.currentThread().getName());
        run = false;
    }

    /**
     * static boolean run=true;
     * final static Object lock=new Object();
     *
     * @throws InterruptedException
     */
    public void test1() throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                /**使用共享变量时，会直接从主存中获取值
                 *  monitorenter
                 *  getstatic #16 <cn/henuer/VolatileTest.run>
                 *  ifne 17 (+8)
                 *  aload_0
                 *  monitorexit
                 */
                synchronized (lock) {
                    if (!run) {
                        break;
                    }
                    log.debug("{} 运行", Thread.currentThread().getName());
                }
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);

        /**
         * 这里不加volatile也可以保证可见性，原因：
         * synchronized在这里会修改run的值并将run的值刷新到主存
         *     monitorenter
         *     iconst_0
         *     putstatic #16 <cn/henuer/VolatileTest.run>
         *     aload_2
         *    monitorexit
         */
        synchronized (lock) {
            run = false;
        }
        log.debug("{} 停止", Thread.currentThread().getName());
    }

    /**
     * volatile static boolean run = true;
     * final static Object lock = new Object();
     *
     * @throws InterruptedException
     */
    public void test2() throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (!run) {
                        break;
                    }
                    log.debug("{} 运行", Thread.currentThread().getName());
                }
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        log.debug("{} 停止", Thread.currentThread().getName());
        run = false;
    }

    public void test3() throws InterruptedException {
        Thread t1=new Thread(()->{
            for (int j = 0; j <5000 ; j++) {
                i++;
            }

        },"t1");
        Thread t2=new Thread(()->{
            for (int j = 0; j <5000 ; j++) {
                i--;
            }

        },"t2");

        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(2);//没有这句话会直接输出0，很难发现
        System.out.println(i);
    }
}
