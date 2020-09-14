package qualified.io.exam;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void testEvaluate() {
		assertEquals(0, PolishReverseNotation.evaluate(""));
		assertEquals(3.5, PolishReverseNotation.evaluate("1 2 3.5"));
		assertEquals(10123, PolishReverseNotation.evaluate("10000 123 +"));

		assertEquals(14, PolishReverseNotation.evaluate("5 1 2 + 4 * + 3 -"));

	}

}
