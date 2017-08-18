package model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Student")
public class Student {
	@XmlElement(name="name",required=true)
    private String name;
	@XmlElement(name="age",required=true)
    private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student(){
		super();
	}
    
   public static void main(String[] args){
	   try {
		JAXBContext jc=JAXBContext.newInstance(Student.class);
		Marshaller ms=jc.createMarshaller();
		Student st=new Student("chaochao", 18);
		ms.marshal(st, System.out);
		
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   } 
}
