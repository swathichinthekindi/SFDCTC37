package sfdc_35_testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_11_Createnewview extends ReusableMethods {
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
				//Creating New View
				WebElement CreateNewView = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
				CreateNewView.click();
				System.out.println("Clicked on Create New View..");
				
				WebElement ViewName = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
				ViewName.clear();
				ViewName.sendKeys("hhhhh");
				
				String value = driver.findElement(By.xpath("//*[@id=\"fname\"]")).getAttribute("value");
				System.out.println(value);
				
				WebElement ViewUniqueName = driver.findElement(By.xpath("//*[@id=\"devname\"]"));
				ViewUniqueName.clear();
				ViewUniqueName.sendKeys("h");
				
				WebElement Save = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
				Save.click();
				System.out.println("Clicked on save button"); 

				WebElement dropdown = driver.findElement(By.className("title"));
				dropdown.click();
				Select dropdown_options = new Select(dropdown);
				List<WebElement> options = dropdown_options.getOptions();
				
				for(int i=0; i<options.size(); i++) {
					if(options.get(i).getText().equals(value)) {
						System.out.println("Account name is displayed in the dropdown");
					}
				}
				System.out.println("TC_11_Createnewview is completed");
				driver.close();
			}
}