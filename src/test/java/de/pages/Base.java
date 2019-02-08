package de.pages;

import de.helper.MyReport;
import de.helper.MyScreenshot;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver=driver;
    }

    public void visit (String url){
        try {
            driver.get(url);
        }catch (WebDriverException wde){
            MyReport.fetchTest().error(wde, MyScreenshot.getScreenshot(driver));
            Assert.fail();
        }
    }

    public void click(WebElement element,int timeout){
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
            MyReport.fetchTest().info("Clicked on element: " + element.toString(), MyScreenshot.getScreenshot(driver));
        }catch (WebDriverException wde){
            MyReport.fetchTest().error(wde, MyScreenshot.getScreenshot(driver));
            Assert.fail();
        }

    }

    public void type(WebElement element,int timeout, String imputText){

        try{
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element)).sendKeys(imputText);
            MyReport.fetchTest().info("Typed in the element: " + element.toString(), MyScreenshot.getScreenshot(driver));
        }catch (WebDriverException wde){
            MyReport.fetchTest().error(wde, MyScreenshot.getScreenshot(driver));
            Assert.fail();
        }
    }

    public boolean isDisplayed(WebElement element, int timeout){
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        }catch (WebDriverException wde){
            return false;

        }
        return true;
    }
}
