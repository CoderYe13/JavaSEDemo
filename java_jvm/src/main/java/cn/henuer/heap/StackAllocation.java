package cn.henuer.heap;

/**
 * 栈上分配测试
 *  -Xmx1G -Xms 1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails  关闭逃逸分析
 */
public class StackAllocation {
    public static void main(String[] args) {
        long start =System.currentTimeMillis();
        for (int i=0;i<10000000;i++){
            alloc();
        }
        //查看执行时间
        long end=System.currentTimeMillis();

        System.out.println("花费时间："+(end-start));
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void alloc(){
        User user=new User();
    }

    static class User{

    }
}
