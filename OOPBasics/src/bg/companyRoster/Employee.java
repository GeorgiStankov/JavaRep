package bg.companyRoster;

public class Employee implements Comparable<Employee> {
	private String name;
	private double salary;
	private String position;
	private String department;
	private String email;
	private int age;
	
	public Employee(String name, double salary, String position, String department, String email, int age) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
		this.email = email;
		this.age = age;
	}
	public Employee(String name, double salary, String position, String department) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
		this.email = "n/a";
		this.age = -1;
	}
	public Employee(String name, double salary, String position, String department, String email) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
		this.email = email;
		this.age = -1;
	}
	public Employee(String name, double salary, String position, String department, int age) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
		this.email = "n/a";
		this.age = age;
	}
	public String toString(){
		return String.format("%s %.2f %s %d ",name,salary,email,age);
		
	}
	@Override
	public int compareTo(Employee employee) {
		
		return Double.compare(employee.salary,this.salary);
	}
	
  
	

}
