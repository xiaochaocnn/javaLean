/**
 * 
 */
package javacore104object.param;

/**
 * @author admin
 * 2017年10月12日
 */
public class ParamTest {

	/**
	 * description:
	 * author:admin
	 * 2017年10月12日
	 * @param args
	 */
	public static void main(String[] args) {
       System.out.println("Testing tripleValue:");
       double percent=10;
       System.out.println("Before:percent="+percent);
       tripleValue(percent);
       System.out.println("After:percent="+percent);
       
       System.out.println("\nTesting tripleSalary:");
       Employee harry=new Employee("harray",5000);
       System.out.println("Before: salary="+harry.getSalary());
       tripleSalary(harry);
       System.out.println("Afer:salary="+harry.getSalary());
       
       System.out.println("\nTesting swap:");
       Employee a=new Employee("aa", 1000);
       Employee b=new Employee("bb", 2000);
       System.out.println("Before:a="+a.getName());
       System.out.println("Before:b="+b.getName());
       swap(a,b);
       System.out.println("After:a="+a.getName());
       System.out.println("After:b="+b.getName());
	}

	/**
	 * description:
	 * author:admin
	 * 2017年10月13日
	 * @param a
	 * @param b
	 */
	private static void swap(Employee x, Employee y) {
		Employee temp=x;
		x=y;
		y=temp;
		System.out.println("End of method: x="+x.getName());
		System.out.println("End of method: y="+y.getName());
	}

	/**
	 * description:
	 * author:admin
	 * 2017年10月13日
	 * @param harry
	 */
	private static void tripleSalary(Employee harry) {
		harry.raiseSalary(5);
		System.out.println("End of method: salary="+harry.getSalary());
	}

	/**
	 * description:
	 * author:admin
	 * 2017年10月13日
	 * @param percent
	 */
	private static void tripleValue(double x) {
		x=x*3;
		System.out.println("End of method: x="+x);
	}
    
}
