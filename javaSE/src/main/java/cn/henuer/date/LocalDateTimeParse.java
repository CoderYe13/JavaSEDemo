package cn.henuer.date;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeParse {
    public static void main(String[] args) {
        LocalDateTime rightNow=LocalDateTime.now();
        System.out.println("当前时间："+rightNow);
        System.out.println("当前月份："+rightNow.getMonth());
        System.out.println("当前日份："+rightNow.getDayOfMonth());
        System.out.println("当前时："+rightNow.getHour());
        System.out.println("当前分："+rightNow.getMinute());
        System.out.println("当前秒："+rightNow.getSecond());

        System.out.println(rightNow.format(DateTimeFormatter.ISO_DATE));
        System.out.println(rightNow.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(rightNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        //反解析时间
        System.out.println(LocalDateTime.parse("2002--01--02 11:21",DateTimeFormatter.ofPattern("yyyy--MM--dd HH:mm")));
        //获取秒数
        System.out.println(rightNow.toEpochSecond((ZoneOffset.of("+8"))));
        //获取毫秒数时间戳
        Long time=rightNow.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(time);

        //反解析时间戳
        System.out.println(LocalDateTime.ofEpochSecond( time/1000,0, ZoneOffset.of("+8")));

    }
}
