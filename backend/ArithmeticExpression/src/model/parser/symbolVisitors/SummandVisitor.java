package model.parser.symbolVisitors;

import java.util.List;

import model.parser.SymbolParserException;
import model.parser.regExpr.Product;
import model.parser.regExpr.RegExpr;
import model.parser.symbolParser.SummandParser;
import model.symbol.Symbol;
import model.symbol.symbols.bracket.RightBracket;
import model.symbol.symbols.operator.MultOperator;
import model.symbol.symbols.operator.PlusOperator;

public class SummandVisitor extends SymbolVisitor {

	public SummandVisitor(RegExpr regExpr, List<Symbol> symbols) {
		super(regExpr, symbols);

	}

	@Override
	public void handleSymbolVisit(MultOperator multOperator) throws SymbolParserException {
		super.skip(); // removes *
		// returns factor * summand
		super.setRegExpr(new Product(super.getRegExpr(), new SummandParser().toRegularExpression(super.getSymbols())));
	}
	
	/*
	 * must not throw error, so exprVisitor can parse +
	 */
	@Override
	public void handleSymbolVisit(PlusOperator plusOperator) throws SymbolParserException {
		return; 
	}
	
	public void handleSymbolVisit(RightBracket rightBracket) throws SymbolParserException {
		return;
	}
}
