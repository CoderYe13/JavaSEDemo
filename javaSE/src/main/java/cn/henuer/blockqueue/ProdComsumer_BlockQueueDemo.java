package cn.henuer.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 消费者生产者，阻塞队列模式
 */
class MySources{
    private volatile boolean FLAG=true;//默认开启，进行生产消费
    private AtomicInteger atomicInteger=new AtomicInteger();
    BlockingQueue<String> blockingQueue=null;
    public MySources(BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    //生产者
    public void myProd() throws InterruptedException {
        String data=null;
        boolean retValue;
        while (FLAG){
            data=atomicInteger.incrementAndGet()+"";
            retValue=blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName()+" 插入"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+" 插入队列失败！");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"生产动作结束");
    }
    public void myCosumer() throws InterruptedException {
        String result=null;
        while (FLAG){
            result=blockingQueue.poll(2L,TimeUnit.SECONDS);
            if (null==result||result.equalsIgnoreCase("")){
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"超过两秒，消费失败");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"消费"+result+"成功");
        }
    }

    public void stop(){
        FLAG=false;
    }
}
public class ProdComsumer_BlockQueueDemo {
    public static void main(String[] args) {
        MySources mySources=new MySources(new ArrayBlockingQueue<String>(3));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"生产者启动");
            try{
                mySources.myProd();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"消费者启动");
            try{
                mySources.myCosumer();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Consumer").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mySources.stop();
    }
}
