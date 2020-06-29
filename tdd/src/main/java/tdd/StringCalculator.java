package tdd;

import java.util.Objects;

public class StringCalculator {

	public int add(String numbers) {
		if (Objects.isNull(numbers) || numbers.trim().isEmpty())
			return 0;
		String delimiter = ",";
		if (numbers.startsWith("//")) {
			int newLineIndex = numbers.indexOf("\n");
			delimiter = numbers.substring(2, newLineIndex);
			numbers = numbers.substring(newLineIndex + 1, numbers.length());
		}
		numbers = numbers.replace("\n,", ",");
		int sum = 0;
		StringBuilder negativeNumbers = new StringBuilder();
		for (String n : numbers.split(delimiter)) {
			int num = Integer.parseInt(n);
			if (num < 0) {
				negativeNumbers.append(num + "  ");
			} else if (num <= 1000) {
				sum = sum + num;
			}

		}
		if (!negativeNumbers.toString().isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed - " + negativeNumbers.toString());
		}
		return sum;
	}

}
