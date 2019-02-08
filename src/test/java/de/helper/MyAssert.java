package de.helper;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyAssert {

    private WebDriver driver;

    public MyAssert(WebDriver driver){
        this.driver=driver;
    }

    public void assertTrue(boolean valueToAsset,String reportingMessage){
        try {
            Assert.assertTrue(valueToAsset);
            MyReport.fetchTest().pass("Check assertTrue for: " + reportingMessage + " passed", MyScreenshot.getScreenshot(driver));
        }catch (AssertionError ae){
            MyReport.fetchTest().fail("Checking AssertTrue failed with error message: " + reportingMessage, MyScreenshot.getScreenshot(driver));

            throw new AssertionError(ae);
        }
    }

}
