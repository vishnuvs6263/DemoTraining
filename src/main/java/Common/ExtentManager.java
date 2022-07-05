package Common;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {private static ExtentReports extent;

public static WebDriver driver;


public static ExtentReports createInstance(String fileName) {
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
   
    
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setDocumentTitle(fileName);
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName(fileName);
    
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("Automation Tester", "Vishnu VS");
    extent.setSystemInfo("Organization", "Xilligence");
    extent.setSystemInfo("Build no", "DEMO");
    
    
    return extent;
}


 public static String screenshotPath;
public static String fileName;

public static void captureScreenshot() throws Exception, SQLException {

	Date d = new Date();
	String fileName = d.toString().replace(":", "_").replace(" ", "_");
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot, new File(".//screenshot//"+fileName+".jpg"));




}
}
