package model.symbol.symbols;

import model.parser.SymbolParserException;
import model.parser.symbolVisitors.SymbolVisitor;
import model.symbol.Symbol;

public class ErrorToken implements Symbol {

	private char character;

	public ErrorToken(char character) {
		super();
		this.character = character;
	}

	public String toString() {
		return String.valueOf(character);
	}

	@Override
	public void acceptVisit(SymbolVisitor visitor) throws SymbolParserException {
		visitor.handleSymbolVisit(this);
	}
}
