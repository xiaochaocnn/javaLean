/**
 * 
 */
package net;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author admin 2018年1月17日
 */
public class URLConnectionTest {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.baidu.com/");
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		connection.connect();
		Map<String, List<String>> headers = connection.getHeaderFields();
		for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
			String key = entry.getKey();
			for (String value : entry.getValue()) {
				System.out.println(key + ":" + value);
			}
		}

		System.out.println("-----------");
		System.out.println("getContenType:" + connection.getContentType());
		System.out.println("getContenLength:" + connection.getContentLength());
		System.out.println("getContenEncoding:" + connection.getContentEncoding());
		System.out.println("getDate:" + connection.getDate());
		System.out.println("getExpiration:" + connection.getExpiration());
		System.out.println("getLastModifed:"+connection.getLastModified());
		System.out.println("-------------");
		
		Scanner in=new Scanner(connection.getInputStream());
		for(int n=1;in.hasNextLine()&&n<10;n++){
			System.out.println(in.nextLine());
		}
		if(in.hasNextLine())
			System.out.println(".....");
	}
}
