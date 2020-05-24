package cn.henuer.ConcurrentModificationException;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *  多线程条件下HashSet，会出现下面异常
 *  Set<String> set=new HashSet<String>();
 * java.util.ConcurrentModificationException
 *
 * 解决方案：
 *
 * 1、使用Collections.synchronizedSet(new HashSet<String>());
 * 2、使用new CopyOnWriteArraySet<>(); 底层使用 new CopyOnWriteArrayList<E>();
 */
public class SetConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        Set<String> set = //Collections.synchronizedSet(new HashSet<String>());
                //new HashSet<String>();
        new CopyOnWriteArraySet<>();

        for (int i = 0; i <50 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            }).start();
        }
    }
}
