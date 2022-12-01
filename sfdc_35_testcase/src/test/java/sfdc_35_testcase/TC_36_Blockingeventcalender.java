package sfdc_35_testcase;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_36_Blockingeventcalender extends ReusableMethods {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		 WebDriverManager.chromedriver().setup();
//		  WebDriverManager.firefoxdriver().setup();
		  driver =new ChromeDriver();
		  driver.get("https://login.salesforce.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Uname=driver.findElement(By.xpath("//input[@id='username']"));
		enterText(Uname, "akshay.tekarch@gmail.com", "UserName");
		WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
		pwd.clear();
		enterText(pwd, "test@123", "Password");
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
		
		WebElement Time = driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]"));
		clickObj(Time, "Time");
		
//		WebElement lookup = driver.findElement(By.className("comboboxIcon"));
//		lookup.click();
		
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
		WebElement Date = driver.findElement(By.xpath("//input[@id='EndDateTime']"));
		Date.sendKeys("7/5/2020");;
		driver.findElement(By.xpath("//img[contains(@class,'calRight')]")).click();
		WebElement pickingdate= driver.findElement(By.xpath("//tr[@id='calRow2']//td[contains(@class,'weekday')][contains(text(),'6')]"));
		pickingdate.click();
		
		WebElement endtime=driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		clickObj(endtime,"endtime");
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).click();
		driver.findElement(By.xpath("//div[@id='timePickerItem_42']")).click();
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']")).click();
		driver.close();
		System.out.println("TC36_EventinCalender Executed sucessfully");   
	}
}

