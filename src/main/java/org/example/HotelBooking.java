package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HotelBooking {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        Thread.sleep(5000);
        actions = new Actions(driver);
        driver.get("https://www.phptravels.net/home");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
        wait = new WebDriverWait(driver, 30);
    }
    //Search For Hotel
    @Test(enabled = true, priority = 0)
    public void SearchHotel() throws InterruptedException {
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='s2id_autogen1']//a[@class='select2-choice']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='s2id_autogen1']//a[@class='select2-choice']"))).sendKeys("Hyderabad india");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='checkin']"))).sendKeys("1/09/2020");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='checkout']"))).sendKeys("3/09/2020");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'col o2')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'col o2')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[contains(@name,'HOTELS')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]"))).click();

    }
    //HotelList
    @Test(enabled = true, priority = 1)
    public void Hotellist() throws InterruptedException{
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[contains(@name,'HOTELS')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]"))).isDisplayed();
    }

    //Login
    @Test(enabled = true ,priority = 2)
    public void Login() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dropdown-item active tr']"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Email')]"))).sendKeys("user@phptravels.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-md-6 bg-white-shadow pt-25 ph-30 pb-40']//div[2]//label[1]//input[1]"))).sendKeys("demouser");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='custom-control-label']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']"))).isDisplayed();

    }
    @Test(enabled = true, priority = 3)
    public void Myprofile() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'My Profile')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'My Profile')]"))).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']"))).sendKeys("Nagesh@123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Confirm Password']"))).sendKeys("Nagesh@123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='City']"))).sendKeys("Hyderabad");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='State/Region']"))).sendKeys("Telangana");
        
    }


    @AfterClass
    public void Exit()  {

        driver.quit();
    }


}
