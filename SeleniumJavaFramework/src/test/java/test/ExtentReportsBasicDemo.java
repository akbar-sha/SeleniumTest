package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBasicDemo {
	
	public static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");

		//ExtentReports extent = new ExtentReports();
        //ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
        //extent.attachReporter(spark);
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        
        //create Test
        ExtentTest test1 = extent.createTest("Google Search Test One", "This test is to validate the google search functionality");
        
        String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation Implied");
		test1.pass("Entered text in searchbox");
		
		driver.findElement(By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.ikrT4e.om7nvf:nth-child(3) div:nth-child(1) div.A8SBwf:nth-child(1) div.FPdoLc.lJ9FBc:nth-child(4) center:nth-child(1) > input.gNO89b:nth-child(1)"));
        test1.pass("Pressed Enter Key");
        
        driver.close();
        driver.quit();
        test1.pass("Closed the browser");
        
        test1.info("Test Completed");
        
        extent.flush();
        
        
	}

}
