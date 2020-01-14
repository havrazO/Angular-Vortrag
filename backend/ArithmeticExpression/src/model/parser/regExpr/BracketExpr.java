package model.parser.regExpr;

import model.parser.SymbolParserException;

public class BracketExpr implements Factor {
	
	private RegExpr expression;

	public BracketExpr(RegExpr regularExpression) {
		this.expression = regularExpression;
	}

	@Override
	public Integer evaluate() throws SymbolParserException {
		return this.expression.evaluate();
	}

}
