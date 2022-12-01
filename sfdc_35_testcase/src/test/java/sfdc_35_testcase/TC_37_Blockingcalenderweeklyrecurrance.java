package sfdc_35_testcase;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_37_Blockingcalenderweeklyrecurrance  extends ReusableMethods {
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
		WebElement Home = driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]"));
		clickObj(Home, "Home");
		Thread.sleep(2000);
		WebElement datelink = driver.findElement(By.xpath("//span[@class='pageDescription']/a[1]"));
		clickObj(datelink, "datelink");
		WebElement time =driver.findElement(By.linkText("4:00 PM"));
		clickObj(time,"time");
		driver.findElement(By.xpath("//img[@title='Subject Combo (New Window)']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		driver.findElement(By.xpath("//a[@href='javascript:pickValue(4);']")).click();
		// driver.switchTo().defaultContent();
		driver.switchTo().window(currentHandle);
		Thread.sleep(2000);
		WebElement endtime=driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		clickObj(endtime,"endtime");
		WebElement recurr=driver.findElement(By.id("IsRecurrence"));
		clickObj(recurr,"recurrence");
		WebElement rectyp=driver.findElement(By.id("rectypeftw"));
		clickObj(rectyp, "reccurencetype");
		WebElement recendtime=driver.findElement(By.name("RecurrenceEndDateOnly"));
		recendtime.sendKeys("03/03/2019");
		WebElement save=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
		clickObj(save,"save");
		driver.close();
		System.out.println("TC37_BlockingAnEvent_Calendar_WeeklyRecurring is done");
		}
		}
