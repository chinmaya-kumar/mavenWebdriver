package pkg_one;

public class class_one {
	
	public static int i=10;
	private static String str="Hello";
	protected static double d=30.40;
	static char c='s';

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Testing_pub();
	Testing_pri();
	Testing_pro();
	Testing_Nomod();
		

	}

	public static void Testing_pub(){
		System.out.println("Testing_Pub() executed.");
		System.out.println("public data "+i);
		System.out.println("private data "+str);
		System.out.println("protected data "+d);
		System.out.println("no acces data "+c);
	}
	private static void Testing_pri(){
		System.out.println("Testing_Pri() executed.");
		
	}
	protected static void Testing_pro(){
		System.out.println("Testing_Pro() executed.");
		
	}
	static void Testing_Nomod(){
		System.out.println("Testing_Nomod() executed.");
		
	}
}