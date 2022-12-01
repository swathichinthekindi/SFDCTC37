package sfdc_35_testcase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_4_B_ForgotPassword extends ReusableMethods {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
//		  WebDriverManager.firefoxdriver().setup();
		  driver =new ChromeDriver();
		  driver.get("https://login.salesforce.com");
		  driver.manage().window().maximize();
		WebElement Uname=driver.findElement(By.xpath("//input[@id='username']"));
		enterText(Uname, "mithun.r@tekarch.com", "UserName");
		WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
		pwd.clear();
		enterText(pwd, "Test1234", "Password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	    clickObj(login, "login");
	    String actualText = driver.findElement(By.xpath("//div[@id='error']")).getText();
		driver.manage().window().maximize();
		String expectedText = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		/*
		 * if(actualText.equalsIgnoreCase(expectedText))
		 * System.out.println("Error message Displayed"); else
		 * System.out.println("Error message not Displayed please check the application"
		 * );
		 */
		assertEquals(actualText.toLowerCase(), expectedText.toLowerCase(),"print failed message");
		System.out.println("TC_4_B_Forgot password completed");
		//driver.close();
	}
	

}
