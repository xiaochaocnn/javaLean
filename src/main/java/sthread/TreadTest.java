package sthread;

public class TreadTest {
	public static void main(String[] arg){
		ThreadCreatIml tc1=new ThreadCreatIml("t1");
		ThreadCreatIml tc2=new ThreadCreatIml("t2");
		Thread t1=new Thread(tc1);
		Thread t2=new Thread(tc2);
		t1.start();
		t2.start();
	}
}
