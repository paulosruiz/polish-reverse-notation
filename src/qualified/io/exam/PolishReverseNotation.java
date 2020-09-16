package qualified.io.exam;

import java.util.Stack;

public class PolishReverseNotation {

	public static double evaluate(String expr) {
		
		if (expr.isEmpty()) {
			return 0;
		}
		final Stack<Double> stackValues = new Stack<Double>();

		for (String token : expr.split(" ")) {

			if (isSign(token)) {
				Double first = stackValues.pop();
				Double second = stackValues.pop();
				Double sol = (double) 0;
				if (isAdd(token)) {
					sol = first + second;
				} else if (isMult(token)) {
					sol = first * second;
				} else if (isSub(token)) {
					sol = second - first;
				} else {
					sol = second / first;
				}
				stackValues.push(sol);
			} else {
				stackValues.push(Double.parseDouble(token));
			}

		}

		return stackValues.pop();
	}

	private static boolean isSign(String value) {
		return isAdd(value) || isMult(value) || isSub(value) || isDiv(value);
	}

	private static boolean isAdd(String value) {
		return "+".equals(value);
	}

	private static boolean isMult(String value) {
		return "*".equals(value);
	}

	private static boolean isSub(String value) {
		return "-".equals(value);
	}

	private static boolean isDiv(String value) {
		return "/".equals(value);
	}
}
