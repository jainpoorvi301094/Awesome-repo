package main.java.kite.pageEvents;

import main.java.kite.pageObjects.AddEnterpriseElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static test.java.BaseTest.driver;
import static test.java.BaseTest.logger;

public class AddEnterpriseEvents extends AddEnterpriseElements {
    WebDriver ldriver;
    public AddEnterpriseEvents(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    public  void addEnterprise () throws InterruptedException {
        /* ****************Basic Information****************/

        logger.info("Page Title is " + driver.getTitle());
        companyCode.sendKeys("gouravqa13");
        enterpriseName.sendKeys("gouravqa13");
        displayName.sendKeys("gouravqa13");
        programPrepaidButton.click();
        planGprCardard.click();
        planGiftCard.click();
        nonJITButton.click();
        loadMoneyYesButton.click();
        impsPayOutYesButton.click();
        issuerButton.click();
        authTokenEmailID.sendKeys("gouravqa13@mailinator.com");

        /* *******************Tax Related Details******************** */

        panNumber.sendKeys("HXRPS8814U");

        /* *******************Contact Details******************** */

        contactPersonName.sendKeys("Rohit suri");
        contactPersonNumber.sendKeys("9009009015");

        submitButton.click();
        Thread.sleep(3000);
        String BoxText = accessPopUp.getText();

        //String alertMessage= driver.switchTo().alert().getText(); // capture alert message

        logger.info(BoxText);
        Thread.sleep(3000);
        confirmButton.click();
        Thread.sleep(7000);
    }
}
