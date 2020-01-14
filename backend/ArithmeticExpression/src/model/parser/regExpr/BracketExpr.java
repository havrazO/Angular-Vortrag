package model.parser.regExpr;

import model.parser.SymbolParserException;

public class BracketExpr implements Factor {
	
	private RegExpr regExpr;

	public BracketExpr(RegExpr regularExpression) {
		this.regExpr = regularExpression;
	}

	@Override
	public Integer evaluate() throws SymbolParserException {
		return this.regExpr.evaluate();
	}

}
