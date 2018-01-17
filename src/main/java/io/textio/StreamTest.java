/**
 * 
 */
package io.textio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.catalina.tribes.util.Arrays;
import org.junit.Test;

/**
 * @author admin
 * 2018年1月3日
 */
public class StreamTest {
   /* @Test
	public void OutputStreamTest() throws IOException{
		File file=new File("aa.txt");
		OutputStream out=new FileOutputStream(file,true);
		out.write(65);
		out.write("nana.chao".getBytes());
		out.write("abcdefg".getBytes(), 1, 4);
		out.close();
	}*/
    
    @Test
    public void InputStreamTest() throws IOException{
    	File file=new File("aa.txt");
    	InputStream in=new FileInputStream(file);
        int data1=in.read();
        byte[] b=new byte[10];
        in.read(b);
        in.close();
        System.out.println("b:"+Arrays.toString(b));
    }
    
    @Test
    public void FileOutputStream() throws IOException{
		FileOutputStream out=new FileOutputStream("aa.txt");
		out.write(65);
		out.write("nana.chao".getBytes());
		out.write("abcdefg".getBytes(), 1, 4);
		out.close();
    }
}
