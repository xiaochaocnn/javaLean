package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
	public static void main(String[] args) throws IOException {
		// 1. 定义ServerSocketChannel 并监听本机指定的端口
		ServerSocketChannel socketChannel = ServerSocketChannel.open();
		// 2. 设置非阻塞模式
		socketChannel.configureBlocking(false);
		// 3. 检索与此通道关联的服务器套接字
		ServerSocket serverSocket = socketChannel.socket();
		// 4. 进行服务的绑定
		serverSocket.bind(new InetSocketAddress(8099));
		// 5. 定义Selector
		Selector selector = Selector.open();
		// 6. 注册selector
		socketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (true) {
			// 7.1 返回读事件已经就绪的那些通道。 并进行判断
			if (selector.select(1000 * 4) == 0) {
				System.out.println("服务器在等待。。。");
				continue;
			}
			// 7.2 一旦调用了select()方法，并且返回值表明有一个或更多个通道就绪了
			// 然后可以通过调用selector的selectedKeys()方法，访问“已选择键集（selected key
			// set）”中的就绪通道。
			Set<SelectionKey> selectionKetsets = selector.selectedKeys();
			Iterator<SelectionKey> iteratorKey = selectionKetsets.iterator();
			SocketChannel client = null;
			while (iteratorKey.hasNext()) {
				SelectionKey selectionKey = iteratorKey.next();
				if (selectionKey.isAcceptable()) {
					// 7.4.1接受到此通道套接字的连接。
					// 此方法返回的套接字通道（如果有）将处于阻塞模式。
					client = socketChannel.accept();
					// 7.4.2配置为非阻塞
					client.configureBlocking(false);
					Socket socket = client.socket();
					SocketAddress remoteAddr = socket.getRemoteSocketAddress();
					System.out.println("Connected to: " + remoteAddr + "  \t Connection Accepted:   \n");
					// 7.4.3注册到selector，等待连接
					client.register(selector, SelectionKey.OP_READ);
				}
				if (selectionKey.isReadable()) {

					// 7.5.1 返回为之创建此键的通道。
					client = (SocketChannel) selectionKey.channel();
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 3);
					// 7.5.2 将缓冲区清空以备下次读取
					byteBuffer.clear();
					// 读取服务器发送来的数据到缓冲区中
					int readCount = -1;
					readCount = client.read(byteBuffer);
					// 如果没有数据 则关闭
					if (readCount == -1) {
						Socket socket = client.socket();
						SocketAddress remoteAddr = socket.getRemoteSocketAddress();
						System.out.println("Connection closed by client: " + remoteAddr);
						client.close();
						selectionKey.cancel();
						return;
					}
					// 有数据 则打印输出
					String receiveText = new String(byteBuffer.array(), 0, readCount);
					System.out.println("服务器端接受客户端数据--:" + receiveText);
				}
				iteratorKey.remove();
			}
		}
	}
}
