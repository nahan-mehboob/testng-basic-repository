package sampleTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationEgtestNG {

	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class executed");
	}

	@Test
	public void testCase1() {
		System.out.println("First test case is executed!");
	}

	@Test
	public void testCase2() {
		System.out.println("Second test case is executed!"); 
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test executed");
	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("After test executed");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After class executed");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}
}
