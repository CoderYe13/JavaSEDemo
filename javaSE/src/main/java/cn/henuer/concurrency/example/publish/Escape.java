package cn.henuer.concurrency.example.publish;

import cn.henuer.annoations.NotRecommend;
import cn.henuer.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @since 2019/4/16 20:22
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape=0;
    public Escape(){
        new InnerClass();
    }
    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
