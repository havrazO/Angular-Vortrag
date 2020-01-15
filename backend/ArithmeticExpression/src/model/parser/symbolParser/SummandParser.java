package model.parser.symbolParser;

import java.util.List;

import model.parser.SymbolParserException;
import model.parser.regExpr.RegExpr;
import model.parser.symbolVisitors.SummandVisitor;
import model.symbol.Symbol;

public class SummandParser extends SymbolParser {

	@Override
	public RegExpr toRegularExpression(List<Symbol> symbols) throws SymbolParserException {

		RegExpr regExpr = new FactorParser().toRegularExpression(symbols);

		SummandVisitor summandVisitor = new SummandVisitor(regExpr, symbols);

		symbols.get(0).acceptVisit(summandVisitor);

		return summandVisitor.getRegExpr();
	}

}
