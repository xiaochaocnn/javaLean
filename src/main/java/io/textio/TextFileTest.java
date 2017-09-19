package io.textio;

import java.io.*;
import java.util.Scanner;

public class TextFileTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Employee[] employees = new Employee[3];
		employees[0] = new Employee("aaa", 10.00);
		employees[1] = new Employee("bbb", 20.00);
		employees[2] = new Employee("ccc", 30.00);
		try {
			//1.写入文本
			PrintWriter out = new PrintWriter("employee.txt", "UTF-8");
			writeData(employees, out);
            //2.读出文本
			Scanner in = new Scanner(new FileInputStream("employee.txt"), "UTF-8");
			Employee[] employeess=readData(in);
			for (Employee employee : employeess) {
				System.out.println(employee);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /**
     * description:将数据写入文件
     * author:nana.chao
     * 2017年9月19日
     * @param employees
     * @param out
     */
	public static void writeData(Employee[] employees, PrintWriter out) {
		out.println(employees.length);
		for (Employee employee : employees) {
			out.println(employee.getName() + "|" + employee.getSalary());
		}
		if (out.checkError()) {
			System.out.println("日志重建异常！data:" + employees.length);
		}
	}
    /**
     * description:读取文件数据
     * author:nana.chao
     * 2017年9月19日
     * @param in
     * @return
     */
	public static Employee[] readData(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		Employee[] employees = new Employee[n];
		for (int i = 0; i < n; i++) {
			employees[i] = readEmployee(in);
		}
		return employees;
	}
    /**
     * description:解析每一行数据
     * author:nana.chao
     * 2017年9月19日
     * @param in
     * @return
     */
	public static Employee readEmployee(Scanner in) {
		String line = in.nextLine();
		String[] temps = line.split("\\|");
		String name = temps[0];
		Double salary = Double.parseDouble(temps[1]);
		return new Employee(name, salary);
	}

}
