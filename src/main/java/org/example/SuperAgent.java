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
import sun.net.idn.Punycode;

import java.util.ArrayList;

public class SuperAgent {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        actions=new Actions(driver);
        driver.get("https://dev.agent.incashme.com/ua/login");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
   //     Thread.sleep(5000);
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
    //Forgot Password
    @Test(enabled = false, priority = 1)
     public  void Forgotpassword() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Forgot Password?')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-button not-allowd text-right mb10 enbl-lgn']//a[contains(text(),'Back to Login')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-untouched']"))).sendKeys("testsa24@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-button not-allowd text-right mb10 enbl-lgn']//button[@class='btn lgn-btn'][contains(text(),'Submit')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-success']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group bmd-form-group']//input[@class='form-control ng-untouched ng-pristine ng-invalid']"))).sendKeys("91752");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-button not-allowd text-right mb10 mt40 enbl-lgn']//button[@class='btn lgn-btn'][contains(text(),'Submit')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-success']"))).click();
        Thread.sleep(3000);
    }
     //Login
    @Test(enabled = true ,priority = 2)
    public void Login() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=\"email\"]:nth-child(3)"))).sendKeys("testsa25@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pwd"))).sendKeys("taruN@123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Login']"))).click();
        Thread.sleep(7000);
    }
    //Homedashboard
    @Test(enabled = false, priority = 3)
    public void Homedashborad() throws InterruptedException{
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='btn spragt-ftr-btn clr-drk-bl w-100 fs']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn spragt-ftr-btn clr-drk-bl w-100 fs']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='first_name']"))).sendKeys("test agent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='last_name']"))).sendKeys("Zero two");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mydpicon icon-mydpcalendar']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='headerlabelbtn yearlabel']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='yearchangebtn mydpicon icon-mydpup yearchangebtnenabled']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'1993')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]//div[1]//div[1]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]//div[1]//div[1]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]//div[1]//div[1]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[2]//td[4]//div[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))).sendKeys("testagent0002@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone']"))).sendKeys("1341341342");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='profile_pic_select']"))).click();
        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='send-mny']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='fileType']"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),\"Voter's Identity Card\")]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='aadhaar_front_select']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='aadhaar_back_select']"))).click();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//form[@class='form-horizontal w-100 cmn-mtrl-form ng-dirty ng-touched ng-valid']//button[@class='btn btn-green float-right fs-16 ml10 mb30'][contains(text(),'Next')]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='form-horizontal w-100 cmn-mtrl-form ng-dirty ng-touched ng-valid']//button[@class='btn btn-green float-right fs-16 ml10 mb30'][contains(text(),'Next')]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='otp_val']"))).sendKeys("91752");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='form-horizontal w-100 cmn-mtrl-form ng-untouched ng-pristine ng-valid']//button[@class='btn btn-green float-right fs-16 ml10 mb30'][contains(text(),'Next')]"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address1']"))).sendKeys("3-74/1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address2']"))).sendKeys("Hanuman Temple");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address3']"))).sendKeys("machkal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='village']"))).sendKeys("Machkal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tehsil']"))).sendKeys("Mudhole");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='district']"))).sendKeys("Nirmal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='state']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Andhra Pradesh')]"))).click();
        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='city']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Banswada')]"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='country']"))).sendKeys("India");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pincode']"))).sendKeys("504103");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='step3']//button[@class='btn btn-green float-right fs-16 ml10 mb30'][contains(text(),'Next')]"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='target_consumer']"))).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='target_merchant']"))).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='min_topup_amount']"))).sendKeys("200");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='max_topup_amount']"))).sendKeys("100000");
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-red']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-cancel btn-danger swal2-styled']"))).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green cap-txt']"))).click();
        Thread.sleep(8000);

    }
    //Statement
    @Test(enabled = true ,priority = 3)
    public void statement() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='sb_stmt']//a"))).click();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//button[@id='btn_d_11']"))).build().perform();
        driver.findElement(By.xpath("//button[@id='btn_d_11']")).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='trst-filter']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='left-icon oi oi-chevron-left']"))).click();
    }
    //Balance
    @Test(enabled = true, priority = 4)
    public void Balance() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='sb_bal']//a"))).click();
        Thread.sleep(3000);
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='blnc-txt']"))).getText());
    }
    //Commission
    @Test(enabled = true, priority =5)
    public void Commission() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='sb_comms']//a"))).click();
        Thread.sleep(4000);
        actions.moveToElement(driver.findElement(By.xpath("//select[@name='agentListTbl_length']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='agentListTbl_length']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'All')]"))).click();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//tr[137]//td[1]//div[1]//div[1]//h5[1]//span[1]"))).build().perform();
        driver.findElement(By.xpath("//tr[137]//td[1]//div[1]//div[1]//h5[1]//span[1]")).isDisplayed();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]]"))).build().perform();
        driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]]")).isDisplayed();
        //Graph
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//label[@id='p_month']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='p_month']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-right']//img[@class='svg-convert']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='p_year']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-right']//img[@class='svg-convert']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='p_total']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='p_week']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-left']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-right']//img[@class='svg-convert']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cpagin-right']//img[@class='svg-convert']"))).click();
        Thread.sleep(5000);

    }

    //Agent List
    @Test(enabled = true, priority =6)
    public void agentlist() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='sb_agents']//a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='agentsTbl_length']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'All')]"))).click();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//tr[40]//td[6]//a[1]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[40]//td[6]//a[1]"))).click();
        Thread.sleep(6000);
        actions.moveToElement(driver.findElement(By.xpath("//input[@id='str1']"))).build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[@id='infoTargets']"))).build().perform();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='infoTargets']"))).click();
        actions.moveToElement(driver.findElement(By.xpath("//div[3]//div[2]//div[2]//div[1]//input[1]"))).build().perform();
        Thread.sleep(4000);
        actions.moveToElement(driver.findElement(By.xpath("//tr[1]//td[6]//a[1]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[6]//a[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='infoTargets']"))).click();
        actions.moveToElement(driver.findElement(By.xpath("//div[3]//div[2]//div[2]//div[1]//input[1]"))).build().perform();
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//a[@id='transList']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='transList']"))).click();
        Thread.sleep(6000);
    }

    //Create New Agent
    @Test(enabled = true, priority = 7)
    public void newagent() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='sb_addagents']//a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='first_name']"))).sendKeys("Test agentfour");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='last_name']"))).sendKeys("Zero Second");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mydpicon icon-mydpcalendar']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='headerlabelbtn yearlabel']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='yearchangebtn mydpicon icon-mydpup yearchangebtnenabled']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'1993')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]//div[1]//div[1]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]//div[1]//div[1]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]//div[1]//div[1]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[2]//td[4]//div[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))).sendKeys("testagent0002@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone']"))).sendKeys("1341341342");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='profile_pic_select']"))).click();
        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='send-mny']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='fileType']"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),\"Voter's Identity Card\")]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='aadhaar_front_select']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='aadhaar_back_select']"))).click();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//form[@class='form-horizontal w-100 cmn-mtrl-form ng-dirty ng-touched ng-valid']//button[@class='btn btn-green float-right fs-16 ml10 mb30'][contains(text(),'Next')]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='form-horizontal w-100 cmn-mtrl-form ng-dirty ng-touched ng-valid']//button[@class='btn btn-green float-right fs-16 ml10 mb30'][contains(text(),'Next')]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='otp_val']"))).sendKeys("91752");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='form-horizontal w-100 cmn-mtrl-form ng-untouched ng-pristine ng-valid']//button[@class='btn btn-green float-right fs-16 ml10 mb30'][contains(text(),'Next')]"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address1']"))).sendKeys("3-74/1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address2']"))).sendKeys("Hanuman Temple");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address3']"))).sendKeys("machkal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='village']"))).sendKeys("Machkal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tehsil']"))).sendKeys("Mudhole");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='district']"))).sendKeys("Nirmal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='state']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Andhra Pradesh')]"))).click();
        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='city']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Banswada')]"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='country']"))).sendKeys("India");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pincode']"))).sendKeys("504103");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='step3']//button[@class='btn btn-green float-right fs-16 ml10 mb30'][contains(text(),'Next')]"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='target_consumer']"))).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='target_merchant']"))).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='min_topup_amount']"))).sendKeys("200");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='max_topup_amount']"))).sendKeys("100000");
        Thread.sleep(4000);
    }
    //Agent List
     @Test(enabled = true, priority = 9)
      public void Agentlist() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='sb_agents']//a"))).click();
        

     }

    @AfterClass
    public void Exit()  {
        driver.quit();
    }


}
