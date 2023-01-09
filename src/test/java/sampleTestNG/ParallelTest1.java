package sampleTestNG;

import org.testng.annotations.Test;

public class ParallelTest1 {
	@Test
	public void testa() {
		System.out.println("class testa:method test 1: thread id:" +Thread.currentThread().getId());

	}
	@Test
	public void testb() {
		System.out.println("class testb:method test 2: thread id:" +Thread.currentThread().getId());

	}
	@Test
	public void testc() {
		System.out.println("class testc:method test 3: thread id:" +Thread.currentThread().getId());

	}
}

