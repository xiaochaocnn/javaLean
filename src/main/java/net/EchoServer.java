/**
 * 
 */
package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author admin
 * 2018年1月16日
 */
public class EchoServer {

	public static void main(String[] args) throws IOException {
		ServerSocket s=new ServerSocket(8189);
		Socket socket=s.accept();
		InputStream inStream=socket.getInputStream();
		OutputStream outStream=socket.getOutputStream();
		
		Scanner in=new Scanner(inStream);
		PrintWriter out=new PrintWriter(outStream,true);
		out.println("Hello,Enter Bye to exit");
		boolean done=false;
		while(!done && in.hasNextLine()){
			String line=in.nextLine();
			System.out.println("Echo:"+line);
			if(line.trim().equals("Bye"))
				done=true;
		}
	}
}
