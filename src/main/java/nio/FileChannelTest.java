package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
	FileInputStream fromfile = null;
	FileOutputStream tofile = null;
	FileChannel fromChannel = null;
	FileChannel toChannel = null;

	public void getChannel() throws FileNotFoundException {
		fromfile = new FileInputStream(new File("aa.txt"));
		tofile = new FileOutputStream(new File("bb.txt"));
		fromChannel = fromfile.getChannel();
		toChannel = tofile.getChannel();
	}

	public void channelReadAWrite() throws IOException {
		getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(100);
		while (fromChannel.read(buffer) != -1) {
			buffer.flip();
			while (buffer.hasRemaining()) {
				toChannel.write(buffer);
			}
			buffer.clear();
		}
		close();
	}

	public void close() throws IOException {
		toChannel.close();
		fromChannel.close();
		tofile.close();
		fromfile.close();
	}

	public void transfer() throws IOException {
		getChannel();
		int position = 0;
		long count = fromChannel.size();
		long successCount = toChannel.transferFrom(fromChannel, position, count);
		// long successCount = fromChannel.transferTo(position, count, inChannel);

		System.out.println(successCount);
	}

	public static void main(String[] args) throws IOException {
		FileChannelTest test = new FileChannelTest();
		//test.channelReadAWrite();
		test.transfer();
	}
}
