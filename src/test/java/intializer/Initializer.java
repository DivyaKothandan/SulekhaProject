package intializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Initializer {

	public static FileInputStream fis = null;
	public static Properties envProp = null;

	//Extents report declaration
	public static ExtentReports reports;
	public static ExtentTest log;

	public static WebDriver wd = null;

	public static void initialize() throws IOException {



		//reports=new ExtentReports("D:/Workspace/Sulekha/report/DDReportsss.html");


		fis = new FileInputStream(new File("D:/Workspace/Sulekha/src/test/resources/config/env.properties"));
		envProp = new Properties();
		envProp.load(fis);

		if(envProp.getProperty("BROWSER").equals("FIREFOX"))
		{
			wd = new FirefoxDriver();
		}
		else{
			System.setProperty("webdriver.chrome.driver" , "D:/Drivers/chromedriver.exe");
			wd = new ChromeDriver();
		}

	}

}
