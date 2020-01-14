package ressources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.parser.symbolParser.ExpressionParser;
import model.parser.symbolParser.SymbolParser;
import model.scanner.SymbolScanner;

@Path("/")
public class ArithmeticExpressionService {

	@POST
	@Path("/calculate")
	@Produces(MediaType.TEXT_PLAIN)
	public Response calculate(String expression) {
		SymbolScanner scanner = new SymbolScanner();
		SymbolParser parser = new ExpressionParser();
		try {
			Integer result = parser.toRegularExpression(scanner.toSymbolSequence(expression)).evaluate();
			return Response.status(Response.Status.OK).entity(result).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		} 
	}

}
