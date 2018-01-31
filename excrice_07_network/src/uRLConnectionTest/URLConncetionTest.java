package uRLConnectionTest;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
/**
 * 
 * @author Lucifer
 * 该程序可以对URL连接做一些实验。运行后，请在命令行中输入一个URL以及用户名和密码（可选）
 * 将会输出：
 * 消息头中的所有键和值
 * 一些方法的返回值
 * 被请求资源的前十行信息
 */
public class URLConncetionTest {
	public static void main(String[] args) {
		
		try{
		String urlName;
		if(args.length > 0) urlName = args[0];
		else urlName = "http://www.baidu.com";
		
		URL url = new URL(urlName);
		// 返回了一个URLConnection对象，这个对象负责管理与资源之间的连接
		URLConnection connection = url.openConnection();
		
		// 设置名字，密码，如果输入的命令行有这些的话
		if(args.length > 2)
		{
			String username = args[1];
			String password = args[2];
			String input  = username + ":" +password;
			Base64.Encoder encoder = Base64.getEncoder();
			String encoding = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));
			connection.setRequestProperty("Authorization", "Basic" + encoding);
		}
		// 这个对象的connect方法，连接远程资源并获取相应头信息
		connection.connect();
		
		// 输出头部的域
		
		// getHeaderFields方法，返回响应的一个映射表。相同的键对应的所有值被放在同一个列表中
		Map<String,List<String>> headers = connection.getHeaderFields();
		for(Map.Entry<String, List<String>> entry : headers.entrySet())
		{
			String key = entry.getKey();
			for(String value : entry.getValue())
				System.out.println(key + ": " +value);
		}
		// 上方的方法会得到我们相应的报文的所有消息，但是为了方便和灵活，我们也可以通过调用方法来完成
		// 对一些常用消息的值的查看。
		System.out.println("-------------");
		System.out.println("getContentionType: " + connection.getContentType());
		System.out.println("getContentLength: " + connection.getContentLength());
		System.out.println("getContentEncoding: " + connection.getContentEncoding());
		System.out.println("getDate : " + connection.getDate());
		System.out.println("getExpirarion : " + connection.getExpiration());
		System.out.println("getLastModifed : " + connection.getLastModified());
		System.out.println("-------------");
		
		// 这是获取响应报文的编码机制
		String encoding = connection.getContentEncoding();
		if(encoding == null) encoding = "UTF-8";
		// URLconnection对象的getInputStream 返回从URL资源读取信息的流 同样 我们还有个写入的流
		// 这里我们返回的是URL的源码 就是HTML页面写的内容
		try(Scanner in = new Scanner(connection.getInputStream(),encoding)){
			// 输出10 行
			for(int n = 1 ;in.hasNextLine() && n <=10;n++)
				System.out.println(in.nextLine());
			if(in.hasNextLine()) System.out.println(" ... ");
		}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
