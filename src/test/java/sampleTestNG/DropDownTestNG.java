package sampleTestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DropDownTestNG {
	WebDriver driver;


	@Test
	public void verifyTheDropDownValueIsSelelectedByIndexOrNot() {
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		dropdown.click();
		Select select = new Select(dropdown);
		select.selectByIndex(1);	//red is selected using index
	}


	@Test
	public void verifyTheDropDownValueIsSelectedByValueOrNot() {
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		dropdown.click();
		Select select = new Select(dropdown);
		select.selectByValue("Yellow");	//yellow is selected using value
	}



	@Test
	public void verifyTheDropDownValueIsSelectedByVisibleTextOrNot() {
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		dropdown.click();
		Select select = new Select(dropdown);
		select.selectByVisibleText("Green");	//green selected using visible text method
	}


	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/select-input.php");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait
	}


	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
