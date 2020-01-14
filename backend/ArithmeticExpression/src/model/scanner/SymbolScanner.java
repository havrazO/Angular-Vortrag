package model.scanner;

import java.util.ArrayList;
import java.util.List;

import constants.TextContants;
import lombok.Getter;
import model.symbol.Symbol;

/**
 * An instance of this class is able to scan a String to Symbols.
 * 
 * @author admin
 *
 */
public class SymbolScanner {

	/**
	 * This list represents the found symbols after the scan (grows during scan).
	 */
	@Getter
	private List<Symbol> foundSymbols;

	private String input;

	/**
	 * A SymbolScanner has exactly one state at any time.
	 */
	private State state;

	public SymbolScanner() {
		this.init(TextContants.EMPTY_STRING);
	}

	/**
	 * Intitializes a SymbolScanner, so that it correctly processes a scan of a
	 * String.
	 */
	private void init(String input) {
		this.foundSymbols = new ArrayList<Symbol>();
		this.state = new ControlState(this);
		this.input = input;
	}

	/**
	 * This method scans a String and returns a list of Symbols.
	 * 
	 * @param input as String.
	 * @return List of scanned Symbols.
	 * @throws SymbolScannerException, when a character is not able to be scanned by
	 *                                 any known State.
	 */
	public List<Symbol> toSymbolSequence(String input) throws SymbolScannerException {

		this.init(input);

		while (this.input.length() > 0)
			this.state.scan(this.input.charAt(0));

		this.state.postScan();

		return this.foundSymbols;
	}

	/**
	 * This method deletes the first character of the input String field.
	 */
	void skip() {
		try {
			this.input = this.input.substring(1);
		} catch (IndexOutOfBoundsException exception) {
			this.input = TextContants.EMPTY_STRING;
		}
	}

	/**
	 * Adds a Symbol to the found Symbols and returns true, if symbol is not null. Else it won't get added and returns false.
	 * 
	 * @param symbol
	 */
	boolean addSymbol(Symbol symbol) {
		if (symbol != null) {
			this.foundSymbols.add(symbol);
			return true;
		} else
			return false;
	}

	State setState(State state) {
		return this.state = state;
	}
}
