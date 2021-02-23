package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTest {
	WebDriver driver;
	String ChromeDriverPath = "F:\\tools\\chromedriver.exe";
	
	@BeforeTest
	public void intialize() {
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
	
	@Test
	public void sampleTest() {
		driver.get("https://www.selenium.dev/");
		String expectedResult = "Documentation";
		String actualResult = driver.findElement(By.xpath("(//a[@href='/documentation'])[1]")).getText();
		
		if(expectedResult.equalsIgnoreCase(actualResult)) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}
