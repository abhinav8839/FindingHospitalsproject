package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;

	@BeforeClass
	@Parameters({ "browser", "os" })
	public void setup(String browser, String os) throws IOException {
		// setting properties
		prop = new Properties();
//		FileInputStream file = new FileInputStream(
//				"C:\\Users\\2303507\\eclipse-workspace\\FindingHospitalsHackathonProject 1\\FindingHospitalsHackathonProject\\src\\test\\resources\\config.properties");
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		
		prop.load(file);
		ChromeOptions chromeoption=new ChromeOptions();
		chromeoption.addArguments("--disable-notifications");
		
		// Loading log4j file
		logger = LogManager.getLogger(this.getClass());
 
		EdgeOptions edgeoption=new EdgeOptions();
		edgeoption.addArguments("--disable-notifications");
				
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
			 	{	
				DesiredCapabilities capabilities=new DesiredCapabilities();
				//os
				if(os.equalsIgnoreCase("windows"))
				{
					capabilities.setPlatform(Platform.WIN11);
				}
				else if(os.equalsIgnoreCase("mac"))
				{
					capabilities.setPlatform(Platform.MAC);
				}
				else
				{
					System.out.println("No matching os..");
					return;
				}
				//browser
				switch(browser.toLowerCase())
				{
				case "chrome" : capabilities.setBrowserName("chrome"); break;
				case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
				default: System.out.println("No matching browser.."); return;
				}
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			    }
		 
			    //If execution_env is local then run in local system
				else if(prop.getProperty("execution_env").equalsIgnoreCase("local"))
				{
					//launching browser based on condition - locally
					switch(browser.toLowerCase())
					{
					case "chrome": driver=new ChromeDriver(chromeoption); break;
					case "edge": driver=new EdgeDriver(edgeoption); break;
					default: System.out.println("No matching browser..");
								return;
					}
				}

		// setting webDriver
//		if (browser.equalsIgnoreCase("chrome"))
//			driver = new ChromeDriver();
//		else if (browser.equalsIgnoreCase("edge"))
//			driver = new EdgeDriver();
//		else
//			System.out.println("Invalid browser name");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null;
	}
	
	public void takeSnapshot(WebDriver driver, String photoName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir")+"\\screenshots\\"+photoName+".png");
		FileUtils.copyFile(src, trg);
	}

	public static String captureScreen(String name) {
//		String timeStamp = new SimpleDateFormat().format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String targetPath = System.getProperty("user.dir")+"\\extentScreenshots\\+"+name+".png";
		File trg = new File(targetPath);
		
		src.renameTo(trg);
		return targetPath;
	}
}
