import javax.swing.*;

public class JOptionPaneMultiInput {
   public static void main(String[] args) {
      JTextField xField = new JTextField(20);
      JTextField yField = new JTextField(20);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("XML File 1 :"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("XML File 2 :"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
    	  String path = xField.getText();
    	  System.out.println("Path is : "+path);
         System.out.println("File 1 is: " + xField.getText());
         System.out.println("File 2 is: " + yField.getText());
         JOptionPane.showMessageDialog(null, "File paths are : "+xField.getText()+" and "+yField.getText());
      }
   }
}