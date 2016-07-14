import javax.swing.JOptionPane;


public class test {

	public static void main(String[] args) {
		
		String first_name;
		first_name = JOptionPane.showInputDialog("XML File Path For Module : 1 ");
		
		String family_name;
		family_name = JOptionPane.showInputDialog("XML File Path For Module : 2 ");
		
		String full_name;
		full_name = "You are " + first_name + " " + family_name;
		
		JOptionPane.showMessageDialog( null, full_name );

	}

}
