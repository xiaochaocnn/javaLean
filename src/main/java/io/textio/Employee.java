package io.textio;

public class Employee {
	public static int NAME_SIZE=10;
	public static int RECORD_SIZE=11;
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee(){}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
    
}
