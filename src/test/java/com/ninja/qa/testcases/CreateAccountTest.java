package com.ninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTest extends TestBase {

	public CreateAccountTest() throws Exception {
		super();
		
	}
public WebDriver driver;
public SoftAssert softassert = new SoftAssert();
public Select select;


@BeforeMethod 
public void setUp() {
	driver = initializeBrowserAndOpenApplication("chrome");
	driver.findElement(By.linkText("My Account")).click();
	driver.findElement(By.linkText("Register")).click();
}
@Test(priority =1)
public void enterAllValidFields() {
	driver.findElement(By.xpath("//input[@id = 'input-firstname']")).sendKeys("Nipa");
	driver.findElement(By.xpath("//input[@id = 'input-lastname']")).sendKeys("Afroze");
	driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys("nipa.afroze1@gmail.com");
	driver.findElement(By.xpath("//input[contains(@id,'input-telephone')]")).sendKeys("1234567");
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Ninja@123");
	driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Ninja@123");
	driver.findElement(By.xpath("//input[@name='agree']")).click();
	driver.findElement(By.xpath("//div[@class='pull-right']/child::input[2]")).click();
	
	softassert.assertAll();
	
}
@Test(priority=2)
public void verifyRegistrayionWithEmptyFirstNameFields() {
	driver.findElement(By.xpath("//input[@id = 'input-firstname']")).sendKeys(" ");
	driver.findElement(By.xpath("//input[@id = 'input-lastname']")).sendKeys("Afroze");
	driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys("nipa.afroze1@gmail.com");
	driver.findElement(By.xpath("//input[contains(@id,'input-telephone')]")).sendKeys("1234567");
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Ninja@123");
	driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Ninja@123");
	driver.findElement(By.xpath("//input[@name='agree']")).click();
	driver.findElement(By.xpath("//div[@class='pull-right']/child::input[2]")).click();
	String actualFirstNameInputWarningText = driver.findElement(By.xpath("//div[contains(text(),'First Name']")).getText();
	String expectedFirstNameInputWarningText="First Name must be between 1 and 32 characters!";
	softassert.assertTrue(actualFirstNameInputWarningText.equals(expectedFirstNameInputWarningText),"Warning message is not correct");
	softassert.assertAll();
}
@Test(priority=3)
public void verifyRegistrayionWithEmptyLastNameFields() {
	driver.findElement(By.xpath("//input[@id = 'input-firstname']")).sendKeys("Nipa ");
	driver.findElement(By.xpath("//input[@id = 'input-lastname']")).sendKeys("  ");
	driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys("nipa.afroze1@gmail.com");
	driver.findElement(By.xpath("//input[contains(@id,'input-telephone')]")).sendKeys("1234567");
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Ninja@123");
	driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Ninja@123");
	driver.findElement(By.xpath("//input[@name='agree']")).click();
	driver.findElement(By.xpath("//div[@class='pull-right']/child::input[2]")).click();
	String actualLastNameInputWarningText = driver.findElement(By.xpath("//div[contains(text(),'Last Name']")).getText();
	String expectedLastNameInputWarningText="Last Name must be between 1 and 32 characters!";
	softassert.assertTrue(actualLastNameInputWarningText.equals(expectedLastNameInputWarningText),"Warning message is not correct");
	softassert.assertAll();

}

@Test(priority=4)
public void verifyRegistrationWithEmptyFields() {
	driver.findElement(By.xpath("//input[@id = 'input-firstname']")).sendKeys(" ");
	driver.findElement(By.xpath("//input[@id = 'input-lastname']")).sendKeys("  ");
	driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys("nipa.afroze1@gmail.com");
	driver.findElement(By.xpath("//input[contains(@id,'input-telephone')]")).sendKeys("   ");
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Ninja@123");
	driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Ninja@123");
	driver.findElement(By.xpath("//input[@name='agree']")).click();
	driver.findElement(By.xpath("//div[@class='pull-right']/child::input[2]")).click();
	String actualFirstNameInputWarningText = driver.findElement(By.xpath("//div[contains(text(),'First Name']")).getText();
	String expectedFirstNameInputWarningText="First Name must be between 1 and 32 characters!";
	softassert.assertTrue(actualFirstNameInputWarningText.equals(expectedFirstNameInputWarningText),"Warning message is not correct");
	String actualLastNameInputWarningText = driver.findElement(By.xpath("//div[contains(text(),'Last Name']")).getText();
	String expectedLastNameInputWarningText="Last Name must be between 1 and 32 characters!";
	softassert.assertTrue(actualLastNameInputWarningText.equals(expectedLastNameInputWarningText),"Warning message is not correct");
	softassert.assertAll();

}

@Test(priority =5)
public void verifyRegistrationWithEmptyUsernameAndTelephoneWithValidFirstNameLastNamePassword() {
	driver.findElement(By.xpath("//input[@id = 'input-firstname']")).sendKeys("Nipa ");
	driver.findElement(By.xpath("//input[@id = 'input-lastname']")).sendKeys("Afroze");
	driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys("   ");
	driver.findElement(By.xpath("//input[contains(@id,'input-telephone')]")).sendKeys("   ");
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Ninja@123");
	driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Ninja@123");
	driver.findElement(By.xpath("//input[@name='agree']")).click();
	driver.findElement(By.xpath("//div[@class='pull-right']/child::input[2]")).click();
	String actualEmailInputWarningText = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
	String expectedEmailInputWarningText="E-Mail Address does not appear to be valid!";
	softassert.assertTrue(actualEmailInputWarningText.equals(expectedEmailInputWarningText),"Warning message is not correct");
	softassert.assertAll();

}
}

	

