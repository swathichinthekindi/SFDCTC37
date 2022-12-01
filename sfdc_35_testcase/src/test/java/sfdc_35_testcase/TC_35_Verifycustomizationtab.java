package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_35_Verifycustomizationtab extends ReusableMethods {
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
		 WebElement AllTabs = driver.findElement(By.id("AllTab_Tab"));
		   clickObj(AllTabs, "AllTabs");
		   
		   WebElement Customizetab = driver.findElement(By.xpath("//input[contains(@title,'Customize My Tabs')]"));
		   clickObj(Customizetab, "Customizetab");
		   
		   WebElement Chatter = driver.findElement(By.xpath("//option[@value='Chatter']"));
		   clickObj(Chatter, "Chatter");
		   
		   WebElement leftarrow = driver.findElement(By.className("leftArrowIcon"));
		   clickObj(leftarrow, "leftarrow");
		   
		   WebElement save = driver.findElement(By.xpath("//input[@title='Save']"));
		   clickObj(save, "save");
		   
		   WebElement UserMenu = driver.findElement(By.xpath("//div[@id='userNav']"));
		   
			selectDropdown(UserMenu, "UserMenu");
			
			WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
			clickObj(logout, "logout");
		   
		   Thread.sleep(3000);
		   WebElement Uname1=driver.findElement(By.xpath("//input[@id='username']"));
			enterText(Uname1, "mithun.r@tekarch.com", "UserName");
			WebElement pwd1=driver.findElement(By.xpath("//input[@id='password']"));
			pwd1.clear();
			enterText(pwd1, "Test4321", "Password");
		    WebElement login1 = driver.findElement(By.xpath("//*[@id='Login']"));
		    clickObj(login1, "login");
		   driver.close();
			System.out.println("TC35_CustomTab Executed sucessfully");  
	}
}
		   