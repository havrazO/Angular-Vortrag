package model.scanner;

import lombok.Getter;
import lombok.Setter;
import model.symbol.symbols.Number;

public class DigitState extends State {

	/**
	 * Found digits
	 */
	@Getter
	@Setter
	private String digitsAsString;

	public DigitState(SymbolScanner scanner) {
		super(scanner);
		this.digitsAsString = "";
	}

	@Override
	public boolean scan(char charToScan) throws SymbolScannerException {
		try {

			boolean success = false;
			boolean skipCharacter = false;
			boolean toControlState = false;

			if (Character.isDigit(charToScan)) {
				this.digitsAsString += String.valueOf(charToScan);
				skipCharacter = true;
				success = true;
			} else if (!this.digitsAsString.isEmpty()) {
				this.postScan();
				toControlState = true;
				success = true;
			}

			return super.evalProcess(success, skipCharacter, toControlState);

		} catch (Exception exception) {
			throw new SymbolScannerException("Error occured in Digitstate!\n" + exception.getMessage());
		}
	}

	@Override
	void postScan() {
		super.scanner.addSymbol(new Number(Integer.parseInt(this.digitsAsString)));
	}

}
