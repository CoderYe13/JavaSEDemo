package cn.henuer.javase_base.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验IP地址工具类
 * @author sony
 *
 */
public class ValidIpAddress {
	private  String ipAddr;
	
	 public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public ValidIpAddress(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public  Boolean isIpAddress(){  
         String regex = "(((2[0-4]\\d)|(25[0-5]))|"
         		+ "(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|"
         		+ "(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|"
         		+ "(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|"
         		+ "(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))";  
         Pattern p = Pattern.compile(regex);  
         Matcher m = p.matcher(ipAddr);  
         return m.matches();  
 }  
}
