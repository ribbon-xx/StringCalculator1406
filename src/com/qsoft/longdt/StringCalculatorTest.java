package com.qsoft.longdt;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void shouldReturnZeroOnEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void shouldReturnNumberOnNumberInput() {
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void shouldReturnWithCommaDelim() {
		assertEquals(3, StringCalculator.add("1,2"));
	}
}
