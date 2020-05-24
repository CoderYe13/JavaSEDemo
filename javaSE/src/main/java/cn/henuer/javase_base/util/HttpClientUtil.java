package cn.henuer.javase_base.util;

//import java.io.IOException;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.util.EntityUtils;
//
//import com.alibaba.fastjson.JSONObject;

public class HttpClientUtil {
//	private static final String BAIDU_MAP_KEY = "6QtSF673D1pYl3eQkEXfwp8ZgsQpB77U";
//
//	private static final String BAIDU_MAP_GEOCONV_API = "http://api.map.baidu.com/geocoder/v2/?";
//
//	public static void main(String[] args) throws ClientProtocolException, IOException {
//		HttpClient httpClient = HttpClients.createDefault();
//		StringBuilder sb = new StringBuilder(BAIDU_MAP_GEOCONV_API);
//		sb.append("address=").append("北京市昌平区巩华家园1号楼2单元").append("&")
////		.append("city=").append("天津").append("&")
//				.append("output=json&").append("ak=").append(BAIDU_MAP_KEY);
//
//		HttpGet get = new HttpGet(sb.toString());
//
//		HttpResponse response = httpClient.execute(get);
//		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
//			System.out.println("Can not get baidu map location");
//		}
//		
//		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
//		System.out.println(result);
//		JSONObject jsonNode=(JSONObject)FastJsonUtil.stringToObject(result);
//		System.out.println(jsonNode);
//		
//		String json=FastJsonUtil.objectToString(jsonNode.get("result"));
//		
//		System.out.println(((JSONObject)FastJsonUtil.stringToObject(json)).get("location"));
//		
//	}
}
