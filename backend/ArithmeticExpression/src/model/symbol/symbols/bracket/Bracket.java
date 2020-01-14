package model.symbol.symbols.bracket;

import model.symbol.Symbol;

public abstract class Bracket implements Symbol {

	private char bracket;

	protected Bracket(char bracket) {
		this.bracket = bracket;
	}

	public String toString() {
		return String.valueOf(this.bracket);
	}
}
