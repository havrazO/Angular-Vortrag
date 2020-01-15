package model.parser.regExpr;

import model.parser.SymbolParserException;
import model.parser.operations.binaryOperations.Multiplication;

public class Product implements Summand {

	private RegExpr arg1;
	private RegExpr arg2;

	public Product(RegExpr regExpr, RegExpr regExpr2) {
		super();
		this.arg1 = regExpr;
		this.arg2 = regExpr2;
	}

	@Override
	public Integer evaluate() throws SymbolParserException {
		return Multiplication.INSTANCE.calculate(this.arg1, this.arg2);
	}

}
