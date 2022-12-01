package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_13_Mergeaccounts extends ReusableMethods {
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
				WebElement Mergeacc = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
				clickObj(Mergeacc, "Mergeacc");
				WebElement fb = driver.findElement(By.id("srch"));
				fb.clear();
				enterText(fb, "Accountss", "FindAccounts");
				WebElement FindAcc = driver.findElement(By.name("srchbutton"));
				clickObj(FindAcc, "FindAcc");
				
			    WebElement Button1 = driver.findElement(By.xpath("//input[@id='cid0']"));
			    Radiobutton(Button1, "RadioButton");
			    WebElement Button2 = driver.findElement(By.xpath("//input[@id='cid1']"));
			    Radiobutton(Button2, "RadioButton");
			    WebElement Button3 = driver.findElement(By.xpath("//input[@id='cid2']"));
			    Radiobutton(Button3, "RadioButton");
			    
			    WebElement Next = driver.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Next')]"));
			    Next.click();    
			    WebElement Merge = driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@title='Merge']"));
			    Merge.click();	    
			    switchtoAlert(driver);	
			    driver.close();
			    System.out.println("TC13_MergeAccounts is completed");
				}
	}