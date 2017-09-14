package sthread.threadpool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
       Scanner in=new Scanner(System.in);
       System.out.println("directory:");
       String directory=in.nextLine();
       System.out.println("keyword:");
       String keyword=in.nextLine();
       //使用连接线程池时该做的事：
       // 1)调用Executors类中的静态的方法newCachedThreadPool或者newFixdThreadPool
       ExecutorService pool=Executors.newCachedThreadPool();
       MatchCounter counter =new MatchCounter(new File(directory),keyword,pool);
       // 2)调用submit提交Runnable 或Callable对象
       // 3)如果想要取消一个任务，或者提交Callable对象，那就要保存好返回的Future对象。
       Future<Integer> result=pool.submit(counter);
       System.out.println(result.get()+"  matching files");
       // 4)当不再提交任何任务时，调用shutdown
       pool.shutdown();
       int largestPoolSize=((ThreadPoolExecutor)pool).getLargestPoolSize();
       System.out.println("largest pool size="+largestPoolSize);
	} 
}
