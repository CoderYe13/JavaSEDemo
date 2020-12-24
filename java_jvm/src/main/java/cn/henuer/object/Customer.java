package cn.henuer.object;

/**
 * 测试对象实例化的过程
 *  - ① 加载类元信息
 *  - ② 为对象分配内存
 *  - ③ 处理并发问题
 *  - ④ 属性的默认初始化（零值初始化）
 *  - ⑤ 设置对象头的信息
 *  - ⑥ 属性的显式初始化、代码块中初始化、构造器中初始化
 *
 *  给对象的属性(成员变量)赋值的操作：
 *  - ① 属性的默认初始化
 *  - ② 显式初始化 / ③ 代码块中初始化
 *  - ④ 构造器中初始化
 *  - 有了对象之后通过对象.属性或者对象.方法初始化
 *
 */

public class Customer{
    int id = 1001;
    String name;
    Account acct;

    {
        name = "匿名客户";
    }

    public Customer(){
        acct = new Account();
    }

}
class Account{

}
