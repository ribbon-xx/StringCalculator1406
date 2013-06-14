package com.qsoft.longdt;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

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

	@Test
	public void shouldReturnExceptionWithNegativeNumber() {
		exception.expect(NumberFormatException.class);
		exception.expectMessage("negatives not allowed -5");
		StringCalculator.add("1,3,-5");
	}
	
	@Test
	public void shouldReturnWithDelimDefine() {
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
}
