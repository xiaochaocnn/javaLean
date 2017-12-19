package io.randomAccess;

import io.textio.Employee;

import java.io.*;

public class RandomAccessTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Employee[] employees = new Employee[3];
		employees[0] = new Employee("aaa", 10);
		employees[1] = new Employee("bbb", 20);
		employees[2] = new Employee("ccc", 30);
		try {
			//1.写入文本
			DataOutputStream out=new DataOutputStream(new FileOutputStream("employee.txt"));
			for (Employee employee : employees) {
				writeData(employee, out);
			}
			
            //2.读出文本
			RandomAccessFile in=new RandomAccessFile("employee.txt","r");
			int n=(int)(in.length()/Employee.RECORD_SIZE);
			Employee[] employeess=new Employee[n];
			for(int i=n-1;i>=0;i--){
				employees[i]=new Employee();
				in.seek(i*Employee.RECORD_SIZE);
				employees[i]=readData(in);
			}
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
     * @throws IOException 
     */
	public static void writeData(Employee employee, DataOutputStream out) throws IOException {
		DataIO.wirteFixedString(employee.getName(),Employee.NAME_SIZE,out);
		out.writeDouble(employee.getSalary());
	}
    /**
     * description:读取文件数据
     * author:nana.chao
     * 2017年9月19日
     * @param in
     * @return
     * @throws IOException 
     */
	public static Employee readData(DataInput in) throws IOException {
		String name=DataIO.readFiedString(Employee.NAME_SIZE, in);
		Double salary=in.readDouble();
		return new Employee(name,salary);
	}

}
