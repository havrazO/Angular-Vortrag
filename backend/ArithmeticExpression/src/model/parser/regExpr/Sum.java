package model.parser.regExpr;


import model.parser.SymbolParserException;
import model.parser.operations.binaryOperations.Addition;

public class Sum implements RegExpr{	
	
	private RegExpr arg1;
	private RegExpr arg2;

	public Sum(RegExpr summand1, RegExpr regExpr) {
		super();
		this.arg1 = summand1;
		this.arg2 = regExpr;
	}

	@Override
	public Integer evaluate() throws SymbolParserException {
		return Addition.INSTANCE.calculate(this.arg1, this.arg2);
	}

}
