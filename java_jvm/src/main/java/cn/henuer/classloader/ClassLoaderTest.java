package cn.henuer.classloader;

import java.net.URL;

public class ClassLoaderTest {
    public static void main(String[] args) {
        /**
         * 获取Bootstrap类加载器加载的api路径
         */
        System.out.println("BootStrap类加载器");
        URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url:urls){
            System.out.println(url);
        }
        System.out.println("ExtClassLoader 类加载器");
        String strings=System.getProperty("java.ext.dirs");
        for (String dir: strings.split(";")){
            System.out.println(dir);
        }
    }
}
