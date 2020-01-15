package model.parser.symbolParser;

import java.util.List;

import model.parser.SymbolParserException;
import model.parser.regExpr.RegExpr;
import model.parser.symbolVisitors.ExpressionVisitor;
import model.symbol.Symbol;
import model.symbol.symbols.EndOfSymbolList;

public class ExpressionParser extends SymbolParser {

	@Override
	public RegExpr toRegularExpression(List<Symbol> symbols) throws SymbolParserException {
		
		symbols.add(new EndOfSymbolList());
		
		RegExpr regExpr = new SummandParser().toRegularExpression(symbols);
		
		ExpressionVisitor expressionVisitor = new ExpressionVisitor(regExpr, symbols); // check for sum
		
		symbols.get(0).acceptVisit(expressionVisitor);
		
		return expressionVisitor.getRegExpr();
	}

}
