import org.testng.annotations.Test;

import sampleTestNG.DataProviderEg;

public class NewTest {
	
	@Test(dataProvider = "dp", dataProviderClass = DataProviderEg.class)
	  public void f(Integer n, Integer s) {
		  System.out.println(n+s);
	  }
 
}
