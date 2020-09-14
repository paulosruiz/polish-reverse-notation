package qualified.io.exam;

import java.util.Stack;

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

		final Stack<Double> stackValues = new Stack<Double>();

		double lastCalculatedValue = 0;

		for (String token : expr.split(" ")) {

			try {
				double value = Double.parseDouble(token);

				stackValues.push(value);
				lastCalculatedValue = value;

			} catch (Exception e) {
				// Exception equals an operator

				double lastValue = stackValues.pop();
				double lastButOneValue = stackValues.pop();

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

				stackValues.push(lastCalculatedValue);
			}

		}

		return lastCalculatedValue;
	}
}
