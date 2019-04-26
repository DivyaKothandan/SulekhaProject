package testCases;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import intializer.DriverFunctions;
import intializer.Initializer;
import pages.SulekhaHomePage;

public class HomePageTest extends Initializer {
	
	
	@Test
	public static void validateHomePage() throws IOException, InterruptedException
	{
		log=reports.startTest("validateHomePage");
		initialize();
		DriverFunctions.loadUrl();
		SulekhaHomePage.validateSearch();	
		Screenshot();
		
	}
	
	
	public static void Screenshot() throws IOException
	{
		File src = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("D:/Workspace/Sulekha/Screenshots.sulekha.jpg"));
	}
	
	@DataProvider(name="HomePageTest")
	public static Object[][] getHomePage()
	{
		//if(Xls_Reader.)
		
		return null;
		
	}

}
