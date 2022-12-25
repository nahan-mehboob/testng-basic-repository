package ExecuteClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;

public class ExecuteLoginPage extends BaseClass {
  @Test
  public void verifySuccessfulLogin() {
	  LoginPage lp = new LoginPage(driver); //while creating this object, the constructor of page class will be invoked
	  lp.enterUserName();
	  lp.enterPassword();
	  lp.clickOnSignInButton();
	  
	  //using assert true
	  //Boolean actualResult = lp.isAdminNameDisplayed();
	  //Assert.assertTrue(actualResult);
	  Assert.assertTrue(lp.isAdminNameDisplayed());
	  
	  //using assert equals
//	  String expectedResult = "Admin";
//	  String actualResult = lp.getTextOfAdminName();
//	  Assert.assertEquals(actualResult, expectedResult);
  }
}
