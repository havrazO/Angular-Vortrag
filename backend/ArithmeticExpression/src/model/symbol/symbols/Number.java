package model.symbol.symbols;

import model.parser.SymbolParserException;
import model.parser.regExpr.Factor;
import model.parser.symbolVisitors.SymbolVisitor;
import model.symbol.Symbol;

public class Number implements Symbol, Factor {

	private final Integer value;

	public Number(Integer value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public Integer evaluate() throws SymbolParserException {
		return this.value;
	}

	@Override
	public void acceptVisit(SymbolVisitor visitor) throws SymbolParserException {
		visitor.handleSymbolVisit(this);
	}
}
