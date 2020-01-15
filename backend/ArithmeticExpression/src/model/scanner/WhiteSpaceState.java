package model.scanner;

public class WhiteSpaceState extends State {

	public WhiteSpaceState(SymbolScanner scanner) {
		super(scanner);
	}

	@Override
	public boolean scan(char charToScan) throws SymbolScannerException {
		try {

			boolean success = false;

			if (Character.isSpaceChar(charToScan))
				success = true;

			return super.evalProcess(success);

		} catch (Exception exception) {
			throw new SymbolScannerException("Error while scanning for whitespaces.\n" + exception.getMessage());
		}
	}

}
