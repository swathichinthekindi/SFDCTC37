package sfdc_35_testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_21_leadsSelectView extends ReusableMethods {
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
		Select view = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));

	    //Get all options
	    List<WebElement> vew = view.getOptions();

	    //Get the length
	    System.out.println(vew.size());

	    // Loop to print one by one
	    for (int j = 0; j < vew.size(); j++) {
	        System.out.println(vew.get(j).getText());

	    }
	    driver.close();
		System.out.println("TC21_LeadsSelectView is completed");	
		
	}

}
