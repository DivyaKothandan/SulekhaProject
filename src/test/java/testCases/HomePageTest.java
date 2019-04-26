package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import inputReader.Xls_Reader;
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
		//http://toolsqa.com/selenium-webdriver/send-reports-automatically-to-email-using-maven-from-eclipse/
	}
	
	@DataProvider(name="HomePageTest")
	public static Object[][] getHomePage()
	{
		//if(Xls_Reader.)
		
		return null;
		
	}

}
