package cn.henuer.heap;

import java.io.IOException;

/**
 * 1、设置堆空间大小的参数值
 *     -Xms 用来设置堆空间（年轻代+老年代）的起始大小
 *
 *     -Xmx 用来设置堆空间（年轻代+老年代）的最大内存大小
 * 2、默认堆空间的大小
 *    初始堆大小，物理内存的1/64
 *    最大内存大小，物理内存的1/4
 * 3、手动设置 -Xms20M -Xmx20M
 *     开发过程中一般设置相同的值
 * 4、查看设置的参数值
 *    方式一： jps  jstat -gc 进程id
 *    方式二： +XX:+PrintGCDetails
 */
public class HeapSpaceInitial {
    public static void main(String[] args) throws IOException {
        //返回java虚拟机中的堆内存总量
        long initialMemory=Runtime.getRuntime().totalMemory()/1024/1024;
        //返回java虚拟机试图使用的最大对内存量
        long maxMemory=Runtime.getRuntime().maxMemory()/1024/1024;

        System.out.println("-Xms:"+initialMemory+"M");

        System.out.println("-Xmx"+maxMemory+"M");

        System.out.println("系统内存大小"+initialMemory*64/1024+"G");
        System.out.println("系统内存大小为"+maxMemory*4/1024+"G");
//        System.in.read();
    }
}
