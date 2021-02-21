package example;		

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class NewClass {		
	   	
		@Test				
		public void testNoofcircuits2017() {
			
			given().
			when().
			get("http://ergast.com/api/f1/2017/circuits.json").
			then().
			assertThat().
			statusCode(200).
			and().

			body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
			System.out.println("Test rest assured Passed");
			
		}
}