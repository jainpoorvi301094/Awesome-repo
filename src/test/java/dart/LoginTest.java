package test.java.dart;

import main.java.dart.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test()
    public void LoginMethod() throws InterruptedException, IOException {

        /* for Login User in Dart portal */
        LoginPageEvents loginPageEvents = new LoginPageEvents(driver);
        loginPageEvents.loginMethod();
        logger.addScreenCaptureFromPath("../screenshots/LoginMethod.png");

    }

}
