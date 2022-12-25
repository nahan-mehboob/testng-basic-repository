package sampleTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderEg {
  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, 2},
      new Object[] { 2, 5 },
    };
  }
  
  @Test(dataProvider = "dp")
  public void f(Integer n, Integer s) {
	  System.out.println(n+s);
  }
}
