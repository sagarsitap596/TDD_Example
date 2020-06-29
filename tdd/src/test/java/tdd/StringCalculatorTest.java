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

}
