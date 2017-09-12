package sthread.callable;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
       Scanner in=new Scanner(System.in);
       System.out.println("directory:");
       String directory=in.nextLine();
       System.out.println("keyword:");
       String keyword=in.nextLine();
       
       MatchCounter counter =new MatchCounter(new File(directory),keyword);
       FutureTask<Integer> task=new FutureTask<>(counter);
       Thread t=new Thread(task);
       t.start();
       System.out.println(task.get()+"  matching files");
       
	} 
}
