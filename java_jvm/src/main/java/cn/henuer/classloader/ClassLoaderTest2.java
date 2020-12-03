package cn.henuer.classloader;


public class ClassLoaderTest2 {
    public static void main(String[] args) {
        try {
            /**
             * 获取类加载器的方法
             */
            ClassLoader classLoader=Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);

            ClassLoader classLoader1=Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader1);

            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(classLoader2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
