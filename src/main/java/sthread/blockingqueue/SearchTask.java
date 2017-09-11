package sthread.blockingqueue;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class SearchTask implements Runnable {

	private BlockingQueue<File> queue;
	private String keyword;

	public SearchTask(BlockingQueue<File> queue, String keyword) {
		super();
		this.queue = queue;
		this.keyword = keyword;
	}

	@Override
	public void run() {
		try {
			boolean done = false;
			while (!done) {
				File file = queue.take();
				if(file==FileEnumerantionTask.file){
					queue.put(file);
					done=true;
				}else{
					search(file);
				}
			}
		}catch(IOException e){
			
		}catch (InterruptedException e) {
			
		}
	}
	
	public void search(File file) throws FileNotFoundException{
		try(Scanner in=new Scanner(file)){
			int lineNumber=0;
			while(in.hasNextLine()){
				lineNumber++;
				String line=in.nextLine();
				if(line.contains(keyword)){
					System.out.printf("%s:%d:%s%n",file.getPath(),lineNumber,line);
				}
			}
		}
	}
}
