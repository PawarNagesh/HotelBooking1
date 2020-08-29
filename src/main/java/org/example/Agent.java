package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Agent {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        Thread.sleep(5000);
        actions=new Actions(driver);
        driver.get("https://dev.agent.incashme.com/ua/login");
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Forgot Password?']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]//form[1]//div[2]//div[1]//a[1]"))).click(); // Back to Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Forgot Password?')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]//form[1]//div[1]//input[1]"))).sendKeys("testcon045@mailinator.com"); // Enter Email Id
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
    @Test(enabled = true ,priority = 2)
    public void Login() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=\"email\"]:nth-child(3)"))).sendKeys("testagent8@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pwd"))).sendKeys("Nagesh@2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Login']"))).click();

    }

    //Homedashboard
    @Test(enabled = true ,priority = 3)
    public void Homedashbaord () throws InterruptedException {
        //Using Mobile Number
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payeeName"))).sendKeys("9494028007");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='green-txt mb5']"))).click();  //Merchant
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='blue-txt mb5']"))).click();   //Consumer
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).sendKeys("100");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn float-right']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-success']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).clear();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).sendKeys("201");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn float-right']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-red']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn float-right']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green']"))).click();

     //Create consumer
        Thread.sleep(15000);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='btn ftr-btn blue-btn w-100']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Create Consumer"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name"))).sendKeys("Test con");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name"))).sendKeys("Test Five");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btnpicker btnpickerenabled']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='headerlabelbtn yearlabel']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='yearchangebtn mydpicon icon-mydpup yearchangebtnenabled']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'1983')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='headerlabelbtn monthlabel']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Jun')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[2]//td[4]//div[1]//span[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("testconnn006@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys("1394561654");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='profile_pic_select']"))).click();
        Thread.sleep(6000);
        actions.moveToElement(driver.findElement(By.xpath("//button[@id='send-mny']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='send-mny']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='fileType']"))).click();
        Thread.sleep(2000);
        //Passport
        driver.findElement(By.xpath("//option[contains(text(),'Passport')]")).click();
        Thread.sleep(2000);
        // Driving License
        driver.findElement(By.xpath("//option[contains(text(),'Driving License')]")).click();
        Thread.sleep(2000);
        //Voter Id
        driver.findElement(By.xpath("//option[contains(text(),'Voter's Identity Card')]")).click();
        Thread.sleep(2000);
		//Aadhar-Card
		driver.findElement(By.xpath("//option[contains(text(),'Aadhar Card')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='aadhaar_front_select']")).click();
		Thread.sleep(8000);
		actions.moveToElement(driver.findElement(By.xpath("//span[@id='aadhaar_back_select']"))).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='aadhaar_back_select']"))).click();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='step1']//button[contains(text(),'Next')]"))).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='step1']//button[contains(text(),'Next')]"))).click();
		Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Previous']")).click();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='step1']//button[contains(text(),'Next')]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='step1']//button[contains(text(),'Next')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='otp_val']"))).sendKeys("91752");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='step2']//button[contains(text(),'Next')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address1']"))).sendKeys("9/2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address2']"))).sendKeys("Magnet");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address3']"))).sendKeys("corporate park");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='village']"))).sendKeys("Machkal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tehsil']"))).sendKeys("Mudhole");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='district']"))).sendKeys("Nirmal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='state']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Assam')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='city']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Halflong')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='country']"))).sendKeys("India");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pincode']"))).sendKeys("380015");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-blue']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-blue cap-txt']"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='sb_home']//a"))).click();*/

		//Create Merchant
        Thread.sleep(15000);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='btn ftr-btn green-btn w-100']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Create Merchant"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name"))).sendKeys("Test Mer");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name"))).sendKeys("Test Two");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']"))).sendKeys("Test@8765456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btnpicker btnpickerenabled']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='headerlabelbtn yearlabel']"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='yearchangebtn mydpicon icon-mydpup yearchangebtnenabled']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'1983')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='headerlabelbtn monthlabel']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Jun')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[2]//td[4]//div[1]//span[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("testme08877@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys("1117828889");
        /*WebElement chooseFile = driver.findElement(By.xpath("//span[@id='profile_pic_select']"));
        Thread.sleep(5000);
        chooseFile.sendKeys("/Users/pnagu/.lsp4xml/Desktop.jpg");*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='profile_pic_select']"))).click();
        Thread.sleep(6000);
        actions.moveToElement(driver.findElement(By.xpath("//button[@id='send-mny']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='send-mny']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='fileType']"))).click();
        Thread.sleep(2000);
        // Passport->
       /* driver.findElement(By.xpath("//option[contains(text(),'Passport')]")).click();
        Thread.sleep(2000);
        // Driving License
        driver.findElement(By.xpath("//option[contains(text(),'Driving License')]")).click();
        Thread.sleep(2000);
        //Voter Id
        driver.findElement(By.xpath("//option[contains(text(),'Voter's Identity Card')]")).click();
        Thread.sleep(2000);*/
       //Aadhar-Card
        driver.findElement(By.xpath("//option[contains(text(),'Aadhar Card')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='aadhaar_front_select']")).click();
        Thread.sleep(8000);
        actions.moveToElement(driver.findElement(By.xpath("//span[@id='aadhaar_back_select']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='aadhaar_back_select']"))).click();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='step1']//button[contains(text(),'Next')]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='step1']//button[contains(text(),'Next')]"))).click();
        Thread.sleep(5000);
       /* driver.findElement(By.xpath("//button[text()='Previous']")).click();
        Thread.sleep(4000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='step1']//button[contains(text(),'Next')]"))).build().perform();
        driver.findElement(By.xpath("//div[@id='step1']//button[contains(text(),'Next')]")).click();
        Thread.sleep(3000);*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otp_val"))).sendKeys("91752");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='step2']//button[contains(text(),'Next')]"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyname"))).sendKeys("Ujwala Seeds");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='md-form']//div[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ng-tns-c6-0 ng-star-inserted']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='dba']"))).sendKeys("Seeds");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='filter_phone']"))).sendKeys("7656789098");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='taxid']"))).sendKeys("");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='website']"))).sendKeys("WWW.Google.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='buisness_pan_select']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='buisness_addr_proof_select']"))).click();
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='step3']//button[contains(text(),'Next')]"))).build().perform();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='step3']//button[contains(text(),'Next')]"))).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address1']"))).sendKeys("9/2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address2']"))).sendKeys("Magnet");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address3']"))).sendKeys("corporate park");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='village']"))).sendKeys("Machkal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tehsil']"))).sendKeys("Mudhole");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='district']"))).sendKeys("Nirmal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='state']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Assam')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='city']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Halflong')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='country']"))).sendKeys("India");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pincode']"))).sendKeys("380015");
        
        //Top-Up Ring
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-lg-4 col-md-4 col-sm-12 col-12']//div[@class='trnsctn-bx']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-right']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-right']//img[@class='svg-convert']"))).click();
        actions.moveToElement(driver.findElement(By.xpath("//label[@id='p_month']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='p_month']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-right']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='p_year']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-right']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='p_total']"))).click();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//tr[5]//td[3]//div[1]//div[1]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[5]//td[3]//div[1]//div[1]"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-red']")).click();
        Thread.sleep(4000);
        actions.moveToElement(driver.findElement(By.xpath("//select[@name='dataTbl_length']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='dataTbl_length']"))).click();
        driver.findElement(By.xpath("//option[contains(text(),'All')]")).click();
        actions.moveToElement(driver.findElement(By.xpath("//tr[29]//td[3]//div[1]//div[1]"))).build().perform();
        driver.findElement(By.xpath("//tr[29]//td[3]//div[1]//div[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='amount']"))).sendKeys("231");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green']"))).click();
        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green']"))).click();

    }

     //Transaction history
        @Test(enabled = false ,priority = 4)
        public void Transaction() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sb_trans"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("btn btn-teal btn-sm"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-header d-inline-block']//span[contains(text(),'×')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']"))).sendKeys("ahh agh");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
        //consumer
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Consumer')]"))).click();
       //Merchant
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Merchant')]"))).click();
       //Add-withdraw
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add/Withdraw')]"))).click();

    }
    //statement
    @Test(enabled = false ,priority = 5)
    public void statement() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sb_stmt"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_d_2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_d_4"))).click();
     //Filter
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trst-filter"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='left-icon oi oi-chevron-left']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='right-icon oi oi-chevron-right']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col dl-abdtp-date-button dl-abdtp-month 1580495400000']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trst-filter"))).click();
    }
    //Commisssion
    @Test(enabled = false, priority = 6)
    public void commission() throws InterruptedException{
        actions.moveToElement(driver.findElement(By.xpath("//li[@id='sb_comms']//a"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='sb_comms']//a"))).click();
        actions.moveToElement(driver.findElement(By.xpath("//a[@id='consumerList']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("merchantList"))).click();
        actions.moveToElement(driver.findElement(By.xpath("//label[@id='p_week']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Week"))).sendKeys("1234567890");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Month"))).click();
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("Total")))).contextClick();
    }
    //User-list
    @Test(enabled = false, priority = 7)
    public void Userlist() throws InterruptedException{
        actions.moveToElement(driver.findElement(By.xpath(""))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).sendKeys("");
    }
    //Change Password   //Change Pin ,  Privacy policy and commission and trasacton history // Balance //Agent list  
    @Test(enabled = false, priority = 8)
    public void changepassword() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='prfl-arw']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mCSB_19_container']//div[1]//ul[1]//li[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='oldpassword']"))).sendKeys("Nagesh@2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).sendKeys("");
    }
    //Change Pin
    @Test(enabled = false, priority = 9)
    public void ChangePIN() throws InterruptedException{
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='mCSB_8_container']//div[1]//ul[1]//li[2]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mCSB_8_container']//div[1]//ul[1]//li[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal fade chngps-popup in show']//button[@class='close pull-right']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mCSB_8_container']//div[1]//ul[1]//li[2]"))).click();wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='oldpin']"))).sendKeys("1145");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pin']"))).sendKeys("6709");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pin2']"))).sendKeys("6709");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal fade chngps-popup in show']//button[contains(text(),'Submit')]"))).click();

    }
    //Privacy policy
    @Test(enabled = true, priority = 13)
    public void Privacy() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='prfl-arw']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile-slide open']//div[2]//ul[1]//li[1]"))).click();
        Thread.sleep(5000);
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        driver.close();
        driver.switchTo().window(tabs1.get(0));
    }

    //Terms and Conditions
    @Test(enabled = true, priority = 14)
    public  void Terms() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile-slide open']//div[2]//ul[1]//li[2]"))).click();
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
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='profile-slide open']//div[3]//ul[1]//li[1]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile-slide open']//div[3]//ul[1]//li[1]"))).click();
        Thread.sleep(5000);
    }
     //Logout
     @Test(enabled =true, priority = 17)
     public void Logout() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='prfl-arw']"))).click();
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='profile-slide open']//div[4]//ul[1]//li[1]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile-slide open']//div[4]//ul[1]//li[1]"))).click();
        Thread.sleep(4000);
    }

    @AfterClass
    public void Exit()  {

        driver.quit();
    }

}
