package qualified.io.exam;

import java.util.ArrayList;
import java.util.List;

public class PolishReverseNotation {

	public static void main(String[] args) {
		System.out.println(evaluate(""));
		System.out.println(evaluate("1 2 3.5"));
		System.out.println(evaluate("10000 123 +"));
		System.out.println(evaluate("5 1 2 + 4 * + 3 -"));

	}

	public static double evaluate(String expr) {

		if (expr.length() == 0) {
			return 0;
		}

		List<Double> listValues = new ArrayList<Double>();
		double lastCalculatedValue = 0;

		for (String token : expr.split(" ")) {

			try {
				double value = Double.parseDouble(token);

				listValues.add(value);
				lastCalculatedValue = value;

			} catch (Exception e) {
				// Exception equals an operator

				double lastValue = (double) listValues.remove(listValues.size() - 1);

				double lastButOneValue = (double) listValues.remove(listValues.size() - 1);

				if (token.equals("+")) {
					lastCalculatedValue = lastButOneValue + lastValue;
				}
				if (token.equals("-")) {
					lastCalculatedValue = lastButOneValue - lastValue;
				}
				if (token.equals("*")) {
					lastCalculatedValue = lastButOneValue * lastValue;
				}
				if (token.equals("/")) {
					lastCalculatedValue = lastButOneValue / lastValue;
				}

				listValues.add(lastCalculatedValue);
			}

		}

		return lastCalculatedValue;
	}
}
