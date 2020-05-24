package cn.henuer.javase_base;

/**
 * @author CoderYe
 * @version 2020年1月31日 下午1:44:28
 */

//枚举类测试

enum PayWay {
	ALIPAY(1000, "支付宝钱包"), WECHATPAY(1001, "微信支付");

	private int code;
	private String value;

	private PayWay(int code, String value) {
		this.code = code;
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	public static PayWay codeValueOf(int code) {
		for (PayWay payWay : values()) {
			if (payWay.getCode() == code) {
				return payWay;
			}
		}
		throw new RuntimeException();
	}

}

public class JavaDemo4 {

	public static void main(String[] args) {
		System.out.println();
	}

}
