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

public class FileUploadingSendKeysTestNG {
	WebDriver driver;


	@Test
	public void verifyFileUploadingIsSuccessOrNot() {
		WebElement chooseFile = driver.findElement(By.name("uploadfile_0"));	//assigning the location of choose file button
		chooseFile.sendKeys("C:\\Users\\admin\\Downloads\\Notes 8-11.docx");	//uploading this file
		WebElement submitFileBtn = driver.findElement(By.id("submitbutton"));	//assigning the location of submit button
		submitFileBtn.click();	//clicking on submit button
	}


	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");	//lauched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait
	}


	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
