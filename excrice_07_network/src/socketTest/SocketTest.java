package socketTest;

import java.io.*;
import java.net.*;
import java.util.*;

public class SocketTest {
	public static void main(String[] args) throws IOException {
		// 这里创建套接字，输入了参数域名（将会转换成IP地址），和端口号13，套接字对象为s
		try(Socket s = new Socket("time-a.nist.gov", 13);
				// 这里将套接字对象s先调用getInputStream转化成输入流，
				// 然后再调用输入类，构造一个UTF-8的输入流对象 in
				Scanner in = new Scanner(s.getInputStream(),"UTF-8");)
		{
			// 如果in中有下一行 就输出他
			while(in.hasNextLine()){
				String line = in.nextLine();
				System.out.println(line);
			}
		}
		
	}
}
