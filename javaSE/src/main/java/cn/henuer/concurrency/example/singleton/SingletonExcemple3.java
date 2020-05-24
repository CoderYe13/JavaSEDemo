package cn.henuer.concurrency.example.singleton;

import cn.henuer.annoations.NotRecommend;
import cn.henuer.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * @since 2019/4/16 20:43
 */
@ThreadSafe
@NotRecommend//synchronized带来性能问题
public class SingletonExcemple3 {
    private SingletonExcemple3(){}

    public static SingletonExcemple3 instance=null;

    //静态的工厂方法
    //实现synchronized关键字从而达到线程安全
    public static synchronized SingletonExcemple3 getInstance(){
       if(instance==null){
           instance=new SingletonExcemple3();
       }
       return instance;
    }
}
