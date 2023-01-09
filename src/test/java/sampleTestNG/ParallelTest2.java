package sampleTestNG;

import org.testng.annotations.Test;

public class ParallelTest2 {
	@Test
	public void test21() {
		System.out.println("class test21:method test 21: thread id:" +Thread.currentThread().getId());

	}
	@Test
	public void test22() {
		System.out.println("class test22:method test 22: thread id:" +Thread.currentThread().getId());

	}
	@Test
	public void test23() {
		System.out.println("class test23:method test 23: thread id:" +Thread.currentThread().getId());

	}
}



