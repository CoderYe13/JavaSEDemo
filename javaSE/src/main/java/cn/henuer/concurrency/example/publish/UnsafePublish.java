package cn.henuer.concurrency.example.publish;

import cn.henuer.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @since 2019/4/16 20:11
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String[] states={"a","b","c"};
    public String[] getStates(){
        return states;
    }

    public static void main(String[] args){
        UnsafePublish unsafePublish=new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0]="d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

    }
}
