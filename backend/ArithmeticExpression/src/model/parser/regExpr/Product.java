package model.parser.regExpr;

import model.parser.SymbolParserException;
import model.parser.operations.binaryOperations.Multiplication;

public class Product implements Summand {

	private RegExpr summand;
	private RegExpr factor;

	public Product(RegExpr regExpr, RegExpr regExpr2) {
		super();
		this.summand = regExpr;
		this.factor = regExpr2;
	}

	@Override
	public Integer evaluate() throws SymbolParserException {
		return Multiplication.INSTANCE.calculate(this.summand, this.factor);
	}

}
