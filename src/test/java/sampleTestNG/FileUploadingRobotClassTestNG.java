package sampleTestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class FileUploadingRobotClassTestNG {
	WebDriver driver;


	@Test
	public void verifyFileUploadingIsSuccessOrNot() throws AWTException {
		WebElement browseBtn = driver.findElement(By.xpath("//*[text()='Browse']"));
		browseBtn.click();

		// creating object of Robot class 		
		Robot rb = new Robot();  		

		// Store the File path to the StringSelection class 		
		StringSelection filePath = new StringSelection("C:\\Users\\admin\\Downloads\\Notes 8-11.docx");  		

		//Copy above path to clipboard 		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);  		

		// press Contol+V for pasting 		
		rb.keyPress(KeyEvent.VK_CONTROL); 
		rb.keyPress(KeyEvent.VK_V);  		

		// release Contol+V for pasting 		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("file uploaded..");
	}


	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://resume.naukri.com/resume-quality-score");	//launched the url
		driver.manage().window().maximize();	//maximized the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait
	}


	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
