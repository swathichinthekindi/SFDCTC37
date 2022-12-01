package sfdc_35_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_3_CheckRemeberMe extends ReusableMethods {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		 WebDriverManager.chromedriver().setup();
//		  WebDriverManager.firefoxdriver().setup();
		  driver =new ChromeDriver();
		  driver.get("https://login.salesforce.com");
		  driver.manage().window().maximize();
		WebElement Uname=driver.findElement(By.xpath("//input[@id='username']"));
		enterText(Uname, "kishorkh@tekarch.com", "UserName");
		WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
		pwd.clear();
		enterText(pwd, "kishor@007", "Password");
		WebElement remember=driver.findElement(By.xpath("//*[@id='rememberUn']"));
		//remember.click();
		selectCheckBox(remember, "RememberMe");
	    WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	    clickObj(login, "login");
	    String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("User is on home page");
		else
			System.out.println("home page is not Lunched");
		WebElement UserMenu = driver.findElement(By.xpath("//*[@id='userNavButton']"));
		//UserMenu.click();
		selectDropdown(UserMenu, "UserMenu");
		//UserMenu.click();
		//Thread.sleep(3000);
		WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		WebDriverWait wait=new WebDriverWait(driver, 50);
	    wait.until(ExpectedConditions.visibilityOf(logout));

		clickObj(logout, "logout");
	    //Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='idcard-identity']")));
		String actualTitle1 = driver.findElement(By.xpath("//span[@id='idcard-identity']")).getText();
		String expectedTitle1="kishorkh@tekarch.com";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
			System.out.println("Username is displayed");
		else
			System.out.println("Username is not displayed");
		driver.close();
		System.out.println("TC_3 Check RemeberMe completed");
	}
}
