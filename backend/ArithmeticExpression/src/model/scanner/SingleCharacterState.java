package model.scanner;

import java.util.HashMap;
import java.util.Map;

import constants.TextContants;
import model.symbol.Symbol;
import model.symbol.symbols.bracket.LeftBracket;
import model.symbol.symbols.bracket.RightBracket;
import model.symbol.symbols.operator.MultOperator;
import model.symbol.symbols.operator.PlusOperator;

public class SingleCharacterState extends State {

	private static final Map<Character, Symbol> symbolMap = new HashMap<Character, Symbol>() {

		private static final long serialVersionUID = 1L;

		{
			put(TextContants.PLUS_OPERATOR, PlusOperator.INSTANCE);
			put(TextContants.MULT_OPERATOR, MultOperator.INSTANCE);
			put(TextContants.LEFT_BRACKET, LeftBracket.INSTANCE);
			put(TextContants.RIGHT_BRACKET, RightBracket.INSTANCE);
		}
	};

	public SingleCharacterState(SymbolScanner scanner) {
		super(scanner);
	}

	@Override
	boolean scan(char charToScan) throws SymbolScannerException {
		return super.evalProcess(super.scanner.addSymbol(SingleCharacterState.symbolMap.get(charToScan)));
	}


}
