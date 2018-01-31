package PostTest;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

/**
 * 在 urlConnection 中我们知道了如何从服务器中读取数据，本次将介绍如何将表单的数据以POST的形式
 * 发送给服务器
 * @author Lucifer
 *
 */
public class PosetTest {
	public static void main(String[] args) throws IOException {
		// 这是看命令行有没有输入我们需要的参数，如果没，就从 propertites文件中读取
		String propsFilename = args.length > 0 ? args[0] : "post/post.properties";
		Properties props = new Properties();
		// 用输入流 加载文件，文件名放在propsFileName中
		try(InputStream in = Files.newInputStream(Paths.get(propsFilename)))
				{
					// 加载输入流内数据
					props.load(in);
				}
		// 取出数据，删除 存储中的 标注这是什么数据的无用字符串
		String urlString = props.remove("url").toString();
		Object userAgent = props.remove("User-Agent");
		Object redirects = props.remove("redirects");
		// 这句要查一下
		CookieHandler.setDefault(new CookieManager (null,CookiePolicy.ACCEPT_ALL));
		// 这里调用了下面的doPost方法
		String result = doPost(new URL(urlString),props,
				userAgent == null ? null : userAgent.toString(),
				redirects == null ? -1 : Integer.parseInt(redirects.toString())
				);
		System.out.println(result);
	}
	
	// 这就是核心，我们自己写的doPost方法
	public static String doPost(URL url, Map<Object, Object>nameValuePairs, String userAgent,
			int redirects) throws IOException
	{
		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		// 如果参数userAgent不为空 就为打开的URL连接类设置该属性
		
		if(userAgent != null)
			connection.setRequestProperty("User-Agent", userAgent);
		
		// 看上面 如果redirects为空 会返回-1 ，所以这里是判断redirects参数是否为空，并设置一个
		// setInstanceFollowRedirects的方法来设置如何处理重定向，true就系统自动处理跳转，但是对于
		// 有多次跳转的情况，就只能处理第一次  ， false则是自己手动处理跳转，我们可以拿到一些比较有用的数据
		// 比如cookie Location之类的。
		
		if(redirects >= 0)
			connection.setInstanceFollowRedirects(false);
		
		// 为URL打开输出流，准备向服务器输入post类型的数据
		connection.setDoOutput(true);
		// 创建一个输出流，并得到 刚刚 URL 对象 connection的流，通过他我们才能向服务器发出数据
		try(PrintWriter out = new PrintWriter(connection.getOutputStream()))
		{
			// 这里通过一个 first类型的波尔类型变量，让我们对Map集合（我们参数给的）的循环只能进行
			// 一次，我们通过输出流输出了这个映射中的第一个数据的键和值。
			boolean first = true;
			// 读取运行前配置好的映射文件
			for(Map.Entry<Object, Object> pair : nameValuePairs.entrySet())
			{
				if(first) first = false;
				else out.print('&');
				String name = pair.getKey().toString();
				String value = pair.getValue().toString();
				out.print(name);
				out.print('=');
				out.print(URLEncoder.encode(value, "UTF-8"));
			}
		}
		// 我们返回了该URL当前使用的编码格式
		String encoding = connection.getContentEncoding();
		if(encoding == null) encoding = "UTF-8";
		// 如果说真的有重定向
		if(redirects > 0)
		{
			// 获取http的响应码  第一个是 301代表永久移动； 302是临时移动； 303是查看其他位置
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_MOVED_PERM
					|| responseCode == HttpURLConnection.HTTP_MOVED_TEMP
					|| responseCode == HttpURLConnection.HTTP_SEE_OTHER)
			{
				// 获取指定响应头字段的值，这里选择了header中的Location属性的数据，奥，对了
				// 如果发生重定向，重定的地址可以这样获得。
				String location = connection.getHeaderField("Location");
				if(location != null)
				{
					// 这里重新打开URL 重新调用doPost方法
					URL base = connection.getURL();
					connection.disconnect();
					return doPost(new URL(base, location),nameValuePairs, userAgent, redirects - 1);
				}
			}
		}
		else if(redirects == 0)
		{
			throw new IOException("Too many redircts");
		}
		StringBuilder response = new StringBuilder();
		// 这里是读取URL类对象connection对的内容
		try(Scanner in = new Scanner(connection.getInputStream(), encoding))
		{
			while(in.hasNextLine())
			{
				response.append(in.nextLine());
				response.append("\n");
			}
		}
		catch(IOException e)
		{
			// 如果说读取中发现了错误，就添加到response字符串中
			InputStream err = connection.getErrorStream();
			if(err == null)throw e;
			try(Scanner in = new Scanner(err))
			{
				response.append(in.nextLine());
				response.append("\n");
			}
		}
		return response.toString();
	}
}
