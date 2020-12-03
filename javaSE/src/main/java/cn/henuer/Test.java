package cn.henuer;


import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
//   private static ThreadLocal<String> tl=new ThreadLocal<String>();
    public static void main(String[] args) {
//        int h = UUID.randomUUID().hashCode();
//        System.out.println(Integer.toBinaryString(h));
//        System.out.println(Integer.toBinaryString(h >>> 16));
//        System.out.println(Integer.toBinaryString(h ^ (h >>> 16)));
//        System.out.println(Integer.toBinaryString(15));
//        System.out.println(15&(h ^ (h >>> 16)));
//
//        LinkedList linkedList=new LinkedList();
//        linkedList.add(5);
//        linkedList.add(2);
//        linkedList.add(3);
//        System.out.println(linkedList.toString());

//        tl.set("hello");
//
//        System.out.println(tl.get());
//
//        System.out.println(tl.get());
//        int count=0;
//        for (int i = 0; i <10 ; i++) {
//            count=count++;
//            System.out.println(count);
//        }
//        System.out.println("count="+count);



        ConcurrentHashMap<String,String> concurrentHashMap=new ConcurrentHashMap<>();
        concurrentHashMap.putIfAbsent("one","one");
        concurrentHashMap.putIfAbsent("one","toq");
        System.out.println(concurrentHashMap.get("one"));
    }
}