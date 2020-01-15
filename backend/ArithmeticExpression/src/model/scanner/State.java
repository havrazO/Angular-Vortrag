package model.scanner;

public abstract class State {

	protected final SymbolScanner scanner;

	public State(SymbolScanner scanner) {
		this.scanner = scanner;
	}

	abstract boolean scan(char charToScan) throws SymbolScannerException;

	/**
	 * Gets called, when the input String in the referrenced Scanner is fully converted to a symbolsequence
	 */
	void postScan() {
		
	}

	/**
	 * If success is true, the skipmethod of the referrenced scanner is called and
	 * its state is set to the controlstate.
	 * 
	 * @param success
	 * @return
	 */
	protected boolean evalProcess(boolean success) {
		if (success) {
			this.scanner.skip();
			this.scanner.setState(new ControlState(this.scanner));
		}
		return success;
	}

	protected boolean evalProcess(boolean success, boolean skipCharacter, boolean toControlState) {
		if (success) {
			if (skipCharacter)
				this.scanner.skip();
			if (toControlState)
				this.scanner.setState(new ControlState(this.scanner));
		}
		return success;
	}
}
