package model.symbol.symbols;

import model.parser.SymbolParserException;
import model.parser.symbolVisitors.SymbolVisitor;
import model.symbol.Symbol;

public class EndOfSymbolList implements Symbol {

	@Override
	public void acceptVisit(SymbolVisitor visitor) throws SymbolParserException {
		visitor.handleSymbolVisit(this);
	}

}
