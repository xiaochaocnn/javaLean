package sthread.blockingqueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class FileEnumerantionTask implements Runnable{
    public static File file=new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;
    
	public FileEnumerantionTask(BlockingQueue<File> queue, File startingDirectory) {
		super();
		this.queue = queue;
		this.startingDirectory = startingDirectory;
	}

	@Override
	public void run() {
		try{
			enumerate(startingDirectory);
			queue.put(file);
		}catch(InterruptedException e){
			
		}
	}

	public void enumerate(File directory) throws InterruptedException{
		File[] files=directory.listFiles();
		for (File file : files) {
			if(file.isDirectory())
				enumerate(file);
			else
				queue.put(file);
		}
	}
}
