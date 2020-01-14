package model.parser.operations.binaryOperations;

import model.parser.SymbolParserException;
import model.parser.regExpr.RegExpr;

public class Addition implements BinaryOperator {
	
	public static final Addition INSTANCE = new Addition();

	private Addition() {
	}
	
	@Override
	public Integer calculate(RegExpr x1, RegExpr x2) throws SymbolParserException {
		return x1.evaluate() + x2.evaluate();
	}

}
