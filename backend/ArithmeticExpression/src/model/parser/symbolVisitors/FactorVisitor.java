package model.parser.symbolVisitors;

import java.util.List;

import model.parser.SymbolParserException;
import model.parser.regExpr.BracketExpr;
import model.parser.regExpr.RegExpr;
import model.parser.symbolParser.ExpressionParser;
import model.symbol.Symbol;
import model.symbol.symbols.EndOfSymbolList;
import model.symbol.symbols.Number;
import model.symbol.symbols.bracket.LeftBracket;
import model.symbol.symbols.bracket.RightBracket;

public class FactorVisitor extends SymbolVisitor {

	public FactorVisitor(RegExpr regExpr, List<Symbol> symbols) {
		super(regExpr, symbols);
	}

	@Override
	public void handleSymbolVisit(Number number) throws SymbolParserException {
		super.skip(); // removes number
		super.setRegExpr(number); // returns number
	}

	@Override
	public void handleSymbolVisit(LeftBracket leftBracket) throws SymbolParserException {
		super.skip(); // removes Leftbracket
		// returns expr in (expr)
		super.setRegExpr(new BracketExpr(new ExpressionParser().toRegularExpression(super.getSymbols())));
		this.checkForRightBracket(); // check for rightbracket
	}

	private void checkForRightBracket() throws SymbolParserException {
		if (super.getSymbols().get(0) instanceof RightBracket)
			super.skip(); // removes Rightbracket
		else
			throw new SymbolParserException("Syntax Error! Expected a closing Bracket");
	}
	@Override
	public void handleSymbolVisit(EndOfSymbolList endOfSymbolList) throws SymbolParserException {
		throw new SymbolParserException("Syntax Error! Expected the expression to be continued!");
	}

}
