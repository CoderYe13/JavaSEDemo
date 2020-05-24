package cn.henuer;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        int h = UUID.randomUUID().hashCode();
        System.out.println(Integer.toBinaryString(h));
        System.out.println(Integer.toBinaryString(h >>> 16));
        System.out.println(Integer.toBinaryString(h ^ (h >>> 16)));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(15&(h ^ (h >>> 16)));

        LinkedList linkedList=new LinkedList();
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList.toString());

        LinkedHashMap map=new LinkedHashMap();
    }
}