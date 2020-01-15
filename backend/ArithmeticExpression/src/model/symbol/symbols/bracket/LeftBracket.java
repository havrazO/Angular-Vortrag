package model.symbol.symbols.bracket;

import constants.TextContants;
import model.parser.SymbolParserException;
import model.parser.symbolVisitors.SymbolVisitor;

public class LeftBracket extends Bracket{

	public static final LeftBracket INSTANCE = new LeftBracket(TextContants.LEFT_BRACKET);

	private LeftBracket(char bracket) {
		super(bracket);
	}

	@Override
	public void acceptVisit(SymbolVisitor visitor) throws SymbolParserException {
		visitor.handleSymbolVisit(this);
	}
}
