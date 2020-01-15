package model.symbol;

import model.parser.SymbolParserException;
import model.parser.symbolVisitors.SymbolVisitor;

public interface Symbol {

	public void acceptVisit(SymbolVisitor visitor) throws SymbolParserException;

}
