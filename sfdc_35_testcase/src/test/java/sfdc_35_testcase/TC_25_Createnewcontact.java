package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_25_Createnewcontact extends ReusableMethods {
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
		
		WebElement new_Element = driver.findElement(By.xpath("//input[contains(@title,'New')]"));
		clickObj(new_Element, "new_Element");
		WebElement first_name = driver.findElement(By.xpath("//input[@id='name_firstcon2']"));	
		enterText(first_name, "Deekshith", "FirstName");
		WebElement last_name = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));	
		enterText(last_name, "NS", "LastName");
		WebElement account_name = driver.findElement(By.xpath("//input[@id='con4']"));	
		enterText(account_name, "Trade", "Accountname");
		
	    WebElement save = driver.findElement(By.xpath(" //td[@id='bottomButtonRow']//input[@title='Save']"));
	    clickObj(save, "SaveButton");
			 
		driver.close();
		System.out.println(" TC_25_Createnewcontact is completed");
	}
}
			 
