package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.test")
public class ThreadDemo {
    public static void main(String[] args) {
       ThreadDemo thd=new ThreadDemo();
       //thd.thread();
       // thd.runnable();
        thd.runnableFuture();
    }
    //使用Thread创建线程
    public  void thread(){
        Thread t=new Thread(){
            @Override
            public void run() {
                log.debug("running");
            }
        };
        t.setName("Thread");
        t.start();
        log.debug("running");
    }
    //Runnable接口
    public void runnable(){
        Runnable r=new Runnable() {
            @Override
            public void run() {
                log.debug("running");
            }
        };
        Thread t=new Thread(r,"Runnable");
        t.start();
    }

    public void runnableFuture(){

        Callable callable=new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("running");
                return "hello";
            }
        };
        FutureTask<String> task=new FutureTask<String>(callable);
        Thread t=new Thread(task,"FutureTask");
        t.start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
