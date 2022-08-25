package com.obsqura.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {
static WebDriver driver;

public static Properties prop=null;
public static void loadConfig() {
	try {
		prop=new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources"
                + "/config.properties");
		prop.load(ip);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
        e.printStackTrace();
    }
	}

@BeforeTest
@Parameters("browser")
public void setUp(String browser) {
	loadConfig();
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty(prop.getProperty("chromedriver"),prop.getProperty("chromedriverlocation")); 
		driver = new ChromeDriver();
	}else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty(prop.getProperty("firefoxdriver"),prop.getProperty("firefoxdriverlocation"));
		driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty(prop.getProperty("edgedriver"),prop.getProperty("edgedriverlocation"));
			driver=new EdgeDriver();
		}
	driver.get(prop.getProperty("url")); 
	driver.manage().window().maximize();
}
@AfterMethod
public void tearDown(ITestResult iTestResult) throws IOException { 
    if (iTestResult.FAILURE == iTestResult.getStatus()) { 
        takeScreenshot(iTestResult.getName());
    }
} 
public String takeScreenshot(String name) throws IOException {
	 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); //current date & time is obtained

  //Take the screenshot
    File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
String destination =  System.getProperty("user.dir") + "\\target\\" + name + dateName
            + ".png"; //location specified., name & date should be appended
   
    File finalDestination = new File(destination); 
     FileUtils.copyFile(source, finalDestination);
    return destination;   
}

}
