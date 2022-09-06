package test.java.kite;

import main.java.kite.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;
import test.java.BaseTest;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test()
    public void LoginMethod() throws InterruptedException, IOException {

        /* for Login User  */
        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.validateLogin();
        logger.addScreenCaptureFromPath("../screenshots/LoginMethod.png");

    }

}
