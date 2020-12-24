package cn.henuer.object;

/**
 * 给对象的属性(成员变量)赋值的操作：
 *   - ① 属性的默认初始化
 *   - ② 显式初始化 / ③ 代码块中初始化
 *   - ④ 构造器中初始化
 *   - 有了对象之后通过对象.属性或者对象.方法初始化
 */
public class Father {
    int i=10;
    public Father(){
        this.print();
        i=30;
    }

    public void print() {
        System.out.println("Father i="+i);
    }
}
class Son extends Father{
    int i=30;
    public Son() {
        this.print();
        i=40;
    }

    @Override
    public void print() {
        System.out.println("Son i="+i);
    }

    /**
     *  Father f=new Son();
     *  System.out.println(f.i);
     *  执行结果
     *      Son i=0
     *      Son i=30
     *      30
     *  为什么会这样，因为new Son()进入构造方法，
     *  首先获得aload_0 这个是son的this，然后先new Father()，进入Father的构造方法，此时调用方法体内的print()
     *  这个实际是调用this.print(),这个方法此时这个this是谁呢，其实就是son,son调用的时候我们可以发现语句中
     *  打印的this.i值其实是0,为什么呢？因为Son.class中 1: invokespecial #1(new Father()),
     *  发生在  5: bipush  30（给i赋值为30），此时的this.i的值是准备阶段赋的值就是0所以第一次打印的是0
     *  第二次打印30其实很好理解就是调用new Son()此时this.i被赋值为30了，
     *  这里最迷惑人的就是这个this指向的是哪个对象
     *          Son.class
     *          0: aload_0
     *          1: invokespecial #1                  // Method cn/henuer/object/Father."<init>":()V
     *          4: aload_0
     *          5: bipush        30
     *          7: putfield      #2                  // Field i:I
     *         10: aload_0
     *         11: invokevirtual #3                  // Method print:()V
     *         14: aload_0
     *         15: bipush        40
     *         17: putfield      #2                  // Field i:I
     *         20: return
     *
     *         Father.class
     *          0: aload_0
     *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *          4: aload_0
     *          5: bipush        10
     *          7: putfield      #2                  // Field i:I
     *         10: aload_0
     *         11: invokevirtual #3                  // Method print:()V
     *         14: aload_0
     *         15: bipush        30
     *         17: putfield      #2                  // Field i:I
     *         20: return
     * @param args
     */
    public static void main(String[] args) {
        Father f=new Son();
        System.out.println(f.i);
    }
}


