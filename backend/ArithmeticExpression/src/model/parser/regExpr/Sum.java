package model.parser.regExpr;


import model.parser.SymbolParserException;
import model.parser.operations.binaryOperations.Addition;

public class Sum implements RegExpr{	
	
	private RegExpr summand1;
	private RegExpr summand2;

	public Sum(RegExpr summand1, RegExpr regExpr) {
		super();
		this.summand1 = summand1;
		this.summand2 = regExpr;
	}

	@Override
	public Integer evaluate() throws SymbolParserException {
		return Addition.INSTANCE.calculate(this.summand1, this.summand2);
	}

}
