package wacc;

import java.io.PrintStream;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class ErrorReporter {
	
	private PrintStream out = null;
	private int errorCode = 0;
	
	public ErrorReporter(PrintStream out) {
		this.out = out;
	}
	
	public void println(String error, ParserRuleContext ctx) {
		Token token = ctx.getStart();
		out.println(token.getLine() + ":" + token.getCharPositionInLine() +" Semantic Error: " + error);
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

}
