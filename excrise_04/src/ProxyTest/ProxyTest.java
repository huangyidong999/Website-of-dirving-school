package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
	public static void main(String[] args) {
		Object[] elements = new Object[1];
		
		for(int i = 0;i < elements.length;i++){
			Integer value = i+1;
			InvocationHandler handler = new TraceHandler(value);
			// 代理类 创建对象有三个参数 类加载器  一个Class对象数组   还有一个调用处理器
			// 而这里，null代表了我们使用默认类加载器，  第二个参数 指定了我们代理类需要实现的接口
			Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
			System.out.println("-------- :" + proxy.getClass().getName());
			elements[i] = proxy;
		}
		Integer key = new Random().nextInt(elements.length);
		int result = Arrays.binarySearch(elements, key);
		if(result >= 0) System.out.println(elements[result]);
	}
	
}
