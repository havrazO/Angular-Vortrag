package ressources;

import lombok.Getter;
import lombok.Setter;
import model.parser.regExpr.RegExpr;

@Getter
@Setter
public class CalculateEntity {
	
	public Integer result;
	
	public RegExpr resultTree;
	
	public String message;

}
