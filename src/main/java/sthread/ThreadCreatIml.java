package sthread;

public class ThreadCreatIml implements Runnable {
	private String threadName;

	public ThreadCreatIml(String threadName) {
		super();
		this.threadName = threadName;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			System.out.println("threadname:" + this.threadName + "--->" + i);
		}
	}
	
	public static void main(String[] arg){
		ThreadCreatIml t1=new ThreadCreatIml("t1");
		ThreadCreatIml t2=new ThreadCreatIml("t2");
		t1.run();
		t2.run();
	}
}

