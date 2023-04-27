package com.ninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends TestBase{

	public SearchTest() throws Exception {
		super();
		
	}
public WebDriver driver; 
public SoftAssert softassert = new SoftAssert();
public Select select;

@BeforeMethod 
public void setUp() {
driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
driver.findElement(By.name("search"));
}
@Test(priority=1)
public void verifyEmptySearchProduct() {
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//i[@class=fa fa-search']")).click();
	
	
}
@Test(priority=2)
public void VerifySearchWithValidProduct() {
	driver.findElement(By.name("search")).click();
	driver.findElement(By.cssSelector("button.btn.btn-default")).click();
	Assert.assertTrue(driver.findElement(By.linkText("iPhon")).isDisplayed());
}

}
