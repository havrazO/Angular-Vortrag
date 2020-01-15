package model.symbol.symbols.operator;

import constants.TextContants;
import model.parser.SymbolParserException;
import model.parser.symbolVisitors.SymbolVisitor;

public class PlusOperator extends Operator {

	public static final PlusOperator INSTANCE = new PlusOperator(TextContants.PLUS_OPERATOR);

	private PlusOperator(char operator) {
		super(operator);
	}

	@Override
	public void acceptVisit(SymbolVisitor visitor) throws SymbolParserException {
		visitor.handleSymbolVisit(this);
	}
}
