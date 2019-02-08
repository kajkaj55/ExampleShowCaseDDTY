package de.helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Hashtable;

public class MyReport {

    public static ExtentReports extentReports;
    public static Hashtable<Integer, ExtentTest> extentTestHashtable = new Hashtable <>();


    public static void createReport(String reportPath){
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportPath);
        extentHtmlReporter.config().setReportName("DDT Framework");
        extentHtmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports. attachReporter(extentHtmlReporter);

    }

    public static void flushReport(){
        if (extentReports != null){
            extentReports.flush();
        }
    }

    public static ExtentReports getReport(){
        return extentReports;
    }

    public static synchronized void creatTest(String testName){
        ExtentTest extentTest = extentReports.createTest(testName);
        extentTestHashtable.put((int)Thread.currentThread().getId(), extentTest);
    }

    public static synchronized ExtentTest fetchTest(){
        return extentTestHashtable.get((int)(Thread.currentThread().getId()));

    }
}
