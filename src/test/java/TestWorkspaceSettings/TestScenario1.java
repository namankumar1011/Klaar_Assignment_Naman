package TestWorkspaceSettings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario1 {
	private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    //@Test
    public void testTitle() {
        // Navigate to a website
    	driver.get("https://dev.klaarhq.com/auth/sign_in?returnUrl=%2Fprofile");
    	Assert.assertEquals(driver.getTitle(), "Klaar");
    }
    
    //@Test
    public void testLogin() {
        // Navigate to a website
    	driver.get("https://dev.klaarhq.com/auth/sign_in?returnUrl=%2Fprofile");
//    	Assert.assertEquals(driver.getTitle(), "Klaar");
    	
    	WebElement login_with_klaar_button=driver.findElement(By.xpath("(//div[@class='login-button'])[3]"));
    	login_with_klaar_button.click();
    	
    	WebElement email_phone_no_input = driver.findElement(By.xpath("//input[@placeholder='Enter your email or phone number here']"));
    	email_phone_no_input.sendKeys("deepa.nayak@gamma.klaar.team");
    	
    	WebElement pass_input = driver.findElement(By.xpath("//input[@placeholder='Enter your password here']"));
    	pass_input.sendKeys("Klaar2021");
    	
    	WebElement login_button= driver.findElement(By.xpath("//button[@class='ant-btn loginButton ant-btn-primary']"));
    	login_button.click();
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tw-cursor-pointer tw-text-center tw-bg-blue6 tw-pt-5']")));
    	
    	WebElement logo= driver.findElement(By.xpath("//div[@class='tw-cursor-pointer tw-text-center tw-bg-blue6 tw-pt-5']"));
    	Assert.assertEquals(logo.isDisplayed(), true);
    	
    }
 
    
    
    //@Test
    public void testWorkspaceSettingAppearance() {
        // Navigate to a website
    	driver.get("https://dev.klaarhq.com/auth/sign_in?returnUrl=%2Fprofile");
    	
    	WebElement login_with_klaar_button=driver.findElement(By.xpath("(//div[@class='login-button'])[3]"));
    	login_with_klaar_button.click();
    	
    	WebElement email_phone_no_input = driver.findElement(By.xpath("//input[@placeholder='Enter your email or phone number here']"));
    	email_phone_no_input.sendKeys("deepa.nayak@gamma.klaar.team");
    	
    	WebElement pass_input = driver.findElement(By.xpath("//input[@placeholder='Enter your password here']"));
    	pass_input.sendKeys("Klaar2021");
    	
    	WebElement login_button= driver.findElement(By.xpath("//button[@class='ant-btn loginButton ant-btn-primary']"));
    	login_button.click();
    	
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-sider/div/div/div[1]/div[2]/ul/div[7]/button/li")));
    	
    	
    	WebElement settings_button=driver.findElement(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-sider/div/div/div[1]/div[2]/ul/div[7]/button/li"));
    	settings_button.click();
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-layout/nz-content/div/app-settings/div/div[1]/div/h2")));
    	WebElement workspace_heading = driver.findElement(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-layout/nz-content/div/app-settings/div/div[1]/div/h2"));
    	Assert.assertEquals(workspace_heading.isDisplayed(), true);
    	
    	
    }
    
    //@Test
    public void testAddWorkspaceLogo() {
        // Navigate to a website
    	driver.get("https://dev.klaarhq.com/auth/sign_in?returnUrl=%2Fprofile");
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	
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
    	
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-layout/nz-content/div/app-settings/div/nz-card[3]/div/div/nz-spin/div/nz-upload/div/div/input")));
    	WebElement workspace_logo_area=driver.findElement(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-layout/nz-content/div/app-settings/div/nz-card[3]/div/div/nz-spin/div/nz-upload/div/div/input"));
    	workspace_logo_area.sendKeys("C:/Users/Naman/Desktop/photo.jpg");
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[name()='path' and contains(@d,'M19.35 6.0')]")));
    	WebElement save_button = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M19.35 6.0')]"));
    	save_button.click();
    	
    	
    	WebElement edit_button=driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M17.6478 1')]"));
    	Assert.assertEquals(edit_button.isDisplayed(), true);
    	
    }
    
    //@Test
    public void testEditWorkspaceLogo() {
        // Navigate to a website
    	driver.get("https://dev.klaarhq.com/auth/sign_in?returnUrl=%2Fprofile");
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	
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
    	
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-layout/nz-content/div/app-settings/div/nz-card[3]/div/div/nz-spin/div/nz-upload/div/div/input")));
    	WebElement workspace_logo_edit_area=driver.findElement(By.xpath("//*[@id=\"main-app\"]/app-root/app-layout/nz-layout/nz-layout/nz-content/div/app-settings/div/nz-card[3]/div/div/nz-spin/div/nz-upload/div/div/input"));
    	workspace_logo_edit_area.sendKeys("C:/Users/Naman/Desktop/photo.jpg");
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[name()='path' and contains(@d,'M19.35 6.0')]")));
    	WebElement save_button = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M19.35 6.0')]"));
    	save_button.click();
    	
    	
    	WebElement edit_button=driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M17.6478 1')]"));
    	Assert.assertEquals(edit_button.isDisplayed(), true);
    	
    }
    
    @Test
    public void testDeleteWorkspaceLogo() {
        // Navigate to a website
    	driver.get("https://dev.klaarhq.com/auth/sign_in?returnUrl=%2Fprofile");
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	
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
    	
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[name()='svg'])[12]")));
    	WebElement workspace_logo_delete_area=driver.findElement(By.xpath("(//*[name()='svg'])[12]"));
    	workspace_logo_delete_area.click();
    	
    	
    	Assert.assertEquals(workspace_logo_delete_area.isDisplayed(), false);
    	
    }
    
    
    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
