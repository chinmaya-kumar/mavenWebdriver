

public class array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//array initializition
		
		//String[][] data=new String[5][5];
		
		String menuitems = "Setup|Enterprise Setup|Location Setup|IMS Menu|IH Menu|Calendar Menu";
		//String menuitems = "";
		
		
		
		String Menu_Names[] = menuitems.split("\\|");
				
		int Menu_Count = Menu_Names.length;
		
		String Parent_Menu="null";
		String Second_Menu="null";
		String Third_Menu="null";
		String Four_Menu="null";
		String Five_Menu="null";
		String Six_Menu="null";
		
		if(Menu_Names[0]==""){
			System.out.println("Menu item parameters are missing.");
			return;
		}
			
		int item = 0;
		while(Menu_Count>0){
			
			if(item==0){
				
				Parent_Menu = Menu_Names[item];
				System.out.println(Menu_Names[item]);
				System.out.println("1st item clicked");
				
			}
			if(item==1){
				
				Second_Menu = Menu_Names[item];
				System.out.println(Parent_Menu+">>"+Menu_Names[item]);
				System.out.println("2nd item clicked");
				
			}
			if(item==2){
				
				Third_Menu = Menu_Names[item];
				System.out.println(Parent_Menu+">>"+Second_Menu+">>"+Menu_Names[item]);
				System.out.println("3rd item clicked");
				
			}
			if(item==3){
				
				Four_Menu = Menu_Names[item];
				System.out.println(Parent_Menu+">>"+Second_Menu+">>"+Third_Menu+">>"+Menu_Names[item]);
				System.out.println("4th item clicked");
				
			}
			if(item==4){
				
				Five_Menu = Menu_Names[item];
				System.out.println(Parent_Menu+">>"+Second_Menu+">>"+Third_Menu+">>"+Four_Menu+">>"+Menu_Names[item]);
				System.out.println("5th item clicked");
				
			}
			if(item==5){
				
				Six_Menu = Menu_Names[item];
				System.out.println(Parent_Menu+">>"+Second_Menu+">>"+Third_Menu+">>"+Four_Menu+">>"+Five_Menu+">>"+Menu_Names[item]);
				System.out.println("6th item clicked");
				
			}
			
			Menu_Count--;
			item++;
		}

	}
	
	
}
