package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类 创建对象有三个参数 类加载器 一个Class对象数组 还有一个调用处理器
 * 而为了提供一个调用处理器有一个前提，就是这个调用处理器必须是实现了InvocationHandler接口的类对象
 * 代理类在创建时候将会调用这个的处理器——将 proxy（代理对象），描述方法的类 m，以及参数都传递过来 其中一个参数 在 我们创建
 * 处理器类对象的时候就设置了 就是我们给1000数组要填入的数，然后每次设置完都调用动态代理的newProxyInstance
 * 来实现新的类的创建，然后在新建类的时候，应该是实现了 我们之前参数给的Comparable方法
 * 
 * @author Lucifer
 *
 */
public class TraceHandler implements InvocationHandler {
	private Object target;
	public TraceHandler(Object t) {
		target = t;
	}

	@Override
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		System.out.print(target);
		System.out.println("." + m.getName() + "(");

		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1)
					System.out.println(", ");
			}
		}
		System.out.println(")");
		// 这里是调用了反射invoke，可以调用任何方法
		return m.invoke(target, args);
	}
}
