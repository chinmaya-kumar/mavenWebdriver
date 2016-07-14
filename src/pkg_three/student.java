package pkg_three;

public class student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student std1=new student("alex");//object created with value
		//student std2=new student("John");
	}
	
	public student(String name){//constructor
		String stdname=name;
		System.out.println("Student name is "+stdname);
	}
}
