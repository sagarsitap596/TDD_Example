package tdd;

import java.util.Objects;

public class StringCalculator {

	public int add(String numbers) {
		if (Objects.isNull(numbers) || numbers.trim().isEmpty())
			return 0;
		int sum = 0;
		try {
			numbers = numbers.replace("\n,", ",");
			for (String n : numbers.split(",")) {
				sum = sum + Integer.parseInt(n);
			}
		} catch (Exception e) {
			return 0;
		}
		return sum;
	}

}
