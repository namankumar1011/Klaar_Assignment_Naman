package TestWorkspaceSettings;

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

public class TestScenario3 {
	
	private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
	
    @Test
    public void testDeleteWorkspaceLogo() {
        // Navigate to a website
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
    	driver.findElement(By.xpath("//a[@class='centert']")).click();
    	
    	//custom field link
    	driver.findElement(By.xpath("(//div[@class='ant-tabs-tab-btn'])[3]")).click();
    	
    	//add field button
    	WebElement add_field_button=driver.findElement(By.xpath("(//button[@class='ant-btn tw-mr-4 ant-btn-primary'])[1]"));
    	add_field_button.click();
    	
    	WebElement name_input= driver.findElement(By.xpath("(//input[@class='tw-rounded-md ant-input ng-tns-c184-687 ng-pristine ng-invalid ng-touched'])[1]"));
    	name_input.sendKeys("ntest");
    	
    	WebElement field_type= driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input ng-pristine ng-valid ng-touched'])[1]"));
    	Select obj=new Select(field_type);
    	obj.selectByVisibleText("Date");
    	
    	//add custom field button
    	driver.findElement(By.xpath("(//button[@class='ant-btn tw-mr-6 modal-ok-button tw-bg-purple4 tw-border-purple4 ant-btn-primary ng-star-inserted'])[1]")).click();
    	
    	
    	
    	add_field_button.click();
    	
    	name_input.sendKeys("ntest2");
    	
    	
    	obj.selectByVisibleText("List");
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='ng-star-inserted'])[4]")));
    	WebElement add_list_item_button=driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[4]"));
    	add_list_item_button.click();
    	add_list_item_button.click();
    	
    	//adding list items
    	driver.findElement(By.xpath("(//input[@class='tw-w-40 tw-rounded-lg ant-input ng-pristine ng-valid ng-touched'])[1]")).sendKeys("li1");
    	driver.findElement(By.xpath("(//input[@class='tw-w-40 tw-rounded-lg ant-input ng-pristine ng-valid ng-touched'])[2]")).sendKeys("li2");
    	driver.findElement(By.xpath("(//input[@class='tw-w-40 tw-rounded-lg ant-input ng-pristine ng-valid ng-touched'])[3]")).sendKeys("li3");
    	
    	
    	
    	//add custom field button
    	driver.findElement(By.xpath("(//button[@class='ant-btn tw-mr-6 modal-ok-button tw-bg-purple4 tw-border-purple4 ant-btn-primary ng-star-inserted'])[1]")).click();
    	
    	
    	//delete button
    	driver.findElement(By.xpath("(//*[name()='svg'])[15]")).click();
    }
    
	@AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
	
}
