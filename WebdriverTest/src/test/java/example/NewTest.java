package example;		

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;		
public class NewTest {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() {	
			driver.get("http://demo.guru99.com/selenium/guru99home/");  
			System.out.println("Opened URL");
			String title = driver.getTitle();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
			System.out.println("Test testEasy Passed");
		}	
		@Test				
		public void testtwo() {	
			driver.get("http://demo.guru99.com/selenium/guru99home/");  
			System.out.println("Opened URL");
			String title = driver.getTitle();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
			System.out.println("Test testtwo Passed");
		}
		@BeforeMethod
		public void beforeTest() {	
			//System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}		
		@AfterMethod
		public void afterTest() {
			driver.quit();			
		}		
}	