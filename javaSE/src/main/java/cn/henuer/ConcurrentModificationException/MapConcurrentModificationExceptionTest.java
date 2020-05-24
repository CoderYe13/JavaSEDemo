package cn.henuer.ConcurrentModificationException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/**
 *  多线程条件下new HashMap();，会出现下面异常
 *  Map<String, String> map =new HashMap();
 * java.util.ConcurrentModificationException
 *
 * 解决方案：
 *
 * 1、使用new ConcurrentHashMap<>();
 */
public class MapConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        Map<String, String> map = //new HashMap();
                new ConcurrentHashMap<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                String str = UUID.randomUUID().toString().replace("-", "");
                map.put(str.substring(0, 5), str.substring(6, 10));
                System.out.println(map);
            }).start();
        }
    }
}
