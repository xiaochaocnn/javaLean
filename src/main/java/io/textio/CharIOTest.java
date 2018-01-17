/**
 * 
 */
package io.textio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * @author admin
 * 2018年1月3日
 */
public class CharIOTest {
	
	@Test
	public void WriteTest() throws IOException{
		File file=new File("aa.txt");
		@SuppressWarnings("resource")
		Writer write=new FileWriter(file, true);
		write.write("离开，想忘不能忘最伤怀");
		write.close();
	}
    @Test
	public void ReaderTest() throws IOException{
		File file=new File("aa.txt");
		@SuppressWarnings("resource")
		Reader reader=new FileReader(file);
		int len=10;
		char[] buffer=new char[10];
		while((len=reader.read(buffer,0,10))!=-1){
			System.out.println(new String(buffer,0,10));
		}
		reader.close();
	}
}
