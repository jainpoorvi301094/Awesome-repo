package main.java.dart.pageEvents;


import main.java.dart.pageObjects.LoginPageElements;
import main.java.utils.FrameworkConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.IReporter;
import java.util.concurrent.TimeUnit;
import static test.java.BaseTest.driver;
import static test.java.BaseTest.logger;

public class LoginPageEvents extends LoginPageElements implements IReporter {

    FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

    // GetPage Title
    public void getTitleCompany() throws InterruptedException {
        logger.info("Page Title is " + driver.getTitle());
        Thread.sleep(2000);

    }

    WebDriver ldriver;
    public LoginPageEvents (WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }


    public void loginMethod() throws InterruptedException {
        Thread.sleep(3000);
        enterpriseId.sendKeys(config.enterpriseId());
        nxtButton.click();
        Thread.sleep(3000);

        username.sendKeys(config.username());
        Thread.sleep(3000);

        sendOTP.click();
        Thread.sleep(3000);

        enterOTP.sendKeys(config.otp());
        Thread.sleep(3000);
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String errMsg = " Your email or password is incorrect. Please try again!";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String crUrl = driver.getCurrentUrl();/*
        if (crUrl == "http://admin.kiteqa.com/admin"){
            logger.info("Login Success");
        }
            else{
            Assert.assertEquals(errMsg,errMsgOnPage);
        }*/
    }
}







