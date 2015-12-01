package wacc;

import java.io.PrintStream;

import org.antlr.v4.runtime.Token;

public class ErrorReporter {
	
	PrintStream out = null;
	
	public ErrorReporter(PrintStream out) {
		this.out = out;
	}
	
	public void println(String error, Token token) {
		out.println(token.getLine() + ":" + token.getCharPositionInLine() + " " + error);
	}

}
