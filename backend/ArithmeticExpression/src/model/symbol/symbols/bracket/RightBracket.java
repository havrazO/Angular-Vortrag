package model.symbol.symbols.bracket;

import constants.TextContants;
import model.parser.SymbolParserException;
import model.parser.symbolVisitors.SymbolVisitor;

public class RightBracket extends Bracket {

	public static final RightBracket INSTANCE = new RightBracket(TextContants.RIGHT_BRACKET);

	private RightBracket(char bracket) {
		super(bracket);
	}

	@Override
	public void acceptVisit(SymbolVisitor visitor) throws SymbolParserException {
		visitor.handleSymbolVisit(this);
	}
}
