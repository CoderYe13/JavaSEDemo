package cn.henuer.ConcurrentModificationException;

import java.util.*;


/**
 *  多线程条件下ArrayList，会出现下面异常
 *  List<String> list=new ArrayList<>();
 * java.util.ConcurrentModificationException
 *
 * 解决方案：
 * 1、使用 new Vector();使用了synchronized关键字
 * 2、使用Collections.synchronizedList(new ArrayList())
 * 3、使用new CopyOnWriteArrayList<>();  CAS
 */
public class ArrayListConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
                //new Vector();
                //Collections.synchronizedList(new ArrayList());
                //new CopyOnWriteArrayList<>();

        for (int i = 0; i <50 ; i++) {
          new Thread(()->{
              list.add(UUID.randomUUID().toString().substring(0,5));
              System.out.println(list);
          }).start();
        }
    }
}
