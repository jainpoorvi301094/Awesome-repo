package test.java.dart;

import main.java.dart.pageEvents.EndUserEvents1;
import main.java.dart.pageEvents.SideBarEvents;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddNewUserTest1 extends LoginTest {

    @Test
    public void AddNewUseMethod1() throws InterruptedException, IOException {
        super.LoginMethodDart();

        /*Add new user to portal */
        SideBarEvents sideBarEvents = new SideBarEvents(driver);
        sideBarEvents.goToEndUser();
        logger.info("Clicked on SideBar");


        EndUserEvents1 endUserEvents1 = new EndUserEvents1(driver);
        endUserEvents1.dataGet();
        logger.info("User added successfully");
        logger.addScreenCaptureFromPath("../screenshots/AddNewUseMethod1.png");


    }

}
















