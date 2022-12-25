package sampleTestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AlertHandlingTestNG {
	WebDriver driver;


	@Test(priority = 1)
	public void verifyTheAlertIsAcceptedOrNot() {
		WebElement customerId = driver.findElement(By.name("cusid"));	//assigning the location of customer id search bar
		customerId.sendKeys("1111");	//inserting the value in the search bar
		WebElement submitButton = driver.findElement(By.name("submit"));	//assigning the value of submit button
		submitButton.click();	//clicking the submit button
		driver.switchTo().alert().accept();	//clicks the OK button of the first alert
	}


	@Test(priority = 2)
	public void verifyTheMessageOfTheSecondAlert() {
		WebElement customerId = driver.findElement(By.name("cusid"));	//assigning the location of customer id search bar
		customerId.sendKeys("1111");	//inserting the value in the search bar
		WebElement submitButton = driver.findElement(By.name("submit"));	//assigning the value of submit button
		submitButton.click();	//clicking the submit button
		driver.switchTo().alert().accept();	//clicks the OK button of the first alert
		System.out.println(driver.switchTo().alert().getText());	//gets the message of the second alert
	}


	@Test(priority = 3)
	public void verifyTheSecondAlertIsDismissedOrNot() {
		WebElement customerId = driver.findElement(By.name("cusid"));	//assigning the location of customer id search bar
		customerId.sendKeys("1111");	//inserting the value in the search bar
		WebElement submitButton = driver.findElement(By.name("submit"));	//assigning the value of submit button
		submitButton.click();	//clicking the submit button
		driver.switchTo().alert().accept();	//clicks the OK button of the first alert
		driver.switchTo().alert().dismiss();	//clicks the ok button of the second alert
	}


	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/delete_customer.php");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait
	}


	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
