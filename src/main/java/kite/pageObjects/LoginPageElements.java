package main.java.kite.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class LoginPageElements {

    @FindBy(id="username")
    @CacheLookup
    public
    WebElement username;

    @FindBy(id="password")
    @CacheLookup
    public
    WebElement password;

    @FindBy(xpath = "/html/body/app-root/table/tbody/tr[2]/td/table/tbody/tr/td/app-login/table/tbody/tr/td[2]/form/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/button")
    @CacheLookup
    public
    WebElement loginButton;

    @FindBy(xpath="/html/body/app-root/table/tbody/tr[2]/td/table/tbody/tr/td/app-login/table/tbody/tr/td[2]/form/table[1]/tbody/tr/td/span")
    @CacheLookup
    public
    WebElement errMsgOnPage;






}
