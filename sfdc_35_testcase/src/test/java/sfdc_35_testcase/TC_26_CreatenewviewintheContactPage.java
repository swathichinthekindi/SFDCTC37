package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_26_CreatenewviewintheContactPage extends ReusableMethods {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		 WebDriverManager.chromedriver().setup();
//		  WebDriverManager.firefoxdriver().setup();
		  driver =new ChromeDriver();
		  driver.get("https://login.salesforce.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Uname=driver.findElement(By.xpath("//input[@id='username']"));
		enterText(Uname, "mithun.r@tekarch.com", "UserName");
		WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
		pwd.clear();
		enterText(pwd, "Test4321", "Password");
	    WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	    clickObj(login, "login");
	    String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		System.out.println("User is on home page");
		}
		else {
			System.out.println("home page is not Lunched");
		}
		WebElement contact = driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		clickObj(contact, "contact");
		WebElement Contactnewview = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		clickObj(Contactnewview, "Contactnewview");
		WebElement ViewNames = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(ViewNames, "NSDG" , "ViewName");
		WebElement View_UniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		View_UniqueName.clear();
		enterText(View_UniqueName, "NSDG" , "ViewUniqueName");
		
		WebElement save = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Save']"));
		 clickObj(save, "SaveButton");
		 driver.close();
		 System.out.println("TC_26_CreatenewviewintheContactPage is Completed"); 
		 
	

	}
}