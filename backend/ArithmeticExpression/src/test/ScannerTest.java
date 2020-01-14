package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.scanner.SymbolScannerException;



class ScannerTest {

	@Test
	void SymbolScanner() throws SymbolScannerException {
		model.scanner.SymbolScanner scanner = new model.scanner.SymbolScanner();
		assertEquals("[1]", scanner.toSymbolSequence("1").toString());
		assertEquals("[1, +, 2]", scanner.toSymbolSequence("1+  2").toString());
		assertEquals("[1]", scanner.toSymbolSequence("   1    ").toString());
		assertEquals("[1, *]", scanner.toSymbolSequence("  1  * ").toString());
		assertEquals("[(, (, (, 1]", scanner.toSymbolSequence("   ( ((  1").toString());
		assertEquals("[+, (, (]", scanner.toSymbolSequence(" + (   (").toString());
		assertEquals("[1, 12, +, 14, 5]", scanner.toSymbolSequence(" 1  12+   14     5  ").toString());
		assertEquals("[x]", scanner.toSymbolSequence("x").toString());
		assertEquals("[3, +, y, x, x]", scanner.toSymbolSequence("3 + y   xx  ").toString());
	}
}
