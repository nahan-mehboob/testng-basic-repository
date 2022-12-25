package sampleTestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ExplicitWaitTestNG {
	WebDriver driver;


	@Test
	public void verifyWhetherExplicitWaitIsAppliedOrNot() {
		WebElement customerId = driver.findElement(By.name("cusid"));	//assigning the location of customer id search bar
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	//WebDriverWait Instantiated; explicit wait for 10 seconds
		customerId = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("cusid")));	// wait  until presence of customer id is located
		customerId.sendKeys("1111");	//inserted the value into customer id
		WebElement submitButton = driver.findElement(By.name("submit"));	//assigning the value of submit button
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));	//explicit wait for 10 seconds
		//submitButton = wait1.until(ExpectedConditions.elementToBeClickable(By.name("submit")));	//wait until submit button is clicked
		submitButton = wait1.until(ExpectedConditions.elementToBeClickable(submitButton));
		submitButton.click();	//clicking the submit button
	}


	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/delete_customer.php");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	//implicit wait
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
