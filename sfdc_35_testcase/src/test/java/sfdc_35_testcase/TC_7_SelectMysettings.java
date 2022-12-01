package sfdc_35_testcase;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_7_SelectMysettings extends ReusableMethods {
	static WebDriver driver;
	static String downloadPath = "C:\\Users\\admin\\Downloads";
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
		WebElement UserMenu = driver.findElement(By.xpath("//*[@id='userNavButton']"));
		UserMenu.click();
		String dropdownverify=driver.findElement(By.xpath("//div[@id='userNav-menuItems']")).getText();
		System.out.println(dropdownverify);
		WebElement MySettings = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		MySettings.click();
		String expectedUrl = driver.getCurrentUrl();
		String actualUrl = "https://ap8.salesforce.com/ui/setup/Setup?setupid=PersonalSetup";
		if(actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("User is on MySettings page");
		}
		else {
			System.out.println("MySettings page is not Lunched");
		}
		//Personal and Login History
				WebElement Personal = driver.findElement(By.xpath("//*[@id=\"PersonalInfo_font\"]"));
				Personal.click();
				WebElement LoginHistory = driver.findElement(By.xpath("//*[@id=\"LoginHistory_font\"]"));
				LoginHistory.click();
				//downloading .csv file
				WebElement LoginHistory6Months= driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a"));
				LoginHistory6Months.click();
				File getLatestFile = getLatestFilefromDir(downloadPath);
				String fileName = getLatestFile.getName();
				if(isFileDownloaded_Extension(downloadPath, ".csv") == true) {
					System.out.println("file is downloded");
				}
				else {
					System.out.println("file is not downloded");
				}
				WebElement DisplayandLayout = driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_font\"]"));
				DisplayandLayout.click();
				WebElement CustomizeMyTabs = driver.findElement(By.xpath("//*[@id=\"CustomizeTabs_font\"]"));
				CustomizeMyTabs.click();
				
				//dropdown to select salesforce Chatter
				WebElement dropdown = driver.findElement(By.id("p4"));
				Select dropdownOptions = new Select(dropdown); 
				dropdownOptions.selectByVisibleText("Salesforce Chatter");
				Thread.sleep(5000);
				
				//Available Tabs dropdown
				dropdown = driver.findElement(By.id("duel_select_0"));
				dropdownOptions = new Select(dropdown); 
				dropdownOptions.selectByVisibleText("Reports");
				WebElement Add_Arrow = driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img"));
				Add_Arrow.click();
				
				//checking if the selected element is in Selected Tabs dropdown
				dropdown = driver.findElement(By.id("duel_select_1"));
				dropdownOptions = new Select(dropdown); 
				List<WebElement> elements = dropdownOptions.getOptions();
				for(int i=0; i<elements.size(); i++) {
					if(elements.get(i).getText().equals("Reports")) {
						System.out.println("Reports Tab is added");	
					}
					else {
						System.out.println("Reports Tab is  not added");
					}
				}
				
				//Email Tab
				WebElement Email = driver.findElement(By.id("EmailSetup"));
				Email.click();
				WebElement MyEmailSettings = driver.findElement(By.id("EmailSettings_font"));
				MyEmailSettings.click();

				WebElement Email_Name = driver.findElement(By.id("sender_name"));
				Email_Name.clear();
				Email_Name.sendKeys("mithun.r");
				WebElement Email_Address = driver.findElement(By.id("sender_name"));
				Email_Address.clear();
				Email_Address.sendKeys("mithun.r@tekarch.com");
				WebElement Bcc_radioButton = driver.findElement(By.id("auto_bcc1"));
				Bcc_radioButton.click();
				WebElement Save_button = driver.findElement(By.name("save"));
				Save_button.click();		
				
				//Calender & Remainders
				WebElement Calender_and_Reminders = driver.findElement(By.id("CalendarAndReminders"));
				Calender_and_Reminders.click();
				Thread.sleep(5000);
				WebElement ActivityReminders = driver.findElement(By.xpath("//*[@id=\"Reminders_font\"]"));
				ActivityReminders.click();
				Thread.sleep(5000);
				WebElement Test_Reminder = driver.findElement(By.className("btn"));
				Test_Reminder.click();
				Thread.sleep(5000);
				String parentWindow = driver.getWindowHandle();
				for(String handle : driver.getWindowHandles()) { 
					if(handle != parentWindow) {
						driver.switchTo().window(handle);
					String	expectedUrl1 = driver.getCurrentUrl();
					String	actualUrl1 = "https://ap8.salesforce.com/ui/core/activity/ReminderSettingsPage?setupid=Reminders&retURL=%2Fui%2Fsetup%2FSetup%3Fsetupid%3DCalendarAndReminders";
						
					if(actualUrl1.equalsIgnoreCase(expectedUrl1)) {
							System.out.println("MySettings page is not Lunched");
					}
						else {
							System.out.println("User is on MySettings page");
						}	
					}
				}
				driver.close();
				System.out.println("Tc_7_SelectMySettings is completed");
	}
					
				
				
				
			
	
			
			//This method is used to get the latest downloaded file from directory
			public static File getLatestFilefromDir(String dirPath) {
				File dir = new File(downloadPath);
				File[] files = dir.listFiles();
				if(files == null || files.length==0) {
					return null;
				}
				File lastModifiedFile = files[0];
			    for (int i = 1; i < files.length; i++) {
			       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
			           lastModifiedFile = files[i];
			       }
			    }
			    return lastModifiedFile;
			}

			//This method checks the extension of the file downloaded
			public static boolean isFileDownloaded_Extension(String dirPath, String extension) {
				boolean flag = false;
				File dir = new File(downloadPath);
				File[] files = dir.listFiles();
				if(files == null || files.length==0) {
					flag = false;
				}
				for(int i=1; i<files.length; i++) {
					if(files[i].getName().contains(extension)) {
						flag = true;
					}
				}
				return flag;
			}

		//This method is to verify if the file is downloaded or not
				public boolean isFileDownloaded(String downloadPath, String fileName) {
					boolean flag = false;
					File dir = new File(downloadPath);
					File[] dir_contents = dir.listFiles();
				
						for(int i=0; i<dir_contents.length; i++) {
							if(dir_contents[i].getName().equalsIgnoreCase(fileName)) {
							return flag = true;
						}
					}
					return flag;
				}
					
				}
				
