package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver; 

	//this constructor will be called when we create the object of this class into the test class
	public LoginPage(WebDriver driver) { //this driver is the actual driver from the test class
		this.driver = driver; //this keyword is used to initialize the local driver of the page class by using actual driver of the test class
		PageFactory.initElements(driver, this); //initElements is a static method inside the PageFactory class which is used to initialize the webelements
	}


	//locating username element
	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	//locating password element
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	//locating sign in
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signIn;

	//locating user login
	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	WebElement adminName;


	//performing action in username
	public void enterUserName() {
		userName.sendKeys("admin");
	}

	//performing actions in password
	public void enterPassword() {
		password.sendKeys("admin");
	}

	//performing actions in sign in 
	public void clickOnSignInButton() {
		signIn.click();
	}

	//performing actions in user login
	public boolean isAdminNameDisplayed() {
		Boolean actualResult = adminName.isDisplayed();
		return actualResult;
		//return adminName.isDisplayed();
	}

	//performing actions in user login 	//this is used in assetEquals case
	public String getTextOfAdminName() {
		return adminName.getText();
	}





}
