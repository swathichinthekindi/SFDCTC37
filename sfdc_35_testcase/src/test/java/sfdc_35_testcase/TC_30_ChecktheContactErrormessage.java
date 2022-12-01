package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_30_ChecktheContactErrormessage extends ReusableMethods {
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
		WebElement Createnewview = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		clickObj(Createnewview, "Createnewview");
		WebElement Uniquename = driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(Uniquename, "abc456" , "UniqueName");
		WebElement Save = driver.findElement(By.name("save"));
		Save.click();
		String actualmsg = driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]")).getText();
		String errormsg = "Error: You must enter a value";
		validateErrormsg(actualmsg, errormsg);
		driver.close();
		System.out.println("TC_30_ChecktheContactErrormessage is Completed");
		
	}
}