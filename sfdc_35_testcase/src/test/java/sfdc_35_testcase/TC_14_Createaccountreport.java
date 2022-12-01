package sfdc_35_testcase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_14_Createaccountreport extends ReusableMethods {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		 WebDriverManager.chromedriver().setup();
//		  WebDriverManager.firefoxdriver().setup();
		  driver =new ChromeDriver();
		  driver.get("https://login.salesforce.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Uname=driver.findElement(By.xpath("//input[@id='username']"));
		enterText(Uname, "nsdg@abc.com", "UserName");
		WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
		pwd.clear();
		enterText(pwd, "Tekarch@123", "Password");
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
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);

				WebElement LastActivity = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
				clickObj(LastActivity, "LastActivity");
				
				WebElement  dropdown = driver.findElement(By.xpath("//img[@id='ext-gen148']"));
				clickObj(dropdown, "dropdown");
				WebElement createddate = driver.findElement(By.xpath("//div[contains(text(),'Created Date')]"));
				clickObj(createddate, "createddate");
				WebElement startdate =  driver.findElement(By.name("startDate"));
				startdate.clear();
				enterText(startdate, "01/04/2019","calenderdata");
				WebElement enddate = driver.findElement(By.name("endDate"));
				enddate.clear();
				enterText(enddate, "03/04/2019", "calenderdata");
				WebElement save = driver.findElement(By.xpath("//button[@id='ext-gen49']"));
				save.click();
				WebElement Reportnames =  driver.findElement(By.name("reportName"));
				Reportnames.clear();
				enterText(Reportnames, "Accountreports", "ChangeReportName");
				WebElement ReportUniName =  driver.findElement(By.id("saveReportDlg_DeveloperName"));
				ReportUniName.clear();
				enterText(ReportUniName, "Accountreports", "ChangeReportUniqueName");
				Thread.sleep(4000);
			    WebElement Saveandrun = driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']"));
				clickObj(Saveandrun, "Saveandrun");
				driver.close();
				System.out.println("TC_14_Createaccountreport is completed");
	}
}
