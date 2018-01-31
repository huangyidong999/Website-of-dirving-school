package TextFileTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class TextTest {
	public static void main(String[] args) throws IOException {
		Employee[] staff = new Employee[3];
		// 创建数组内容
		staff[0] = new Employee("黄一东",10000);
		staff[1] = new Employee("黄玮东",20000);
		staff[2] = new Employee("黄玮琛",30000);
		
		// 写出通过写出类来 写出staff的内容 。 这里的PrintWriter自己内部会实现FileOutputStream
		try(PrintWriter out = new PrintWriter("Employee.dat","UTF-8"))
		{
			// 调用WriteData 先向文本写入数组的大小，再根据数组大小分别调用WriteEmpolyee
			// 按照格式写入各个数据
			writeData(staff, out);
		} 
		
		// 通过读入类 Scanner来读入employee.dat（UTF-8）的内容  这里显式的调用了
		// FileInputStream类 组合了流类 
		try(Scanner in = new Scanner(new FileInputStream("employee.dat"),"UTF-8"))
		{
			// 这里调用readData（文件读入流对象） 先获取文件第一行保存的对象行数（n），然后再跳到下一行
			// 调用readEmployee每次读取一行内容 循环n次 每次保存内容到数组newStaff中
			Employee[] newStaff = readData(in);
			
			for(Employee e:newStaff)
				System.out.println(e);
		}
	}
	
	private static void writeData(Employee[] employees, PrintWriter out)throws IOException{
		out.println(employees.length);
		
		for(Employee e:employees)
			writeEmployee(out, e);
	}
	
	public static void writeEmployee(PrintWriter out, Employee e){
		out.println(e.getName() + "|" + e.getSalary());
	}
	
	private static Employee[] readData(Scanner in){
		// 得到数组大小
		int n = in.nextInt();
		in.nextLine();
		
		Employee[] employees = new Employee[n];
		for(int i = 0; i < n; i++)
		{
			employees[i] = readEmployee(in);
		}
		return employees;
	}
	
	public static Employee readEmployee(Scanner in){
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		String name = tokens[0];
		int salary = Integer.parseInt(tokens[1]);
		return new Employee(name, salary);
	}
}
