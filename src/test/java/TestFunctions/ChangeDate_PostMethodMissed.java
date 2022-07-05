package TestFunctions;

import java.sql.SQLException;
import java.util.Date;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.sun.xml.fastinfoset.sax.Properties;

import Common.BaseClass;
import Common.ExtentManager;
import Common.Read_OTP;
import Common.StringHelper;
import Pages.LoginPage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ChangeDate_PostMethodMissed {

	

	public static String token=null;
	@Test(priority = 1)
	public void login_method() {
		
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("email", "automationadmin@mailinator.com");
		json.put("password", "654321AA");
		json.put("userType", "admin");
		
		request.body(json.toJSONString());
		Response responsefromLogin = request.post("http://192.168.0.7:9001/userLogin");
		responsefromLogin.prettyPrint();
		
		String jsonString = responsefromLogin.getBody().asString();
	    token = JsonPath.read(jsonString, "token");
	    System.out.println(token);
		
	}
	
	@Test(priority = 2)
	public void changedate_method() {
		
		RequestSpecification request = RestAssured.given();

		request.header("Authorization",token).header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("name", "Test Automation Missed Session Request");
		json.put("start", "2021-05-01 18:30:00");
		json.put("end", "2021-05-01 20:30:00");
		
		request.body(json.toJSONString());
		Response responseafterUpdate = request.post("http://192.168.0.7:9001/updatesessiontimes");
		
	}

}
