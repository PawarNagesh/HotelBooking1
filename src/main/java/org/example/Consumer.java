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

public class Consumer{
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        actions=new Actions(driver);
        driver.get("https://dev.secure.incashme.com/ua/login");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
        wait = new WebDriverWait(driver, 30);
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
        driver.findElement(By.xpath("//div[5]//form[1]//div[1]//input[1]")).sendKeys("testcon045@mailinator.com"); // Enter Email Id
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
    //    Thread.sleep(9000);
        driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success']")).click(); // Success Ok Button
        Thread.sleep(5000);
    }

    //Login
    @Test(enabled = true, priority = 2)
    public void Login() throws InterruptedException {
        driver.findElement(By.xpath("//div[3]//form[1]//div[1]//input[1]")).sendKeys("testcon045@mailinator.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Tarun@13");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        Thread.sleep(5000);
    }
    //Homedashbaord
    @Test(enabled =false, priority=3)
    public void Headboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-auth-header//li[1]//a[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='payeeName']"))).sendKeys("9494028007");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='searchBtn text-center']"))).click();
        driver.findElement(By.xpath("//div[@class='fs-14 color-7B7A7A mb5 ff-sf']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("2.1");
        driver.findElement(By.id("message")).sendKeys("Hi Sai..... When will u come back to Amd Plz tell me ");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-green w-100']")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//a[@class='btn btn-green cap-txt w-100 fs-24']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("ID-100-000-0301");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//tr[1]//td[7]//button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
        Thread.sleep(3000);
        /*WebElement element= driver.findElement(By.xpath("//tr[10]//td[7]//button[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,0)");
        Thread.sleep(5000);
        /*
         * WebElement element = driver.findElement(By.id("comm_max_amount"));
         * Coordinates cor = ((Locatable) element).getCoordinates(); cor.inViewPort();
         */
    }
    //Requests
    @Test(enabled =false, priority=4)
    public void Requests() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='li_request']//a[@class='sidebar-link']"))).click();
        Thread.sleep(3000);
        //Pay
        driver.findElement(By.xpath("//button[@class='btn btn-green w-100 fs-20']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='btn btn-pink']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='btn btn-green w-100 fs-20']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='btn btn-green']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Back to Home')]"))).click();
