package model.parser.operations.binaryOperations;

import model.parser.SymbolParserException;
import model.parser.regExpr.RegExpr;

public class Multiplication implements BinaryOperator {

	public static final Multiplication INSTANCE = new Multiplication();

	private Multiplication() {
	}

	@Override
	public Integer calculate(RegExpr x1, RegExpr x2) throws SymbolParserException {
		return x1.evaluate() * x2.evaluate();
	}

}
