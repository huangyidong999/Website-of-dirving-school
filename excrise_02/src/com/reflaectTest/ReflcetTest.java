package com.reflaectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflcetTest {
	
	public static void main(String[] args){
		String name;
		if(args.length > 0)name = args[0];
		else
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name(e.g java.util.Date)");
			name = in.next();
		}
		
		try{
			// 得到class对象，class对象是对一个类属性的描述
			Class cl = Class.forName(name);
			// 返回这个代表这个实体的超类的Class对象
			Class supercl = cl.getSuperclass();
			// 返回cl这个class对象的类或接口的修饰符，再用静态方法将他转化为String
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers.length() > 0)System.out.print(modifiers + " ");
			System.out.print("class" + name);
			if(supercl != null && supercl != Object.class)System.out.print("extends "
					 + supercl.getName());
			
			System.out.print("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.println("}");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	/**
	 * 输出所有类的构造
	 * @param cl
	 */
	public static void printConstructors(Class cl){
		// 通过一个class对象，返回一个关于映射描述构造器对象的数组
		Constructor[] constructors = cl.getDeclaredConstructors();
		
		for(Constructor c:constructors){
			// 这里调用的是Constructor的getName方法，返回这个构造器的名字
			String name = c.getName();
			System.out.print(" ");
			// 返回这个对象可执行代表的Java修饰符 。 并转换成字符串
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0)System.out.println(modifiers + " ");
			System.out.print(name + "(");
			
			// 输出参数类型
			Class[] paramTypes = c.getParameterTypes();
			for(int j = 0;j < paramTypes.length; j++){
				if(j > 0)System.out.print(" , ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	public static void printMethods(Class cl){
		// 返回一个包含Method类型的数组，映射描述这个类或者接口的方法
		Method[] methods = cl.getDeclaredMethods();
		
		for(Method m : methods){
			// 返回一个class对象（描述类和接口的属性），痛过Method对象描述方法的返回类型
			Class retType = m.getReturnType();
			String name = m.getName();
			
			System.out.println("   ");
			// 依然是用getModifiers获得修饰符，输出修饰符，返回类型和方法名
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers + "");
			System.out.print(retType.getName() + " " + name +"(");
			// 通过这个对象，返回一个 Class类型的数组，描述正确的参数类型
			Class[] paramTypes = m.getParameterTypes();
			for(int j = 0; j < paramTypes.length;j++){
				if( j > 0)System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * 输出类的所有域内容
	 * @param cl
	 */
	public static void printFields(Class cl){
		// 通过一个类或接口的 Class 对象代表返回一个映射域对象的数组
		Field[] fields = cl.getDeclaredFields();
		
		for(Field f: fields){
			// 返回描述Field对象返回类型的Class对象
			Class type = f.getType();
			String name = f.getName();
			System.out.print("    ");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length() > 0)System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}
