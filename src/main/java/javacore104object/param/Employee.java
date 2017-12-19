/**
 * 
 */
package javacore104object.param;

/**
 * @author admin
 * 2017年10月12日
 */
public class Employee {

	private String name;
	private double salary;
	public String getName() {
		return name;
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void raiseSalary(double byPercent){
		salary+=salary*byPercent;
	}
}
