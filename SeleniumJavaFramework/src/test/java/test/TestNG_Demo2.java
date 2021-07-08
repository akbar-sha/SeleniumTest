package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {
	
	WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void googleSearch2() {
			
		
		//goto Google.com
		driver.get("https://google.com");
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Implied");
		
		
		//click on search button
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.ikrT4e.om7nvf:nth-child(3) div:nth-child(1) div.A8SBwf:nth-child(1) div.FPdoLc.lJ9FBc:nth-child(4) center:nth-child(1) > input.gNO89b:nth-child(1)"));
		
			
	}
	
	@Test
	public void googleSearch3() {
			
		
		//goto Google.com
		driver.get("https://google.com");
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Implied");
		
		
		//click on search button
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.ikrT4e.om7nvf:nth-child(3) div:nth-child(1) div.A8SBwf:nth-child(1) div.FPdoLc.lJ9FBc:nth-child(4) center:nth-child(1) > input.gNO89b:nth-child(1)"));
		
			
	}
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
				driver.close();
				driver.quit();
				System.out.println("Test Completed Successfully");
		
	}

}
