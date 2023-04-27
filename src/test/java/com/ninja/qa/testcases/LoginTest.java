package com.ninja.qa.testcases;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ninja.qa.utils.Utilities;

public class LoginTest extends TestBase {
	

	public LoginTest() throws Exception {
		super();
		
	}
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	private Properties dataprop;
@BeforeMethod
public void setup() {
	driver= initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
	driver.findElement(By.linkText("My Account")).click();
	 driver.findElement(By.linkText("Login")).click();
}
	
	@Test(priority=1)
	public void verifyLoginUsingValidCredentials() {
	driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("validPassword"));
	driver.findElement(By.cssSelector("input.btnbtn-primary")).click();
	softassert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'My Account')]")).isDisplayed());
	softassert.assertAll();
	
	}
	@Test(priority=2)
	public void verifyLoginUsingInValidCredentials() {
	driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataprop.getProperty("invalidPassword"));
	driver.findElement(By.cssSelector("input.btnbtn-primary")).click();
	String actualWarningMessage =driver.findElement(By.xpath("//div[contains(text(),'Warning: Nomatch for Email Addressand/or Password')")).getText();
	String expectedWarningMessage= dataprop.getProperty("wrongcredentialMessage");
	softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning message is not correct");
	
	softassert.assertAll();
	}
	@Test(priority=3)
	public void varifyingLoginWithValidUserNameAndInvalidPassword() {
		
	driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataprop.getProperty("invalidPassword"));
	driver.findElement(By.cssSelector("input.btnbtn-primary")).click();
	String actualWarningMessage =driver.findElement(By.xpath("//div[contains(text(),'Warning: Nomatch for Email Addressand/or Password')")).getText();
	String expectedWarningMessage= dataprop.getProperty("wrongcredentialMessage");
	softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning message is not correct");
			
	softassert.assertAll();
	}
	


@Test(priority=4)
public void varifyingLoginWithInValidUserNameAndValidPassword() {
	driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("validPassword"));
	driver.findElement(By.cssSelector("input.btnbtn-primary")).click();
	String actualWarningMessage =driver.findElement(By.xpath("//div[contains(text(),'Warning: Nomatch for Email Addressand/or Password')")).getText();
	String expectedWarningMessage= dataprop.getProperty("wrongcredentialMessage");
	softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning message is not correct");
			
	softassert.assertAll();

}
@Test(priority=5)
public void varifyingLoginWithInValidUserNameAndEmptyPassword() {
	driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
	driver.findElement(By.cssSelector("input.btnbtn-primary")).click();
	String actualWarningMessage =driver.findElement(By.xpath("//div[contains(text(),'Warning: Nomatch for Email Addressand/or Password')")).getText();
	String expectedWarningMessage= dataprop.getProperty("wrongcredentialMessage");
	softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning message is not correct");
			
	softassert.assertAll();
}
@Test(priority=6)
public void varifyingLoginWithEmptyUserNameAndEmptyPassword() {
	driver.findElement(By.cssSelector("input.btnbtn-primary")).click();
	String actualWarningMessage =driver.findElement(By.xpath("//div[contains(text(),'Warning: Nomatch for Email Addressand/or Password')")).getText();
	String expectedWarningMessage= dataprop.getProperty("wrongcredentialMessage");
	softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning message is not correct");
			
	softassert.assertAll();

}
@Test(priority=7)
public void verifyLoginWithEmptyPasswordboxAndInValidEmail() {
	driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("   ");
	driver.findElement(By.cssSelector("input.btnbtn-primary")).click();
	String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	String expectedWarningMessage = "Warning: No match for Email Addressand/or Password.";
}
@AfterTest
public void driverquite() {
	driver.quit();
}
}