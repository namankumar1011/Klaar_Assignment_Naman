package TestUserCustomFields;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario2 {
	private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    

    @Test(priority = 1)
    public void navigateToSettingsModule() {
        // Code to navigate to the Settings module
        // Replace the following line with actual navigation code using XPath
        
    	driver.get("https://dev.klaarhq.com/auth/sign_in?returnUrl=%2Fprofile");
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='login-button'])[3]")));
    	WebElement login_with_klaar_button=driver.findElement(By.xpath("(//div[@class='login-button'])[3]"));
    	login_with_klaar_button.click();
    	
    	WebElement email_phone_no_input = driver.findElement(By.xpath("//input[@placeholder='Enter your email or phone number here']"));
    	email_phone_no_input.sendKeys("deepa.nayak@gamma.klaar.team");
    	
    	WebElement pass_input = driver.findElement(By.xpath("//input[@placeholder='Enter your password here']"));
    	pass_input.sendKeys("Klaar2021");
    	
    	WebElement login_button= driver.findElement(By.xpath("//button[@class='ant-btn loginButton ant-btn-primary']"));
    	login_button.click();
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-sider/div/div/div[1]/div[2]/ul/div[7]/button/li")));
    	WebElement settings_button=driver.findElement(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-sider/div/div/div[1]/div[2]/ul/div[7]/button/li"));
    	settings_button.click();
    	
    	//user list link
    	driver.findElement(By.xpath("(//a[@class='centert'])[1]")).click();
    	
    	WebElement searchbar=driver.findElement(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-layout/nz-content/div/app-employees/app-page-container/div/div/nz-tabset/div/div/div[1]/div/div[1]/div[1]/div/div/nz-input-group/input"));
    	Assert.assertEquals(searchbar.isDisplayed(), true);
    	
    	//plus button
    	driver.findElement(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-layout/nz-content/div/app-employees/app-page-container/div/div/nz-tabset/div/div/div[1]/div/div[1]/div[3]/div/button[3]")).click();
    	
    	//add new user button
    	driver.findElement(By.xpath("(//span)[81]")).click();
    	
    	//name input
    	driver.findElement(By.xpath("//input[@placeholder='e.g. Alex Richards']")).sendKeys("ntesting");
    	
    	//email input
    	WebElement email= driver.findElement(By.xpath("//input[@placeholder='e.g. alex@example.com']"));
    	email.sendKeys("abc@gmail.com");
    	
    	//department dropdown
    	WebElement dept_drop=driver.findElement(By.xpath("//input[@class='ant-select-selection-search-input ng-pristine ng-valid ng-touched']"));
    	Select deptobj =new Select(dept_drop);
    	
    	deptobj.selectByIndex(1);
    	
    	WebElement title_drop=driver.findElement(By.xpath("//nz-select-top-control[@class='ant-select-selector ng-tns-c142-316']//input[@class='ant-select-selection-search-input ng-pristine ng-valid ng-touched']"));
    	Select titleobj =new Select(title_drop);
    	
    	titleobj.selectByIndex(1);
    	
    	WebElement manager_drop=driver.findElement(By.xpath("//nz-select-top-control[@class='ant-select-selector ng-tns-c142-318']//input[@class='ant-select-selection-search-input ng-pristine ng-valid ng-touched']"));
    	Select managerobj =new Select(manager_drop);
    	
    	managerobj.selectByIndex(1);
    	
    	//user id 
    	driver.findElement(By.xpath("//input[@placeholder='Enter employee id here']")).sendKeys("1111");
    	
    	//location
    	driver.findElement(By.xpath("//input[@placeholder='Enter location here']")).sendKeys("mohali");
    	
    	
    	WebElement hr_drop=driver.findElement(By.xpath("//nz-select-top-control[@class='ant-select-selector ng-tns-c142-323']//input[@class='ant-select-selection-search-input ng-pristine ng-valid ng-touched']"));
    	Select hrobj =new Select(hr_drop);
    	
    	hrobj.selectByIndex(1);
    	
    	//add button
    	driver.findElement(By.xpath("//*[@id=\"cdk-overlay-16\"]/nz-modal-container/div/div/div/app-modal/div/div[3]/div/span/button")).click();
    	
    	
    	//check landing on edit user page after adding new user
    	WebElement edit_userpage=driver.findElement(By.xpath("//*[@id=\"site-page-header\"]/div/div/nz-page-header-title/span"));
    	Assert.assertEquals(edit_userpage.isDisplayed(), true);
    	
    	//user list link
    	driver.findElement(By.xpath("(//a[@class='centert'])[1]")).click();
    	
    	//for searching newly added user
    	searchbar.sendKeys("abc@gmail.com");
    	
    	WebElement table_row=driver.findElement(By.xpath("//tbody/tr[1]"));
    	Assert.assertEquals(table_row.isDisplayed(), true);
    	
    	
    	
    }


	@AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
