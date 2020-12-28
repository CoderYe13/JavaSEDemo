package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExerciseSell {
    public static void main(String[] args) {
        //模拟多人买票
        //共享变量多线程操作存在线程安全
        TicketWindow window = new TicketWindow(5000);
        //卖出的票数统计
        List<Integer> amountList = new Vector<>();
        //所有线程的集合
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Thread thread = new Thread(() -> {
                int count;
                //买票
                synchronized (ExerciseSell.class){
                    count = window.sell(randomAmount());
                }
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                amountList.add(count);
            });
            threadList.add(thread);
            thread.start();
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //统计卖出的票数和剩余票数
        log.debug("余票：{}", window.getCount());
        log.debug("卖出的票数：{}", amountList.stream().mapToInt(i -> i).sum());
    }

    static Random random = new Random();

    public static int randomAmount() {
        return random.nextInt(5) + 1;
    }
}

class TicketWindow {
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    //售票
    /**
     * 这里count是this对象中的共享变量，多线程环境下存在线程安全
     * @param amount
     * @return
     */
    public synchronized int sell(int amount) {
        if (this.count >= amount) {
            this.count -= amount;
            return amount;
        } else {
            return 0;
        }
    }
}
