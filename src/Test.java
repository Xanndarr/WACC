import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

//import antlr package
import antlr.*;


public class Test {
	public static void main(String[] args) throws Exception {
		//create a charStream that reads from stdin
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		
		//create a lexer that feeds off of input charStream
		tempLexer lexer = new tempLexer(input);
		
		//create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		//create a parser that feeds off a tokens buffer
		tempParser parser = new tempParser(tokens);
		
		ParseTree tree = parser.program(); //begin parsing at prog rule
		System.out.println(tree.toStringTree(parser)); //print LISP-style tree
	}
}
