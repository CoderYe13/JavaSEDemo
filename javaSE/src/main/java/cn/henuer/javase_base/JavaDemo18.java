package cn.henuer.javase_base;
/**
*@author CoderYe
*@version 2020年2月13日 下午3:14:37
*/

//反射与工厂设计模式
class Factorys{
	private Factorys() {}
	
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String className,Class<T> clazz) {
		T instance=null;
		try {
			//此步骤必须类要有非私有化构造方法
			instance=(T)Class.forName(className).newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return instance;
	}
}
public class JavaDemo18 {

	public static void main(String[] args) throws Exception {
		
		BigDecimalDemo person=Factorys.getInstance("BigDecimalDemo",BigDecimalDemo.class);
		
		System.out.println(person);
	}

}
