package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import inputReader.ReadExcel;
import inputReader.WriteExcel;
import intializer.Initializer;

public class SulekhaHomePage extends Initializer{

	public static void validateSearch() throws InterruptedException, IOException {
		
		
		/*The excel sheet is located at the project folder "Files" with name 
          SulekhaData.xlsx.The sheet name is 'data' and the columns are
          City and Keyword */ 
		
		ReadExcel obj = new ReadExcel("D:/Workspace/Sulekha/src/test/java/inputReader/SulekhaData.xlsx");
		
		
		
		
		//Reading 'Chentrappinni' from excel
		String city=obj.getCellData("data","City", 2);  //2 is the row number
		
		
		//Reading 'Apartments & Flats' from excel
		String searchItem=obj.getCellData("data", "KeyWord", 2);
		
		
		/*
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/workspace/Sulekha/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.sulekha.com/");*/
		
		WebElement cityButton=wd.findElement(By.cssSelector("div.hp-city.sdropdown"));
		cityButton.click();
		
		WebElement searchBox_City=wd.findElement(By.xpath("(//input[@class='sinput'])[2]"));
		
		searchBox_City.sendKeys("Chen");
		
		
		
		//List<WebElement> cities= driver.findElements(By.xpath("//ul[@class='ac-menu ']//li"));
		List<WebElement> cities= wd.findElements(By.xpath("/html/body/div[1]/section[1]/div[2]/div[1]/div[1]/div/div[2]/ul"));
		
		
			
		for(int i=0;i< cities.size();i++)
		{
			if(cities.get(i).getText().equalsIgnoreCase(city))
			{
				cities.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		
		WebElement searchBox=wd.findElement(By.cssSelector("[placeholder='Find your service here']"));
		searchBox.click();
		
		List<WebElement> options= wd.findElements(By.cssSelector("ul.ac-menu.ac-float>li"));
		
		System.out.println(wd.getTitle());
	
		wd.quit();
		
			
		
		
		
		

	}

}
