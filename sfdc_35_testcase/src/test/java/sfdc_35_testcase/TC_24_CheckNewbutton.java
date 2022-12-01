package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_24_CheckNewbutton extends ReusableMethods {
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
		
		WebElement Leads = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		clickObj(Leads, "Leads"); 
		WebElement LeadSelect = driver.findElement(By.xpath("//select[@id='fcf']"));
		clickObj(LeadSelect, "LeadSelect");
		Thread.sleep(3000);
		WebElement New = driver.findElement(By.xpath("//input[@title='New']"));
		clickObj(New, "New");
		
		WebElement LeadStatus = driver.findElement(By.xpath("//select[@id='lea13']"));
		clickObj(LeadStatus, "LeadStatus");
		
		//Select dropdown  = new Select(driver.findElement(By.xpath("//select[@id='lea13']")));
		SelectByValue(LeadStatus, "Open - Not Contacted");
		
		
		WebElement LastName = driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		enterText(LastName, "mithun", "LastName");
		
	
		WebElement Company = driver.findElement(By.xpath("//input[@id='lea3']"));
		enterText(Company, "welsfargo", "companyname");
		
		WebElement SaveButton = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		clickObj(SaveButton, "SaveButton");
		Thread.sleep(2000);
		driver.close();
		System.out.println(" TC24_NewLeads is completed");
	}
}