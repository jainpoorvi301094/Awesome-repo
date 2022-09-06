package main.java.dart.pageEvents;

import main.java.dart.pageObjects.EndUserElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EndUserEvents extends EndUserElements {

    WebDriver ldriver;

    public EndUserEvents (WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    public void addNewUser (String fName, String lName, String mNumber, String email) throws InterruptedException {
        addNewUserBtn.click();
        Thread.sleep(3000);
        firstName.sendKeys(fName);
        Thread.sleep(3000);
        lastName.sendKeys(lName);
        Thread.sleep(3000);
        mobileNumber.sendKeys(mNumber);
        Thread.sleep(3000);
        selectRoleDropDown.click();
        Thread.sleep(3000);
      /*  roleAdmin.click();
      *  Thread.sleep(3000);
      * */
        roleStandard.click();
        Thread.sleep(3000);
        genderMale.click();
        Thread.sleep(3000);
   /*     genderFemale.click();
   *  Thread.sleep(3000);
   * */
        this.email.sendKeys(email);
        Thread.sleep(3000);
        submitBtn.click();
        Thread.sleep(7000);


        /* *************Add More Information**************** */

    }




}
