package Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	@BeforeSuite
	public void initDriver() throws IOException {

		// Getting the automation project path
		String ProjectPath = System.getProperty("user.dir");

		// Initialize the driver
		System.setProperty("webdriver.chrome.driver", ProjectPath + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		// Loading the properties file
		prop = new Properties();
		FileInputStream fis = new FileInputStream(ProjectPath + "/configuration/confiq.properties");
		prop.load(fis);

		// Manage windows property
 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Launching the browser and navigating to the application URL
		driver.get(prop.getProperty("URL"));
		
	}

}
