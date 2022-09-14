package test.java.dart;

import main.java.dart.pageEvents.EndUserEvents;
import main.java.dart.pageEvents.SideBarEvents;
import main.java.utils.FrameworkConfig;
import main.java.utils.XLUtils;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddNewUserTest extends LoginTest {

    @Test(dataProvider = "endUserData")
   public void AddNewUseMethod(String fName, String lName, String mNumber, String email) throws InterruptedException, IOException {
       super.LoginMethodDart();

        /*Add new user to portal */
       SideBarEvents sideBarEvents = new SideBarEvents(driver);
      sideBarEvents.goToEndUser();
       logger.info("Clicked on SideBar");
       logger.info(fName + lName + mNumber);

      EndUserEvents endUserEvents = new EndUserEvents(driver);
       endUserEvents.addNewUser(fName, lName, mNumber, email);
        logger.info("User added successfully");
       logger.addScreenCaptureFromPath("../screenshots/AddNewUseMethod.png");


    }



    @DataProvider(name = "endUserData")
    Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/datafiles/" + "enduserdata1.xlsx";
        logger.info(path);
        int rownum = XLUtils.getRowCount("Sheet1");
        int colcount = XLUtils.getCellCount("Sheet1", 1);
        String[][] logindata = new String[rownum][colcount];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                logindata[i - 1][j] = XLUtils.getCellData("Sheet1", i, j);
            }
        }
        logger.info(String.valueOf(logindata));
        return logindata;
    }















}
