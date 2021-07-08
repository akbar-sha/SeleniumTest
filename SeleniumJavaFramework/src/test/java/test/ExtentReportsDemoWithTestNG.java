package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemoWithTestNG {
	ExtentSparkReporter  spark;
	ExtentReports  extent;
	
	WebDriver driver;
	

	@BeforeSuite
	public void setUp() {
		spark = new ExtentSparkReporter("SparkNG.html");

		//ExtentReports extent = new ExtentReports();
		//ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
		//extent.attachReporter(spark);
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(spark);

	
	}
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() throws Exception {
		
		
		
		//create Test
        ExtentTest test = extent.createTest("Google Search Test One", "This test is to validate the google search functionality");
        
        driver.get("https://google.com");
        test.pass("Navigated to Google.com");
        
        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
        

	}
	
	@Test
	public void test2() throws Exception {
		
		//create Test
        ExtentTest test = extent.createTest("Google Search Test One", "This test is to validate the google search functionality");
        
        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
				driver.close();
				driver.quit();
				System.out.println("Test Completed Successfully");
		
	}
	

	@AfterSuite
	public void tearDown () {
		
		// calling flush writes everything to the log file
        extent.flush();

	}
}

