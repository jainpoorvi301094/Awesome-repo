package main.java.dart.pageEvents;

import main.java.dart.pageObjects.EndUserElements;
import main.java.utils.XLUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static main.java.utils.XLUtils.fo;
import static main.java.utils.XLUtils.wb;
import static test.java.BaseTest.driver;

public class EndUserEvents1 extends EndUserElements {

    WebDriver ldriver;

    public EndUserEvents1(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }
/*    public void addNewUser() throws IOException {
    String path = "/Users/gourav/IdeaProjects/FalconMain/datafiles/Book1.xlsx";
            logger.info(path);
    XLUtils xlutils = new XLUtils(path);

    // Write Headers in Excell
    //xlutils.setCellData("path","sheet1",0,0,"id");
    // XLUtils.setCellData(path, "sheet1", 0, 1, "Name");
    // xlutils.setCellData(path, "sheet1", 0, 2, "Role");
    //xlutils.setCellData(path, "sheet1", 0, 3, "Mobilenumber");

    WebElement table = driver.findElement(By.xpath("/html/body/app-root/app-post-auth/app-users/div/app-user-details/div[1]/div/perfect-scrollbar/div/div[1]/table/tbody"));
    int rows = table.findElements(By.xpath("tr")).size();

            for (int r = 1; r <= rows; r++) {

        String name = driver.findElement(By.xpath("/html/body/app-root/app-post-auth/app-users/div/app-user-details/div[1]/div/perfect-scrollbar/div/div[1]/table/tbody/tr[" + r + "]/td[2]")).getText();
        String Role = driver.findElement(By.xpath("/html/body/app-root/app-post-auth/app-users/div/app-user-details/div[1]/div/perfect-scrollbar/div/div[1]/table/tbody/tr[" + r + "]/td[3]")).getText();

        System.out.println("---------------------------------------------------------*****************" + name + Role);
        logger.info(String.valueOf(name + Role));

        xlutils.setCellData("Sheet1", r, 0, "name");
        xlutils.setCellData("Sheet1", r, 1, "Role");
        // xlutils.setCellData(path,"sheet1",r,2,"Mobilenumber");
    }
            System.out.println("---------------------------------------------------------*****************" + "Data fetched successfully");


 }*/




    public void dataGet() throws IOException {


        //List<WebElement> irows = driver.findElements(By.xpath("//*[@id='matTable']/tbody/tr"));
        List<WebElement> irows = driver.findElements(By.xpath("/html/body/app-root/app-post-auth/app-users/div/app-user-details/div[1]/div/perfect-scrollbar/div/div[1]/table/tbody/tr"));
        int iRowsCount = irows.size();
       // List<WebElement> icols = driver.findElements(By.xpath("//*[@id='matTable']/tbody/tr[1]/td"));
        List<WebElement> icols = driver.findElements(By.xpath("/html/body/app-root/app-post-auth/app-users/div/app-user-details/div[1]/div/perfect-scrollbar/div/div[1]/table/tbody/tr[1]/td"));
        int iColsCount = icols.size();
        System.out.println("Selected web table has " + iRowsCount + " Rows and " + iColsCount + " Columns");
        System.out.println();

        String filepath = (System.getProperty("user.dir") + File.separator + "datafiles" + File.separator + "Book1.xlsx");
        FileOutputStream outputStream = new FileOutputStream(filepath);
        XSSFWorkbook wkb = new XSSFWorkbook();
        XSSFSheet sheet1 = wkb.createSheet("DataStorage");

        for (int i = 1; i <= iRowsCount; i++) {

            XSSFRow excelRow = sheet1.createRow(i);
            for (int j = 1; j <= iColsCount; j++) {

                if (i == 1) {
                    WebElement val = driver.findElement(By.xpath("/html/body/app-root/app-post-auth/app-users/div/app-user-details/div[1]/div/perfect-scrollbar/div/div[1]/table/tbody/tr[" + i + "]/td[" + j + "]"));
                    String a = val.getText();
                    System.out.print(a);

                    XSSFCell excelCell = excelRow.createCell(j-1);
                    excelCell.setCellValue(a);
                } else {
                    WebElement val = driver.findElement(By.xpath("/html/body/app-root/app-post-auth/app-users/div/app-user-details/div[1]/div/perfect-scrollbar/div/div[1]/table/tbody/tr[" + i + "]/td[" + j + "]"));
                    String a = val.getText();
                    System.out.print(a);

                    XSSFCell excelCell = excelRow.createCell(j-1);
                    excelCell.setCellValue(a);
                }
            }
            System.out.println();
        }
        outputStream.flush();
        wkb.write(outputStream);
        outputStream.close();
    }
}











