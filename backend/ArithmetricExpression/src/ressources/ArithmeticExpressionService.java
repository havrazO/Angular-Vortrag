package ressources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import model.parser.regExpr.RegExpr;
import model.parser.symbolParser.ExpressionParser;
import model.parser.symbolParser.SymbolParser;
import model.scanner.SymbolScanner;

@Path("/")
public class ArithmeticExpressionService {

	@POST
	@Path("/calculate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response calculate(String expression) {
		SymbolScanner scanner = new SymbolScanner();
		SymbolParser parser = new ExpressionParser();
		Gson gson = new Gson();
		
		try {
			RegExpr resultExpr = parser.toRegularExpression(scanner.toSymbolSequence(expression));
			Integer result = resultExpr.evaluate();
			
			CalculateEntity calculateEntity = new CalculateEntity();
			calculateEntity.setResult(result);
			calculateEntity.setResultTree(resultExpr);
			calculateEntity.setMessage("Syntax Ok");
		
			return Response.status(Response.Status.OK).entity(gson.toJson(calculateEntity)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson(e.getMessage())).build();
		} 
	}

}
