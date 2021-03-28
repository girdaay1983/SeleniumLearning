package example;		

import java.io.BufferedReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;		
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonfiles.jasonvars;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class NewClass extends jasonvars{		
	   	
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
		
		@Test				
		public void TEST_2()  {
			
			RestAssured.baseURI= "https://rahulshettyacademy.com";
			String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body(jasonvars.test2json).when().post("maps/api/place/add/json")
			.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
			.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
			System.out.println(jasonvars.test2json);
			System.out.println(response);
			JsonPath js=new JsonPath(response); //for parsing Json
			String placeId=js.getString("place_id");
			System.out.println(placeId);
			
			//Update Place
			String newAddress = "Summer Walk, Africa";
			
			given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body("{\r\n" + 
					"\"place_id\":\""+placeId+"\",\r\n" + 
					"\"address\":\""+newAddress+"\",\r\n" + 
					"\"key\":\"qaclick123\"\r\n" + 
					"}").
			when().put("maps/api/place/update/json")
			.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
			
			//Get Place
			
		String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
			.queryParam("place_id",placeId)
			.when().get("maps/api/place/get/json")
			.then().assertThat().log().all().statusCode(200).extract().response().asString();
		JsonPath js1=new JsonPath(getPlaceResponse); 
		String actualAddress =js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, "Summer Walk, Africa");
		//Cucumber Junit, Testng
			
		}
		
		
}