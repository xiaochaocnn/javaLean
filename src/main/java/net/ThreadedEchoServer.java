/**
 * 
 */
package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author admin 2018年1月16日
 */
public class ThreadedEchoServer {
	public static void main(String[] args) {
          try{
        	  int i=1;
        	  ServerSocket s=new ServerSocket(8189);
        	  while(true){
        		  Socket socket=s.accept();
        		  System.out.println("Spawing "+i);
        		  Runnable r=new ThreadEchoHandle(socket);
        		  Thread t=new Thread(r);
        		  t.start();
        		  i++;
        		  
        	  }
          }catch(IOException e){
        	  
          }
	}
}
