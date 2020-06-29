package tdd;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

	private final List<Character> specialCharacters = Arrays.asList('-', '+', '/', '*', 'x', '^', 'X');
	private final String DELIMITER = ",";
	private final String NEW_LINE = "\n";
	private final String START_SINGLE_DELIMITER = "//";
	private final String START_MULTI_DELIMITER = "//[";

	public int add(String numbers) {
		if (Objects.isNull(numbers) || numbers.trim().isEmpty())
			return 0;
		String delimiter = "";
		if (numbers.startsWith(START_MULTI_DELIMITER)) {
			numbers = numbers.replace("][", "");
			int newLineIndex = numbers.indexOf("]\n");
			String delm = numbers.substring(3, newLineIndex);
			for (Character ch : delm.toCharArray()) {
				numbers = numbers.replace("" + ch, DELIMITER);
				delimiter = delimiter + DELIMITER;
			}
			numbers = numbers.substring(newLineIndex + 1, numbers.length()).trim();
		} else if (numbers.startsWith(START_SINGLE_DELIMITER)) {
			int newLineIndex = numbers.indexOf(NEW_LINE);
			String delm = numbers.substring(2, newLineIndex);
			numbers = numbers.replace(delm, DELIMITER);
			numbers = numbers.substring(newLineIndex + 1, numbers.length()).trim();
			delimiter = DELIMITER;
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

	public static void main(String[] args) {
		String s = "1***2***3";
		s.split("\\*\\*\\*");
	}

}
