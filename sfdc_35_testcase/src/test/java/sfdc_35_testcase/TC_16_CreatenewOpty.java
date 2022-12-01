package sfdc_35_testcase;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_16_CreatenewOpty extends ReusableMethods {
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
		WebElement New_button = driver.findElement(By.xpath("//input[contains(@title,'New')]"));
		clickObj(New_button, "New_button");
		
		WebElement Oppname = driver.findElement(By.id("opp3"));
		Oppname.clear();
		Oppname.sendKeys("ABCD");
		
		//WebElement AccNameOpp = driver.findElement(By.xpath("//input[@id='opp4']"));
		//AccNameOpp.sendKeys("Workday123");
		
		WebElement LookupWindow = driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']"));
		LookupWindow.click();
		String oldWindow = driver.getWindowHandle();
		//Switching driver control to new window.
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[1]);
		
		Thread.sleep(3000);
		
		//switch to first frame
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("abc456");
		driver.findElement(By.xpath("//input[@name='go']")).click();
		
		//Switching to Lookup Window
		driver.switchTo().defaultContent();
		
		//Switching to Insideframe(result)
		
		driver.switchTo().frame("resultsFrame");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tr[@class='dataRow even last first']/th/a")).click();
		
		driver.switchTo().window(getWindow[0]);
		
		Thread.sleep(2000);
		
		//Coming out of the window to original window.
		driver.findElement(By.xpath("//input[@id='opp9']")).click();
	WebElement today=driver.findElement(By.xpath("//a[@class='calToday']"));
		today.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		WebElement Stage = driver.findElement(By.xpath("//select[@id='opp11']"));
		Stage.click();
		
		Select dropdown = new Select(Stage);
		dropdown.selectByValue("Qualification");
		driver.findElement(By.xpath("//input[@id='opp12']")).sendKeys("80");
		driver.close();
		System.out.println("TC16_CreatenewOpp is completed");
	}
	}
