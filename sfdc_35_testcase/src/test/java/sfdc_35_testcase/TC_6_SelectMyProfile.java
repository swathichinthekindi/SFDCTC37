package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_6_SelectMyProfile extends ReusableMethods {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
//		  WebDriverManager.firefoxdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(Uname, "kishorkh@tekarch.com", "UserName");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		pwd.clear();
		enterText(pwd, "kishor@007", "Password");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickObj(login, "login");
		{
			WebElement UserMenu = driver.findElement(By.xpath("//div[@id='userNav']"));
			selectDropdown(UserMenu, "UserMenu");
			WebElement MyProfile = driver.findElement(By.xpath("//a[@title='My Profile']"));
			clickObj(MyProfile, "MyProfile");
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")));

			// Edit Profile link
			WebElement Editprofile = driver
					.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img"));
			clickObj(Editprofile, "Editlink");
			WebElement profileIframe = driver.findElement(By.id("contactInfoContentId"));
			switchFrame(driver, profileIframe);
			driver.findElement(By.id("aboutTab")).click();
//Thread.sleep(6000);

			WebElement lastname = driver.findElement(By.id("lastName"));
			lastname.clear();

			enterText(lastname, "Kishore", "lastname");
			System.out.println("LastName is Entered");
//WebElement bodyElement=driver.findElement(By.xpath("//div[contains(@class,'zen-body')]"));
			WebElement bodyElement = driver.findElement(By.xpath("//input[@value='Save All']"));
			clickObj(bodyElement, "bodyElement");

//Edit Post link
			Thread.sleep(4000);
			WebElement postlink = driver.findElement(By.id("publisherAttachTextPost"));
			clickObj(postlink, "postlink");

			WebElement postIframe = driver
					.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
			switchFrame(driver, postIframe);
//driver.switchTo().frame(postIframe);
			WebElement postBody = driver.findElement(By.xpath("//html[1]/body[1]"));
			clickObj(postBody, "postBody");
			enterText(postBody, "This is posted Text", "PostText");
			switchdefaultFrame(driver);
			WebElement ShareButton = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
			clickObj(ShareButton, "ShareButton");
			System.out.println("Text Posted is shared");

//Uploading a File
			Thread.sleep(3000);
			WebElement FileLink = driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
			clickObj(FileLink, "FileLink");
			System.out.println("Clicked on filelink");
			WebElement UploadFile = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
			clickObj(UploadFile, "UploadFile");
			System.out.println("clicked on uploadfile button on computer");
			Thread.sleep(3000);
			WebElement choosefile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
			enterText(choosefile, "C:\\Users\\admin\\Desktop\\SFDC 37 Testcases.xlsx", "choosefile");
			System.out.println("choosefile option is selected");
			WebElement Share = driver.findElement(By.id("publishersharebutton"));
			clickObj(Share, "ShareButton");

//Uploading photo
			Thread.sleep(3000);
			WebElement moderator = driver.findElement(By.id("displayBadge"));
//clickObj(AddPhoto, "AddPhoto");
			mouseOver(driver, moderator);
			WebElement AddPhotolink = driver.findElement(By.xpath("//a[@id='uploadLink']"));
			clickObj(AddPhotolink, "AddPhotolink");
			WebElement Iframe = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
			switchFrameid(driver, "uploadPhotoContentId");
			WebElement choosefileoption = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
//clickObj(choosefileoption, "choosefileoption");
			enterText(choosefileoption, "C:\\Users\\admin\\Desktop\\wild.jpg", "choosefileoption");
			WebElement save = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
			clickObj(save, "save");
			driver.close();
			System.out.println("TC06_MyProfile completed successfully");

		}

	}
}
