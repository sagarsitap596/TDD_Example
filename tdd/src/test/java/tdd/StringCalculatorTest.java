package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	StringCalculator stringCalculator = new StringCalculator();

	@Test
	public void testEmptyString() {
		int sum = stringCalculator.add("");
		assertEquals(0, sum);
	}

	@Test
	public void testNullString() {
		int sum = stringCalculator.add(null);
		assertEquals(0, sum);
	}

	@Test
	public void testOneNumberSum() {
		int sum = stringCalculator.add("4");
		assertEquals(4, sum);
	}

	@Test
	public void testTwoNumberSum() {
		int sum = stringCalculator.add("4,8");
		assertEquals(12, sum);
	}

	@Test
	public void testThreeNumberSum() {
		int sum = stringCalculator.add("4,8,8");
		assertEquals(20, sum);
	}

	@Test
	public void testEightNumberSum() {
		int sum = stringCalculator.add("4,8,8,5,2,11,23,56");
		assertEquals(117, sum);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnegativeNumberSum() {
		int sum = stringCalculator.add("4,8,8,5,2,11,23,-1,-6,56,-8");
	}

	@Test
	public void testNewLineBetweenNumbers() {
		int sum = stringCalculator.add("4\n,8");
		assertEquals(12, sum);
	}

	@Test(expected = NumberFormatException.class)
	public void testNewLineAtEnd() {
		int sum = stringCalculator.add("4,\n");
	}

	@Test
	public void testNewDelimiter() {
		int sum = stringCalculator.add("//;\n1;2");
		assertEquals(3, sum);
	}

	@Test
	public void testNewDelimiter2() {
		int sum = stringCalculator.add("//~~\n1~~2");
		assertEquals(3, sum);
	}

}
