package main.java.kite.pageEvents;


import main.java.kite.pageObjects.SideBarElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.IReporter;

public class SideBarEvents extends SideBarElements implements IReporter {
/*Local instance for the driver*/
    WebDriver ldriver;
    public SideBarEvents(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }



    /*events and operation*/
    public void goToAddEnterprise() {
        enterprisesMenu.click();
        addEnterprisesSubMenu.click();
    }

    public void goToCreateAdmin(){
        enterprisesMenu.click();
        createAdmin.click();
    }
}
