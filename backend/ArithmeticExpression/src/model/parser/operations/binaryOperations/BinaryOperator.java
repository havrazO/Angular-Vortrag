package model.parser.operations.binaryOperations;

import model.parser.SymbolParserException;
import model.parser.regExpr.RegExpr;

public interface BinaryOperator {

	public Integer calculate(RegExpr x1, RegExpr x2) throws SymbolParserException;
}
