package model.symbol.symbols.operator;

import model.symbol.Symbol;

public abstract class Operator implements Symbol {

	private char operator;

	protected Operator(char operator) {
		this.operator = operator;
	}

	public String toString() {
		return String.valueOf(this.operator);
	}
}
