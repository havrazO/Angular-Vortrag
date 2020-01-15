package model.parser.symbolParser;

import java.util.List;

import model.parser.SymbolParserException;
import model.parser.regExpr.RegExpr;
import model.symbol.Symbol;

public abstract class SymbolParser {

	public abstract RegExpr toRegularExpression(List<Symbol> symbols) throws SymbolParserException;

}
