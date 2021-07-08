import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) {
	
		String projectPath = System.getProperty("user.dir");
				
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("ABCD");
		
		driver.findElement(By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.ikrT4e.om7nvf:nth-child(3) div:nth-child(1) div.A8SBwf:nth-child(1) div.FPdoLc.lJ9FBc:nth-child(4) center:nth-child(1) > input.gNO89b:nth-child(1)"));
	
	    driver.close();
	    driver.quit();
	
	}

}
