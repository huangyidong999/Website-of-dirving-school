package ThreadEchoServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class ThreadEchoServerTest {
	public static void main(String[] args) {
		// 服务器端主程序，服务器套接字端口设置为8189
		try(ServerSocket s = new ServerSocket(8189))
		{
			// 记录访问的客户数量
			int i = 1;
			while(true){
				// 服务器套接字 s 开启套接字监听
				Socket incoming = s.accept();
				System.out.println("Spawning" + i);
				// 为当前连接的套接字建立线程，这个线程能够处理输入输出流
				Runnable r = new ThreadedEchoHandler(incoming);
				Thread t = new Thread(r);
				t.start();
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
