package main.java.kite.pageEvents;


import main.java.kite.pageObjects.LoginPageElements;
import org.openqa.selenium.support.PageFactory;
import org.testng.IReporter;

import java.util.concurrent.TimeUnit;
import static test.java.BaseTest.driver;
import static test.java.BaseTest.logger;


public class LoginPageEvents extends LoginPageElements implements IReporter {

    // GetPage Title
    public void getTitleCompany() throws InterruptedException {
        logger.info("Page Events Se " + driver.getTitle());
        Thread.sleep(2000);

    }

    public void validateLogin() throws InterruptedException {

        LoginPageEvents loginPage = PageFactory.initElements(driver, LoginPageEvents.class);
        loginPage.loginMethod("superadmin@kite.work", "Kite@135#");
    }

    public void loginMethod (String uname, String pass) throws InterruptedException {
        username.sendKeys(uname);
        password.sendKeys(pass);
        Thread.sleep(3000);
        loginButton.click();
        Thread.sleep(2000);
        errMsgOnPage.getText();
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







