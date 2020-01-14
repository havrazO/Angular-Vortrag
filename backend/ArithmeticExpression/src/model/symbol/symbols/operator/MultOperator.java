package model.symbol.symbols.operator;

import constants.TextContants;
import model.parser.SymbolParserException;
import model.parser.symbolVisitors.SymbolVisitor;

public class MultOperator extends Operator {

	public static final MultOperator INSTANCE = new MultOperator(TextContants.MULT_OPERATOR);

	private MultOperator(char operator) {
		super(operator);
	}

	@Override
	public void acceptVisit(SymbolVisitor visitor) throws SymbolParserException {
		visitor.handleSymbolVisit(this);
	}
}
