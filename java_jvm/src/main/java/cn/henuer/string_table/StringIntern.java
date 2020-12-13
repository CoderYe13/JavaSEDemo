package cn.henuer.string_table;

/**
 * 如何保证变量s指向的是字符串常量池中的数据呢？有两种方式：
 *    方式一： String s = "shkstart";//字面量定义的方式
 *    方式二： 调用intern()
 *            String s = new String("shkstart").intern();
 *            String s = new StringBuilder("shkstart").toString().intern();
 *
 *        String s=new String("hello");这个方法一共生成了两个独立的变量，一个在堆中就是s（运行时生成）,一个在字符串常量池中是"hello"
 *        当调用s.intern()如果常量池存在"hello"，返回值就是在常量池的地址，不存在就会创建，然后返回常量池的地址，这个时候就有两种情况，
 *        第一种s.intern()这个返回值被谁接收的问题如果s=s.intern()  (String s2="hello"  此时s==s2  就是true)那么这个时候s的指向就变了，
 *        变成了常量池的指向，如果没有接收s.intern()那么s.intern()就没有意义，就是一个空值调用，任何一个String变量接受了 s.intern()的返回值，
 *        那么这个变量就指向了字符串常量池中的"hello"这个对象
 *
 *        String s = new StringBuilder("shkstart").toString() 这个方法很奇怪（这个方法只生成了一个对象s在堆中），
 *        这个方法不会在常量池中生成"shkstart"这个字符串常量
 *        那么此时的s  假如有一个 String s3="shkstart";  s==s3  结果就是false，但是如果s=s.intern() 这时候结果就是true
 *        原理是，这个时候s.intern() 并没有在字符串常量中生成"shkstart"对象，而是将s的引用存储在字符串常量池中，这时候字符串常量池中的值就指向了堆中的s
 *        当一个对象访问字符串常量时，就间接的访问到了s,这时候s==s3就是true
 *        从哪里得出这个结论，答案就在字节码中
 *
 *        为什么只生成一个对象呢？
 *        这是因为new StringBuilder("shkstart").toString()  调用了new String(char value[], int offset, int count)
 *        这个构造方法很奇怪，这里是 value 是char数组，不会在字符串常量池中生成对象了，就是一个数据的copy值传递
 */
public class StringIntern {
    public static void main(String[] args) {
        StringIntern stringIntern=new StringIntern();
        stringIntern.test1();
    }

    public void test(){
        String s = new String("1");
        s.intern();//这方法其实没啥屌用，调用此方法之前，字符串常量池中已经存在"1"
        String s2 = "1";
        /**
         *  jdk6：false   jdk7/8：false
         * 因为 s 指向堆空间中的 "1" ，s2 指向字符创常量池中的 "1"
         */
        System.out.println(s == s2);
        // 执行完下一行代码以后，字符串常量池中，是否存在"11"呢？答案：不存在！！
        String s3 = new String("1") + new String("1");  //s3变量记录的地址为：new String("11")
        /**
         *  如何理解：jdk6:创建了一个新的对象"11",也就有新的地址。
         *          jdk7:此时常量中并没有创建"11",而是在常量池中记录了指向堆空间中new String("11")的地址（节省空间）
         */
        //s3.intern(); // 在字符串常量池中生成"11"。
        //String s4 = "11";
        //s4变量记录的地址：使用的是上一行代码代码执行时，在常量池中生成的"11"的地址
        //System.out.println(s3 == s4); // jdk6：false  jdk7/8：true

        s3=s3.intern();
        String s4 = "11";
        System.out.println(s3==s4);//true
    }

    public void test1(){
        String s=new String("a")+"b";
        String s2="ab";
        System.out.println(s2=="ab");
        System.out.println(s=="ab");
    }

    public void test2(){
        String s1=new String("ab");
        //String s1=new String("a")+new String("b");
        s1.intern();
        String s2="ab";
        System.out.println(s1==s2);
    }
}
