package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.parser.SymbolParserException;
import model.parser.symbolParser.ExpressionParser;
import model.scanner.SymbolScanner;
import model.scanner.SymbolScannerException;

class SymbolParser {

	@Test
	void test() throws SymbolParserException, SymbolScannerException {

		assertEquals(56, new ExpressionParser()
				.toRegularExpression(new SymbolScanner().toSymbolSequence("((4 + 4) * (((3))   + (4)))")).evaluate());

	}

}
