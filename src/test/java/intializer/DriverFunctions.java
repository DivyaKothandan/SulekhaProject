package intializer;

public class DriverFunctions extends Initializer {
	
	
	
	public static void loadUrl()
	{
		wd.get(envProp.getProperty("URL"));
		wd.manage().window().maximize();
	}

}
