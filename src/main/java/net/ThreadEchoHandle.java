/**
 * 
 */
package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author admin 2018年1月16日
 */
public class ThreadEchoHandle implements Runnable {
	private Socket incoming;

	public ThreadEchoHandle(Socket i) {
		this.incoming = i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			try {
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true);
				out.println("Hello,Enter Bye to exit");
				boolean done = false;
				while (!done && in.hasNextLine()) {
					String line = in.nextLine();
					System.out.println("Echo:" + line);
					if (line.trim().equals("Bye"))
						done = true;
				}
			} finally {
				incoming.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
