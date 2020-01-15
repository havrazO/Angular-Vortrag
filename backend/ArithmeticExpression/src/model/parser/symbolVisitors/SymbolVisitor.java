package model.parser.symbolVisitors;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import model.parser.SymbolParserException;
import model.parser.regExpr.RegExpr;
import model.symbol.Symbol;
import model.symbol.symbols.EndOfSymbolList;
import model.symbol.symbols.ErrorToken;
import model.symbol.symbols.Number;
import model.symbol.symbols.bracket.LeftBracket;
import model.symbol.symbols.bracket.RightBracket;
import model.symbol.symbols.operator.MultOperator;
import model.symbol.symbols.operator.PlusOperator;

public abstract class SymbolVisitor {

	@Getter
	@Setter
	private RegExpr regExpr;
	@Getter
	private List<Symbol> symbols;

	public SymbolVisitor(RegExpr regExpr, List<Symbol> symbols) {
		super();
		this.regExpr = regExpr;
		this.symbols = symbols;
	}

	public void handleSymbolVisit(EndOfSymbolList endOfSymbolList) throws SymbolParserException {
		return;
	}

	public void skip() throws SymbolParserException {
		try {
			this.symbols.remove(0);
		} catch (IndexOutOfBoundsException exception) {
			throw new SymbolParserException("Expected a Symbol!");
		}
	}

	public void handleSymbolVisit(PlusOperator plusOperator) throws SymbolParserException {
		throw new SymbolParserException("TODO");
	}

	public void handleSymbolVisit(MultOperator multOperator) throws SymbolParserException {
		throw new SymbolParserException("TODO");
	}

	public void handleSymbolVisit(Number number) throws SymbolParserException {
		throw new SymbolParserException("TODO");
	}

	public void handleSymbolVisit(LeftBracket leftBracket) throws SymbolParserException {
		throw new SymbolParserException("TODO");
	}

	public void handleSymbolVisit(RightBracket rightBracket) throws SymbolParserException {
		throw new SymbolParserException("TODO");
	}

	public void handleSymbolVisit(ErrorToken errorToken) throws SymbolParserException {
		throw new SymbolParserException("TODO");
	}

}
