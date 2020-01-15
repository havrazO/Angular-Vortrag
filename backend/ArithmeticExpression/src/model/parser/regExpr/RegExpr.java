package model.parser.regExpr;

import model.parser.SymbolParserException;

public interface RegExpr {

	public Integer evaluate() throws SymbolParserException;
}
