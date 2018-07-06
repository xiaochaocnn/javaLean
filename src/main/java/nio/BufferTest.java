package nio;

import java.nio.ByteBuffer;

public class BufferTest {
	public static void main(String[] args) {
		//1.allocate 设置buffer容量
		ByteBuffer buffer = ByteBuffer.allocate(10);
		//2.通过数组设置
		byte[] array = new byte[10];
		buffer = buffer.wrap(array);
		for(int i=0;i<buffer.capacity();i++) {
			buffer.put(i, (byte) i);
		}
		buffer.position(2);
		buffer.limit(4);
		//分片数据和原缓冲区数据共享
		ByteBuffer slice=buffer.slice();
		for(int i=0;i<slice.capacity();i++) {
			slice.put(i, (byte) (slice.get()*10));
		}
		buffer.position(0);
		buffer.limit(buffer.capacity());
		while (buffer.hasRemaining()) {
			System.out.println(buffer.get());
		}
		for (byte b : array) {
			System.out.println(b);
		}

	}
}
