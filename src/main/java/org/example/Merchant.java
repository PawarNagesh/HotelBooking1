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

import java.util.ArrayList;

public class Merchant {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public static void main(String[] args) {

    }
    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        actions=new Actions(driver);
        driver.get("https://dev.merchant.incashme.com/ua/login");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
        wait= new WebDriverWait(driver,30);
    }
    //Terms & Condition and Privacy Policy
    @Test(enabled =false, priority=0)
    public void TermsCondition() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Terms & conditions')]")).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
        Thread.sleep(5000);
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        driver.close();
        driver.switchTo().window(tabs1.get(0));
    }

    //ForgotPassword
    @Test(enabled =false, priority=1)
    public void ForgotPassword() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[5]//form[1]//div[2]//div[1]//a[1]")).click(); // Back to Login
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[5]//form[1]//div[1]//input[1]")).sendKeys("pnagesh12@mailinator.com"); // Enter Email Id
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='login-button not-allowd text-right mb10 enbl-lgn']//button[@class='btn lgn-btn'][text()='Submit']")).click(); // Submit Button
        Thread.sleep(9000);
        driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success']")).click(); // OK Pop-Up Button
        Thread.sleep(9000);
        driver.findElement(By.xpath("//div[@class='form-group bmd-form-group']//input[@class='form-control ng-untouched ng-pristine ng-invalid']")).sendKeys("91752");
        Thread.sleep(9000);
        // driver.findElement(By.xpath("//a[@class='color-green']")).click(); //ResendOTP
        // driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success']")).click(); // OK Pop-Up Button
        driver.findElement(By.xpath("//div[@class='login-button not-allowd text-right mb10 mt40 enbl-lgn']//button[@class='btn lgn-btn'][text()='Submit']")).click(); // Submit Button
        Thread.sleep(9000);
        driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success']")).click(); // Success Ok Button
        Thread.sleep(5000);
    }

   //Login
    @Test(enabled =true, priority=2)
    public void Login() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("pnagesh12@mailinator.com"); //devmer06@mailinator.com
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Nagesh@19");  //Test@123
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn lgn-btn']")).click();
    }
    //Home dashboard
    @Test(enabled = true, priority = 3)
    public void Home() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Amount...']"))).sendKeys("23");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn float-right']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']//span[contains(text(),'×')]"))).click();
    }
    //Invoice
    @Test(enabled = false, priority = 4)
    public void Invoice() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-auth-sidebar//li[2]//a[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Received']//a[@class='btn bg-teal w-100 fs-16 rounded-0'][contains(text(),'Create New Invoice')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']"))).sendKeys("9494028007");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Mo- 9XXXXX8007')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='00.00']"))).sendKeys("2.5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='msg']"))).sendKeys("I have end the invoice to above number");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-pink w-100 fs-20']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green w-100 fs-20']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-pink']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green w-100 fs-20']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='send-mny']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //div[@class='modal fade chngps-popup in show']//button[contains(text(),'Back to Home')]"))).click();
    }
    //Transaction History
    @Test(enabled = true, priority = 4)
    public  void Transaction() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-auth-sidebar//li[3]//a[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control form-control-sm']"))).sendKeys("Consumer Development");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[7]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']//span[contains(text(),'×')]"))).click();
        // consumer
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Consumer']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[7]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green fs-20 w-100']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-pink']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']//span[contains(text(),'×')]"))).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-lgt-gray active']"))).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click();
      //Additional Device
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Additional Device')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[7]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']//span[contains(text(),'×')]"))).click();
      //Merchant
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Merchant']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[7]//button[1]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']//span[contains(text(),'×')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[2]//td[7]//button[1]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']//span[contains(text(),'×')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control form-control-sm']"))).sendKeys("ID-100-000-1243");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control form-control-sm']"))).clear();
        Thread.sleep(5000);
     //Agent
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Agent']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[7]//button[1]"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']//span[contains(text(),'×')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[3]//td[7]//button[1]"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']//span[contains(text(),'×')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control form-control-sm']"))).sendKeys("tarun second");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control form-control-sm']"))).clear();
        Thread.sleep(5000);
     //Withdraw
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Withdrawal Status')]"))).click();
        Thread.sleep(4000);
     //Filter
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'All')]"))).click();
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='filter-slider-js']"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("from_amount"))).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("to_amount"))).sendKeys("100");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//my-date-picker[@id='date_begin']//input[@placeholder='Choose Date']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='headerlabelbtn monthlabel']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='monthtable']//tr[1]//td[3]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'21')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//my-date-picker[@id='date_end']//input[@placeholder='Choose Date']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='markcurrday']"))).click();
        Actions actions;
        actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("desc_detail"))).build().perform();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='btn-loader-txt']"))).click();
        Thread.sleep(5000);
    }
    //Statement
    @Test(enabled = true, priority = 5)
    public void Statement() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-auth-sidebar//li[4]//a[1]"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='trst-filter']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Jan')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='m_reset_btn text-center']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='dp-calendar-nav-left']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dp-calendar-nav-container-right']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Feb')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='m_reset_btn text-center']"))).click();
    }
    //Balance
    @Test(enabled = true, priority = 6)
    public void Balance() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[5]//a[1]"))).click();
        Thread.sleep(2000);
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'blnc-txt')]"))).getText());
    }
    //Donation
    @Test(enabled = false, priority = 7)
    public void Donation() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[6]//a[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Requested']//a[contains(text(),'Create New Donation')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName"))).sendKeys("9494028007");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Mo- 9XXXXX8007']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg"))).sendKeys("I Have send the Donation Request to chintu");
        Thread.sleep(5000);
        //Cancel
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-pink w-100 fs-20']"))).click();
        //Send
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green w-100 fs-20']"))).click();
        //Cancel
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-pink']"))).click();
        //Send
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green w-100 fs-20']"))).click();
        //confirm
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='send-mny']"))).click();
        //Back to Home
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mrcnt-make-donation']//button[contains(text(),'Back to Home')]"))).click();
        //Sent
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav nav-tabs']//li[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]//a[1]//div[1]//div[2]//div[3]"))).click();
        //Cancel
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-pink w-100 fs-20']"))).click();
        //Request
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click();
    }
    //Additional device
    @Test(enabled = false, priority = 8)
    public void Device() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[7]//a[1]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fname"))).sendKeys("Patil");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lname"))).sendKeys("Patil");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uname"))).sendKeys("Patil@3457");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cellnum"))).sendKeys("5676543214");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_pin"))).sendKeys("1456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm_pin"))).sendKeys("1456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn prpl-btn brws-file']"))).click();
        Thread.sleep(10000);
        Actions actions;
        actions=new Actions(driver);
        //actions.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"))).build().perform();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Confirm')]"))).click();
        actions.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Add')]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='send-mny']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green cap-txt']"))).click();

    }
    //payment disbursement
     @Test(enabled =true, priority = 9)
     public void payment() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[8]//a[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-white']"))).click();
        Thread.sleep(4000);

    }
    //Profile
    @Test(enabled = true, priority = 10)
    public void Profile() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='prfl-arw']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Withdraw Money')]"))).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Amount...']"))).sendKeys("23");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='layout-container']//li[2]//a[1]//span[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("display_name"))).sendKeys("D K Vasthrpur");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("holder_name"))).sendKeys("Ganesh");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bank_name"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Indusind Bank')]"))).click();
        actions.moveToElement(driver.findElement(By.xpath("//select[@id='bank_account_type']"))).build().perform();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='bank_account_type']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Savings Account')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='bank_account_no']"))).sendKeys("12345678909");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ifsc_no']"))).sendKeys("0000009");
        Thread.sleep(8000);

      }
      //Change Password
        @Test(enabled = false, priority = 11)
        public void Pass() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Change Password')]"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='oldpassword']"))).sendKeys("Nagesh@18");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Nagesh1234");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cnfpwd"))).sendKeys("Nagesh1234");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Submit')]"))).click();
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='swal2-content']"))).getText());
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-danger']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-header pl50']//span[contains(text(),'×')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Change Password')]"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='oldpassword']"))).sendKeys("Nagesh@18");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Nagesh@19");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cnfpwd"))).sendKeys("Nagesh@19");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-success']"))).click();

    }
        //Change-Pin
        @Test(enabled = false, priority = 12)
        public void changepin() throws InterruptedException {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Change Pin')]"))).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldpin"))).sendKeys("7634");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newpin"))).sendKeys("0404");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cnfpin"))).sendKeys("0404");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'CHANGE')]"))).click();
    }

      //Privacy policy
       @Test(enabled = true, priority = 13)
       public void Privacy() throws InterruptedException{
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-auth-header//div[3]//ul[1]//li[1]//a[1]"))).click();
          Thread.sleep(5000);
          ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
          driver.switchTo().window(tabs1.get(1));
          driver.close();
          driver.switchTo().window(tabs1.get(0));


      }
      //Terms and Conditions
        @Test(enabled = true, priority = 14)
        public  void Terms() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile-slide open']//div[3]//ul[1]//li[2]"))).click();
          Thread.sleep(5000);
          ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
          driver.switchTo().window(tabs1.get(1));
          driver.close();
          driver.switchTo().window(tabs1.get(0));
    }
     // KYC & AML Policy
      @Test(enabled = true, priority = 15)
       public  void AML() throws InterruptedException {
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile-slide open']//li[3]"))).click();
          Thread.sleep(5000);
          ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
          driver.switchTo().window(tabs1.get(1));
          driver.close();
          driver.switchTo().window(tabs1.get(0));
      }

     //Login History
     @Test(enabled = true, priority = 16)
     public  void LoginHistory() throws InterruptedException {
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile-slide open']//div[4]//ul[1]//li[1]"))).click();
         Thread.sleep(5000);
            
    }
    //Logout
     @Test(enabled = true, priority = 17)
     public  void Logout() throws InterruptedException {
         Actions actions;
         actions=new Actions(driver);
         actions.moveToElement(driver.findElement(By.xpath("//div[5]//ul[1]//li[1]"))).build().perform();
         Thread.sleep(3000);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]//ul[1]//li[1]"))).click();
         Thread.sleep(5000);
    }

     @AfterClass
    public void Exit()  {

        driver.quit();
    }
}
