package sfdc_35_testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_12_Editview extends ReusableMethods {
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
				WebElement View = driver.findElement(By.xpath("//select[@id='fcf']"));
				clickObj(View, "View");
					
			    Select dropdown = new Select(driver.findElement(By.id("fcf")));
			    dropdown.selectByIndex(1);
					
				WebElement EditLink = driver.findElement(By.linkText("Edit"));
				clickObj(EditLink, "EditLink");
				WebElement s3 =driver.findElement(By.id("fname"));
				s3.clear();
				enterText(s3, "viewname", "ViewName");
				System.out.println("Viewname entered in the field");
					
				WebElement firstcolumn = driver.findElement(By.xpath("//select[@id='fcol1']"));
				clickObj(firstcolumn, "firstcolumn");
					
				WebElement fields = driver.findElement(By.xpath("//select[@id='fcol1']"));
				Select accfield = new Select(driver.findElement(By.xpath("//select[@id='fcol1']")));
				accfield.selectByIndex(1);
					
				WebElement AddfieldsOperator = driver.findElement(By.xpath("//select[@id='fcol1']"));
				Select operator = new Select(driver.findElement(By.xpath("//select[@id='fop1']")));
				operator.selectByIndex(3);
					
				WebElement value = driver.findElement(By.id("fval1"));
				value.clear();
				value.sendKeys("<a>");
				/*These statements verifies if the "Last Activity" is availble in the Available Fields
				 * If Last Activity is available under Available Fields, It add the same to Selected Fields
				 * and save the modifications
				 */
				WebElement Available_Fields_dropdown = driver.findElement(By.xpath("//*[@id='colselector_select_0']"));
				Select Available_Fields_dropdown_list = new Select(Available_Fields_dropdown);
				List<WebElement> Available_Fields_dropdown_options = Available_Fields_dropdown_list.getOptions();

				boolean Element_available = false; //using as a reference to validate if the last activity is in available fields dropdown or not
				
				for(int i=0; i<Available_Fields_dropdown_options.size(); i++) {
					if(Available_Fields_dropdown_options.get(i).getText().equals("Last Activity")) {
						Element_available = true;
						WebElement Add_arrow = driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
						Add_arrow.click();
						break;
					}
				}

				/*These statements verifies if the "Last Activity" is availble in the Selected Fields
				 * If Last Activity is available under Selected Fields, save the modifications
				 * 		 */
				if(Element_available = false) {
					WebElement Selected_Fields_dropdown = driver.findElement(By.xpath("//select[@id='colselector_select_1']"));
					Select Selected_Fields_dropdown_list = new Select(Available_Fields_dropdown);
					List<WebElement> Selected_Fields_dropdown_options = Available_Fields_dropdown_list.getOptions();

					for(int i=0; i<Available_Fields_dropdown_options.size(); i++) {
						if(Selected_Fields_dropdown_options.get(i).getText().equals("Last Activity")) {
							break;
						}
					}	
				}
				
				//Clicking on save button
				WebElement Save_button = driver.findElement(By.name("save"));
				Save_button.click();
				driver.close();
				System.out.println("TC12Accounts_Edit_view is completed");
					
				}
}