/*  //cancel
                 driver.findElement(By.xpath("//li[@id='li_request']//a[@class='sidebar-link']")).click();
                 Thread.sleep(3000);
                 driver.findElement(By.xpath("//li[@id='id_2347501']")).click();
                 Thread.sleep(9000);
                 driver.findElement(By.xpath("//button[@class='btn btn-danger w-100 fs-20']")).click();
                 Thread.sleep(9000);
                 driver.findElement(By.xpath("//button[@class='swal2-cancel btn btn-danger']")).click();
                 Thread.sleep(9000);
                 driver.findElement(By.xpath("//button[@class='btn btn-danger w-100 fs-20']")).click();
                 Thread.sleep(9000);
                 driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success']")).click();
                 Thread.sleep(10000);
                 driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success']")).click();
                 Thread.sleep(3000);*/
    }


    //Transaction History
    @Test(enabled =false, priority=5)
    public void TransactionHistory() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='li_transactions']//a[@class='sidebar-link']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[7]//button[1]"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[9]//td[7]//button[1]"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("ID-100-000-0344");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']"))).clear();

        //Individual
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("li_C"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[8]//td[7]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'×')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[5]//td[7]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'×')]"))).click();

        //Merchant
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("li_M"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[7]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'×')]"))).click();
        driver.findElement(By.xpath("//tr[8]//td[7]//button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'×')]"))).click();
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Transfer to Merchant");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']"))).clear();

        //Agent
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("li_A"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[2]//td[7]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'×')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //tr[6]//td[7]//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'×')]"))).click();

        //Deposit
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("li_D"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'No Transaction History!')]"))).getText();

        //Withdraw
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("li_Bank"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'No Transaction History!')]"))).getText();

        //Filter-All
       /* wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("li_C"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("li_F"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("min"))).sendKeys("1");
        driver.findElement(By.id("max")).sendKeys("100");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-fil btn-lgt-gray mt10 mb40']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-fil btn-lgt-gray']"))).click();*/}

    //statement
    @Test(enabled =true, priority=6)
    public void statement() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='li_statement']//a[@class='sidebar-link']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='load_btn_2']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='load_btn_4']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("load_btn_3"))).click();
        Thread.sleep(5000);
        //Filter
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='trst-filter']"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='left-icon oi oi-chevron-left']"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class ='right-icon oi oi-chevron-right']"))).click();
        Thread.sleep(3000);
       /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col dl-abdtp-date-button dl-abdtp-month 1577817000000']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='ok_btn text-center']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("load_btn_2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='trst-filter']"))).click();*/

    }
    //Balance
    @Test(enabled = true, priority = 7)
    public void Balnace () throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='li_balance']//a[@class='sidebar-link']"))).click();
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='blnc-txt']"))).getText());

    }
    //Add Money-Debitecard
    @Test(enabled =false, priority=8)
    public void Addmoney() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='li_addmoney']//a[@class='sidebar-link']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dcc-add']//i[@class='fa fa-plus']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardname"))).sendKeys("testconsumer");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardnum"))).sendKeys("1214547478887855");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardexpiry"))).sendKeys("1032");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_save"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-success']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Debit')]//parent::div//following-sibling::ul//li[not(contains(@class,'no_card'))]//a[contains(@class,'dcc-delete')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-cancel btn btn-danger']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Debit')]//parent::div//following-sibling::ul//li[not(contains(@class,'no_card'))]//a[contains(@class,'dcc-delete')]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-success']"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-success']"))).click();
        //Net-banking
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]//ul[1]//li[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']"))).sendKeys("ICICI Bank");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-green btn-sm']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='amount']"))).sendKeys("20.02");
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-green w-100 fs-20 color-white']"))).click();
        Thread.sleep(10000);
        
    }
    //Withdrawmoney
    @Test(enabled =false, priority=9)
    public void Withdrawmoney() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='li_withdrawmoney']//a[@class='sidebar-link']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Amount...']"))).sendKeys("2.02");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-panel']//li[2]//a[1]//span[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("display_name"))).sendKeys("Test");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("holder_name"))).sendKeys("testconsumer one");
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bank_name"))).sendKeys("Yes bank");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bank_account_type"))).sendKeys("Saving Account");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='bank_account_no']"))).sendKeys("61145120321");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ifsc_no"))).sendKeys("0000150");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send-mny"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //button[@class='swal2-cancel btn btn-danger']"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send-mny"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-success']"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-confirm btn btn-success']"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //li[2]//div[1]//div[1]//a[1]//span[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='swal2-cancel btn btn-danger']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //li[2]//div[1]//div[1]//a[1]//span[1]"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-success']")).click();

    }

    //Profile-View
    @Test(enabled =true, priority=10)
    public void profile() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='d-flex align-items-center']"))).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("p_docs"))).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='arrow-container next']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='arrow-container prev']"))).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("p_pwd"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldpassword"))).sendKeys("Tarun@13");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password2"))).sendKeys("Tarun@13");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Tarun@13");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal fade chngps-popup in show']//button[@class='btn btn-fill btn-success'][contains(text(),'Submit')]"))).click();
    }

    //Privacypolicy
    @Test(enabled = true, priority = 11)
    public void privacy() throws InterruptedException{
        //actions.moveToElement(driver.findElement(By.xpath("//li[@id='li_privacyp']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='li_privacyp']//a[@class='sidebar-link']"))).click();
        Thread.sleep(5000);
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        driver.close();
        driver.switchTo().window(tabs1.get(0));
    }

    //Terms and Condition
    @Test(enabled = true, priority =12)
    public void terms() throws InterruptedException{
        actions.moveToElement(driver.findElement(By.xpath("//li[9]//a[1]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[9]//a[1]"))).click();
        Thread.sleep(5000);
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        driver.close();
        driver.switchTo().window(tabs1.get(0));
    }
    //Kyc $ Aml policy
    @Test(enabled = true, priority =13)
    public void kyc() throws InterruptedException{
        actions.moveToElement(driver.findElement(By.xpath("//body//li[10]"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//li[10]"))).click();
        Thread.sleep(5000);
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        driver.close();
        driver.switchTo().window(tabs1.get(0));
    }
    //Logout
    @Test(enabled = true, priority = 14)
    public void logout() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='color-red']"))).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void exit() {

        driver.quit();
    }
}




