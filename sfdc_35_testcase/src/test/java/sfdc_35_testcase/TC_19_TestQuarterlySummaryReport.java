package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_19_TestQuarterlySummaryReport extends ReusableMethods {
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
		WebElement Opportunities = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		clickObj(Opportunities, "Opportunities");
		WebElement Interval = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		clickObj(Interval, "Interval");
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		selectByVisibleText(dropdown,"Next FQ");
		
		WebElement include = driver.findElement(By.xpath("//select[@id='open']"));
		//clickObj(include, "include");
		
		//WebElement Dropdown1 = driver.findElement(By.xpath("//select[@id='open']"));
		selectByVisibleText(include, "Open Opportunities");
		
		WebElement RunReport = driver.findElement(By.xpath("//input[@title='Run Report']"));
		clickObj(RunReport, "RunReport");
		driver.close();
		System.out.println("TC_19_TestQuarterlySummaryReport is completed");
	}
}
