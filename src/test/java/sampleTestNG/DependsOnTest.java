package sampleTestNG;

import org.testng.annotations.Test;


public class DependsOnTest { 

	@Test(dependsOnMethods= {"openBrowser"})
	public void signIn() { 
		System.out.println("This will execute second (Signin)"+Thread.currentThread().getId());
	} 

	@Test 
	public void openBrowser() { 
		System.out.println("This will execute first (OpenBrowser)"+Thread.currentThread().getId()); 
	} 
}