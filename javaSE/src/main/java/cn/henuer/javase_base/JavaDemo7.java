package cn.henuer.javase_base;

/**
 * @author CoderYe
 * @version 2020年2月5日 下午3:07:54
 */

//ThreadLocal

class Message2 {// 消息体
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}

class Channel {
	private final static ThreadLocal<Message2> THREADLOCAL = new ThreadLocal<>();

	private Channel() {
	}

	public static void setMessage(Message2 message) {
		THREADLOCAL.set(message);
	}

	public static void send() {
		System.out.println("【" + Thread.currentThread().getName() + "、发送消息】" + THREADLOCAL.get().getInfo());
	}

}

public class JavaDemo7 {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread(() -> {
				Message2 message2 = new Message2();
				message2.setInfo("12");
				Channel.setMessage(message2);
				Channel.send();
			}).start();
		}
	}
}
