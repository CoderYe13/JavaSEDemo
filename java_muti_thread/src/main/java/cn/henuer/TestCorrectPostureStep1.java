package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TestCorrectPostureStep1 {
    static final Object room = new Object();
    static boolean hasCigarette = false;//有没有烟
    static boolean hasTakeout = false;

    public static void main(String[] args) {
        TestCorrectPostureStep1 test = new TestCorrectPostureStep1();

    }

    /**
     * 其它干活的线程，都要一直阻塞，效率太低
     * 小南线程必须睡足 2s 后才能醒来，就算烟提前送到，也无法立刻醒来
     * 加了 synchronized (room) 后，就好比小南在里面反锁了门睡觉，烟根本没法送进门，main 没加
     * synchronized 就好像 main 线程是翻窗户进来的
     * 解决方法，使用 wait - notify 机制
     */
    public void test() {
        new Thread(() -> {
            synchronized (room) {
                log.debug("有烟没？[{}]", hasCigarette);
                if (!hasCigarette) {
                    log.debug("没烟，先歇会！");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("有烟没？[{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("可以开始干活了");
                }
            }
        }, "小南").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (room) {
                    log.debug("可以开始干活了");
                }
            }, "其它人").start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
       // 这里能不能加 synchronized (room)？
            hasCigarette = true;
            log.debug("烟到了噢！");
        }, "送烟的").start();
    }
}
