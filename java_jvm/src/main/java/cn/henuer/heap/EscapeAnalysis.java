package cn.henuer.heap;

/**
 * java逃逸分析
 *   如何快速判断是否发生了逃逸分析，就看new的对象实体是不是有可能在方法外被调用，如果被方法外的其他方法调用
 *   就发生了逃逸分析，如果只在方法内被调用就没有，只会分配在栈上
 *
 *   jdk7 及以上默认开启逃逸分析，
 *   如果开启 -XX:+DoEscapeAnalysis
 */
public class EscapeAnalysis {
    public EscapeAnalysis obj;

    /**
     * 方法返回EscapeAnalysis对象，发生逃逸
     */
    public  EscapeAnalysis getInstance(){
        return obj==null?new EscapeAnalysis():obj;
    }
    /**
     * 为成员属性赋值，发生逃逸
     */
    public void setObj(EscapeAnalysis obj) {
        this.obj = obj;
    }

    //思考：如果当前obj引用声明为static的？仍然会发生逃逸
    /**
     * 对象的作用域仅在当前方法中有效，没有发生逃逸
     */
    public void useEscapeAnalysis(){
        EscapeAnalysis e=new EscapeAnalysis();
    }

    /**
     * 引用成员变量的值，发生逃逸分析
     */
    public void useEscapeAnalysis1(){
        EscapeAnalysis e=getInstance();
    }
}
