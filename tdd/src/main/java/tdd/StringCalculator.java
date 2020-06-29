package tdd;

import java.util.Objects;

public class StringCalculator {

	public int add(String numbers) {
		if (Objects.isNull(numbers) || numbers.trim().isEmpty())
			return 0;
		int sum = 0;
		String delimiter = ",";
		try {
			if (numbers.startsWith("//")) {
				int newLineIndex = numbers.indexOf("\n");
				delimiter = numbers.substring(2, newLineIndex);
				numbers = numbers.substring(newLineIndex+1,numbers.length());
			}
			numbers = numbers.replace("\n,", ",");
			for (String n : numbers.split(delimiter)) {
				sum = sum + Integer.parseInt(n);
			}
		} catch (Exception e) {
			return 0;
		}
		return sum;
	}

}
