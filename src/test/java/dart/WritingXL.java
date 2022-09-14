package test.java.dart;

import main.java.utils.FrameworkConfig;
import main.java.utils.XLUtils;
import org.aeonbits.owner.ConfigFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static test.java.BaseTest.driver;
import static test.java.BaseTest.logger;

public class WritingXL {
    WebDriver ldriver;

    public  WritingXL(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);

    }

    public static void main(String[] args) throws IOException {
        driver.get("http://prepaid.kiteqa.com/http://prepaid.kiteqa.com/gouravqa11/home/users/end-users");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("data");
       // Object empdata[][]={
         //       {"EmpID", "Name", "Job"},
          //      {101, "David", "Engineer"},
           //     {102, "Pari", "Engg"},
           //     {103, "Poorvi", "Engg"}
     //   };

        Object data1[][]={{"name","Role"},
                {"name","Role"}
        };


        //int rows=empdata.length;
        //int cols=empdata[0].length;

        int rows=data1.length;
        int cols=data1[0].length;


        System.out.println(rows);
        System.out.println(cols);

        for(int r=0;r<rows;r++){
            XSSFRow row=sheet.createRow(r);

            for (int c=0; c<cols; c++ ){
                XSSFCell cell=row.createCell(c);
                Object value=data1[r][c];

                if(value instanceof String)
                    cell.setCellValue((String) value);
                if(value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if(value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }
       // String filePath="/Users/gourav/IdeaProjects/FalconMain/datafiles/empinfo.xlsx";
        String filePath="/Users/gourav/IdeaProjects/FalconMain/datafiles/Book1.xlsx";
        FileOutputStream outputStream=new FileOutputStream(filePath);
        workbook.write(outputStream);

        outputStream.close();
        System.out.println("File has been written successfully");
        getDatafromwebsite();

    }

    public static void getDatafromwebsite() throws IOException {
        FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
        //logger.info("hi");
        driver.get("http://prepaid.kiteqa.com/gouravqa11/home/users/end-users");
        String path = "/Users/gourav/IdeaProjects/FalconMain/datafiles/test.xlsx";
        logger.info(path);


        XLUtils xlutils = new XLUtils(path);

        // Write Headers in Excell
        //xlutils.setCellData("path","sheet1",0,0,"id");
        XLUtils.setCellData( "sheet1", 0, 1, "Name");
        xlutils.setCellData("sheet1", 0, 2, "Role");
        xlutils.setCellData("sheet1", 0, 3, "Mobilenumber");

        WebElement table = driver.findElement(By.xpath("/html/body/app-root/app-post-auth/app-users/div/app-user-details/div[1]/div/perfect-scrollbar/div/div[1]/table/tbody"));
        int rows = table.findElements(By.xpath("tr")).size();

        for (int r = 1; r <= rows; r++) {

            String name = driver.findElement(By.xpath("/html/body/app-root/app-post-auth/app-users/div/app-user-details/div[1]/div/perfect-scrollbar/div/div[1]/table/tbody/tr[" + r + "]/td[2]")).getText();
            String Role = driver.findElement(By.xpath("/html/body/app-root/app-post-auth/app-users/div/app-user-details/div[1]/div/perfect-scrollbar/div/div[1]/table/tbody/tr[" + r + "]/td[3]")).getText();

            System.out.println("---------------------------------------------------------*****************" + name + Role);
            logger.info(String.valueOf(name + Role));

            xlutils.setCellData( "Sheet1", r, 0, "name");
            xlutils.setCellData("Sheet1", r, 1, "Role");
            // xlutils.setCellData(path,"sheet1",r,2,"Mobilenumber");
        }
        System.out.println("---------------------------------------------------------*****************" + "Data fetched successfully");





    }
}





