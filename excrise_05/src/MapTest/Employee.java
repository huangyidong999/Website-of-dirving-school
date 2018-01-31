package MapTest;

public class Employee {
	private String name;
	
	public Employee(String string) {
		// TODO Auto-generated constructor stub
		this.name = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return this.name;
	}
	
}
