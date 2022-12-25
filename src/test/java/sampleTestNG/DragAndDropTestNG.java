package sampleTestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DragAndDropTestNG {
	WebDriver driver;


	@Test
	public void verifyTheDragAndDropIsPerformedOrNot() {
		Actions actions = new Actions(driver);
		WebElement amount5000Source = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));	//source
		WebElement amount5000Destination = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]")); 	//destination
		actions.dragAndDrop(amount5000Source, amount5000Destination).build().perform(); 	//dragging and dropping source and destination
	}


	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait
	}


	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
