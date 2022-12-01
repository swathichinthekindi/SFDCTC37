package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_10_CreateanAccount extends ReusableMethods {
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
		//Opening Accounts page
				WebElement Accounts_Tab = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
				Accounts_Tab.click();
				System.out.println("Clicked on Accounts Ta..");
				
				//Creating New Account
				WebElement New = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
				New.click();
				System.out.println("Clicked on New tab..");
				WebElement AccountName = driver.findElement(By.id("acc2"));
				AccountName.clear();
				AccountName.sendKeys("Accountss");
				WebElement selecttype = driver.findElement(By.xpath("//select[@id='acc6']"));
				Select select = new Select(selecttype);
				select.selectByVisibleText("Technology Partner");
				WebElement  coustomerpriority = driver.findElement(By.xpath("//select[@id='00N0o00000Fy3l4']"));
				Select select1 = new Select(coustomerpriority);
				select1.selectByVisibleText("High");
				WebElement Save = driver.findElement(By.name("save"));
				Save.click();
				System.out.println("Clicked on Save button..");
				System.out.println("Tc_10_create account is completed");
				

}
}
