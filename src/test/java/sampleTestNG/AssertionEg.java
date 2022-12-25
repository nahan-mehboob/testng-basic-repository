package sampleTestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AssertionEg {
	WebDriver driver;


	@Test(priority = 1)
	public void verifyTheWebPageIsLoadedWhileHittingTheUrl() {
		WebElement logo = driver.findElement(By.xpath("(//img[@src='images/logo.png'])[1]")); 	//assigned the location of logo 
		Boolean actualResult = logo.isDisplayed();	//assigning the verification to actualResult
		//Assert.assertTrue(actualResult);	//here test case passes //if the boolean value(actualResult) is true, test case passes, if boolean value is false test case fails
		//Assert.assertFalse(actualResult); //here it fails since actual result is true, actualResult has to be false inorder for this to pass
		Assert.assertTrue(actualResult,"Logo is not displayed");	//msg will be displayed only if the test case fails
	}


	@Test(priority = 2)
	public void verifyHomeTabIsDisplayedOrNot() {
		WebElement homeTab = driver.findElement(By.xpath("//a[text()='Home']")); 	//assigned the location for home tab
		String expectedResult = "HOME"; //giving expected result directly
		String actualResult = homeTab.getText(); //giving actual result as the location of element
		Assert.assertEquals(expectedResult, actualResult, "home is not displayed"); 	//verifying the expected result is equal to actual result, if not equal the message will be displayed
	}

	@Test
	public void verifyTheDriverIsNullOrNot() {
		//Assert.assertNull(driver);//fails since driver value is not null 
		Assert.assertNotNull(driver);
	}


	//soft assert
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void verifyTheDriverIsNullOrNot2() {
		//Assert.assertNull(driver);//fails since driver value is not null 
		softAssert.assertNotNull(driver); //passes since assert value is not null
		softAssert.assertAll(); 	//to view the exception
	}


	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");	//launched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait
	}


	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
