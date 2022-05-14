package Base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
    public  SoftAssert as = new SoftAssert();
    //public ExtentReports extent;
	//public ExtentTest test;	
	
	  @BeforeSuite
	  public void Setup() throws IOException {
		  FileReader fr = new FileReader("C:\\Users\\SANDESH\\Desktop\\AUTOMATION TESTING\\Selenium\\Project_Retree\\TestAutomationProject\\src\\test\\resources\\ConfigFiles\\config.properties");
		  prop.load(fr);
		  WebDriverManager.chromedriver().setup();
		  //System.setProperty("webdriver,chrome.driver","chromedriver.exe");
		  driver = new ChromeDriver(); 
		  DesiredCapabilities dc = new DesiredCapabilities();
		  dc.setAcceptInsecureCerts(true);	  
	  } 	    
	 @SuppressWarnings("deprecation")
	 @BeforeClass
	 public void LaunchURL() throws IOException {
		 
	  } 
	 @BeforeTest
	 public void setUPReport() 
	 {   
		/*extent = new ExtentReports("test-output/extentReport.html");
		 extent.addSystemInfo("Host Name ","Autoteknic")
		 	   .addSystemInfo("User Name","Sandesh Phadatare")
		 	   .addSystemInfo("Environment", "Automation testing");
		 extent.loadConfig(new File("config.xml"));	*/ 
	 } 
	 @BeforeMethod
	 public void URL() {
		 driver.get(prop.getProperty("url"));	
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	 }
	 @AfterMethod
	 public void getresult() {
		 
	 }
	 @AfterTest
	 public void WindowHandles()
	 {   
		 //extent.flush();
		 //extent.close();
	 } 
	 @AfterSuite
	  public void TearDown() {
	
		  as.assertAll();  
		  driver.quit();
		  System.out.println("Teardown successful");
	  }
}
