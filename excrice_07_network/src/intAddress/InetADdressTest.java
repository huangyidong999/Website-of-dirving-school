package intAddress;

import java.io.*;
import java.net.*;
public class InetADdressTest {
	public static void main(String[] args) throws IOException {
		String[] t = new String[1];
		t[0] = "www.baidu.com";
		// 这里由于我们设置了数组大小 所以判断length其实没什么意义
		if(t.length > 0)
		{
			// 把域名存在host中  然后调用InetAddress的静态方法getAllByName，来获得域名所有的IP地址
			// 并保存在一个InerAddress数组 address中 。 InerAddress是一个封装4字节的序列的类
			String host = t[0];
			InetAddress[] address = InetAddress.getAllByName(host);
			// 这个输出是最有意思的，他会先输出域名，然后在输出主机名，中间以斜杠分隔
			for(InetAddress a :address)
				System.out.println(a);
		}
		else
		{
			InetAddress localHostAddress = InetAddress.getLocalHost();
			System.out.println(localHostAddress);
		}
	}
}
