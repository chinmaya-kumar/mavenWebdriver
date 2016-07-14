
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;


public class safari_test {
	
	public static void main(String[] args) {
		
		String path ="[[InternetExplorerDriver: internet explorer on WINDOWS (42a9009d-c084-44b0-8faf-65e27efd3852)] -> id: btnLogin]";
		
		//String tempPath;
		
		//tempPath=path.replace("test-output/html/", "");
		//System.out.println(tempPath);
	
		String[] parts = path.split("->");
		String part2 = parts[1];
		String obValue = part2.replace("]", "");
		System.out.println(obValue);
		

	}

	
}
