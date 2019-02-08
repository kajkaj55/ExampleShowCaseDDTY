package de.helper;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.model.Media;
import de.globals.Globals;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MyScreenshot {

    //private WebDriver driver;

    public static String makeScreenshot(WebDriver driver){
        String screenshotFilePath = Globals.EXTENTREPORTS_IMAGES + UUID.randomUUID() + ".png";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File(Globals.EXTENTREPORTS_FOLDER + screenshotFilePath));
        } catch (IOException e){
            e.printStackTrace();
        }

        return  screenshotFilePath;
    }

    public static MediaEntityModelProvider getScreenshot(WebDriver driver){

        MediaEntityModelProvider memp = new MediaEntityModelProvider(new Media());

        try {
           memp = MediaEntityBuilder.createScreenCaptureFromPath(makeScreenshot(driver)).build();
        } catch (IOException e){
            e.printStackTrace();
        }
        return  memp;
    }
}
