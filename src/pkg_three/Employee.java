package pkg_three;

public class Employee {

	String EmpFname;
	String EmpLname;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Employee emp=new Employee("Alex");
		Employee emp2=new Employee("Lancy","Jully");
		
	}

	public Employee(String fname){
		EmpFname =fname;
		System.out.println("1. Emp First Name is "+fname);
	}
	
	public Employee(String fname,String lname){
		this("Jim");
		EmpFname=fname;
		EmpLname=lname;
		System.out.println("2.Emp Firts Name is "+fname);
		System.out.println("2.Emp Last Name is "+lname);
	}
}

