package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_9_SelectLogout  extends ReusableMethods {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
	 WebDriverManager.chromedriver().setup();
//	  WebDriverManager.firefoxdriver().setup();
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
	if(actualTitle.equalsIgnoreCase(expectedTitle))
		System.out.println("User is on home page");
	else
		System.out.println("home page is not Lunched");
	WebElement usermenu1=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
	usermenu1.click(); 
	driver.findElement(By.linkText("Logout")).click();
	String	expectedUrl1 = driver.getCurrentUrl();
	String	actualUrl1 = "https://login.salesforce.com/";
		
	if(actualUrl1.equalsIgnoreCase(expectedUrl1)) {
			System.out.println("User is not in login page");
	}
		else {
			System.out.println("User is on login page");
		}
	driver.close();
	{

}
	}
}
