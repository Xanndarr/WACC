package wacc;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class ErrorReporter {
	private final StringBuilder errors = new StringBuilder();
	private List<Integer> nos = new ArrayList<Integer>();
	private PrintStream out = null;
	private int errorCode = 0;
	
	public ErrorReporter(PrintStream out) {
		this.out = out;
	}
	
	public void println(String error, ParserRuleContext ctx) {
		Token token = ctx.getStart();
		String fullError = token.getLine() + ":" + token.getCharPositionInLine() +" Semantic Error: " + error; 
		logError(fullError);
		logNos(token.getLine(), token.getCharPositionInLine());
		out.println(fullError);
		errorCode = 200;
	}
	

    public void printlnSyntax(String error, ParserRuleContext ctx) {
		Token token = ctx.getStart();
		out.println(token.getLine() + ":" + token.getCharPositionInLine() +" Syntax Error: " + error);
		errorCode = 100;
	}
	
	public int getReturnCode() {
		return errorCode;
	}
	
	public String getErrors(){
	  return errors.toString();
	}
	
	public List<Integer> getNos(){
	  return nos;
	}
	
	private void logError(String error){
	    errors.append(error);
	    errors.append("\n");
	}
	

    private void logNos(int line, int charPositionInLine) {
        nos.add(line);
        nos.add(charPositionInLine);
    
  }
    

}
