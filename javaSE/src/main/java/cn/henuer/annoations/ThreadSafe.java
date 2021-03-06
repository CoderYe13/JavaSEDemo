package cn.henuer.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 课程里用来标记线程安全的类或写法
 * @author 小陽
 * @since 2019/4/12 21:43
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)//在编译时就拿掉
public @interface ThreadSafe {
    String value() default "";
}
