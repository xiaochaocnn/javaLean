/**
 * 
 */
package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;

/**
 * @author admin
 * 2018年1月16日
 */
public class netTest {
	
	@Test
	public void socketTest() throws UnknownHostException, IOException{
		Socket socket=new Socket("time-A.timefreq.bldrdoc.gov",13);
		InputStream inStream=socket.getInputStream();
		Scanner in=new Scanner(inStream);
		while(in.hasNextLine()){
			String line=in.nextLine();
			System.out.println(line);
		}
	}
	
	@Test
	public void addressTest() throws UnknownHostException{
		String host="172.16.11.6";
		InetAddress[] address=InetAddress.getAllByName(host);
		for (InetAddress a : address) {
			System.out.println(a);
		}
		
		InetAddress local=InetAddress.getLocalHost();
		System.out.println(local);
	}

}
