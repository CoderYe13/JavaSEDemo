package cn.henuer;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
public class SimpleDateFormatTest {
    static String format="yyyy-MM-dd";
   static SimpleDateFormat sdf=new SimpleDateFormat(format);

   static DateTimeFormatter dtf=DateTimeFormatter.ofPattern(format);
    public static void main(String[] args) {

    }

    /**
     * SimpleDateFormat线程不安全
     */
    public void test(){
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try{
                    log.debug("{}",sdf.parse("1951-04-21"));
                }catch (Exception e){
                    log.error("{}",e);
                }
            }).start();
        }
    }

    /**
     * 同步锁保证线程安全
     */
    public void test1(){
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                synchronized (sdf){
                    try{
                        log.debug("{}",sdf.parse("1951-04-21"));
                    }catch (Exception e){
                        log.error("{}",e);
                    }
                }
            }).start();
        }
    }

    /**
     * 使用线程安全的DateTimeFormatter
     */
    public void test2(){
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LocalDate date = dtf.parse("2018-10-01", LocalDate::from);
                log.debug("{}", date);
            }).start();
        }
    }
}
