package model.parser.symbolVisitors;

import java.util.List;

import model.parser.SymbolParserException;
import model.parser.regExpr.RegExpr;
import model.parser.regExpr.Sum;
import model.parser.symbolParser.ExpressionParser;
import model.symbol.Symbol;
import model.symbol.symbols.bracket.RightBracket;
import model.symbol.symbols.operator.PlusOperator;

public class ExpressionVisitor extends SymbolVisitor {

	public ExpressionVisitor(RegExpr regExpr, List<Symbol> symbols) {
		super(regExpr, symbols);
	}

	@Override
	public void handleSymbolVisit(PlusOperator plusOperator) throws SymbolParserException {
		super.skip(); // removes +
		super.setRegExpr(new Sum(super.getRegExpr(), new ExpressionParser().toRegularExpression(super.getSymbols()))); // returns summand + expression
	}
	
	public void handleSymbolVisit(RightBracket rightBracket) throws SymbolParserException {
		return;
	}

}
