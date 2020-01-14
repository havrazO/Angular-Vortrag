package model.scanner;

import java.util.ArrayList;
import java.util.List;

import model.symbol.symbols.ErrorToken;

/**
 * The ControlState controls states, when processing a Character. It knows all
 * the other states and delegates processing a Character.
 * 
 * 
 * @author admin
 *
 */
public class ControlState extends State {

	/**
	 * List of states. Each will scan a character
	 */
	private List<State> states;

	public ControlState(SymbolScanner scanner) {
		super(scanner);
		this.states = new ArrayList<State>();
		this.states.add(new DigitState(scanner));
		this.states.add(new SingleCharacterState(scanner));
		this.states.add(new WhiteSpaceState(scanner));
	}

	@Override
	public boolean scan(char charToScan) throws SymbolScannerException {

		Integer stateIndex = 0;
		Integer totalStates = this.states.size();
		boolean success = false;

		try {
			while (!(success) && stateIndex < totalStates) {
				success = super.scanner.setState(this.states.get(stateIndex)).scan(charToScan);
				stateIndex++;
			}

			return this.evalProcess(success, charToScan);

		} catch (Exception exception) {

			throw new SymbolScannerException(
					"SymbolScanner failed to scan the character: " + charToScan + "\n" + exception.getMessage());
		}

	}

	private boolean evalProcess(boolean success, char charToScan) {
		if (!success) {
			super.scanner.addSymbol(new ErrorToken(charToScan));
			super.evalProcess(true);
		}
		return success;
	}

}
