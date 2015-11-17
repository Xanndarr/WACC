package wacc;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

//import antlr package
import wacc.antlr.*;
import wacc.semantics.Visitor;

public class Test {
	public static void main(String[] args) throws Exception {
		//create a charStream that reads from stdin
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		
		//create a lexer that feeds off of input charStream
		WACCLexer lexer = new WACCLexer(input);
		
		//create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		//create a parser that feeds off a tokens buffer
		WACCParser parser = new WACCParser(tokens);
		
		//begin parsing at program rule
		ParseTree tree = parser.program();
		
		//Exit if syntactical errors are present
		if (parser.getNumberOfSyntaxErrors() > 0) {
			System.exit(100);
		}
		
		Visitor visitor = new Visitor();
		visitor.visit(tree);
		
		//Exit if semantical errors are present
		if (visitor.getReturnCode() != 0) {
			System.exit(visitor.getReturnCode());
		}
	}
}
