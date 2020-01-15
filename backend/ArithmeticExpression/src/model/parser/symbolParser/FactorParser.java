package model.parser.symbolParser;

import java.util.List;

import model.parser.SymbolParserException;
import model.parser.regExpr.RegExpr;
import model.parser.symbolVisitors.FactorVisitor;
import model.symbol.Symbol;

public class FactorParser extends SymbolParser {

	@Override
	public RegExpr toRegularExpression(List<Symbol> symbols) throws SymbolParserException {

		FactorVisitor factorVisitor = new FactorVisitor(null, symbols);

		symbols.get(0).acceptVisit(factorVisitor);

		return factorVisitor.getRegExpr();
	}

}
