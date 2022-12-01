package sfdc_35_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_4_A_ForgotPassword extends ReusableMethods {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
//		  WebDriverManager.firefoxdriver().setup();
		  driver =new ChromeDriver();
		  driver.get("https://login.salesforce.com");
		  driver.manage().window().maximize();
		WebElement Uname=driver.findElement(By.xpath("//input[@id='username']"));
		enterText(Uname, "ramya@kopp.com", "UserName");
		WebElement Fpwd= driver.findElement(By.xpath("//*[@id='forgot_password_link']"));
		   clickObj(Fpwd,"ForgotPassword");
		   WebElement Fname=driver.findElement(By.xpath(".//*[@id='un']"));
		   enterText(Fname, "mithun.r@tekarch.com", "UserName");
		   WebElement contnue=driver.findElement(By.xpath("//*[@id='continue']"));
		   clickObj(contnue,"Continue");
		
	}

}
