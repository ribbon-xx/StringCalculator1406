package com.qsoft.longdt;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void shouldReturnZeroOnEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
}
