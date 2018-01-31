package MapTest;
import java.util.*;

import org.omg.CORBA.SystemException;
public class MapTest {
	public static void main(String[] args) {
		Map<String, Employee> staff = new HashMap<>();
		staff.put("144-25-5464", new Employee("Amy Lee"));
		staff.put("567-24-2546", new Employee("Harry Hacker"));
		staff.put("157-62-7935", new Employee("Gary Cooper"));
		staff.put("456-62-5527", new Employee("Francesca Cruz"));
		
		// print all entries
		System.out.println(staff);
		
		// remove 
		staff.remove("567-24-2546");
		
		staff.put("456-62-5527", new Employee("Frances Miller"));
		
		System.out.println(staff.get("157-62-7935"));
		
		System.out.println(staff);
	}
}
