package wacc;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

//import antlr package
import wacc.antlr.*;
import wacc.codeGen.Tree;
import wacc.codeGen.TreeGenerator;
import wacc.semantics.WACCVisitor;
import wacc.tree.nodes.ProgramNode;

public class WACC {
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
        ParseTree parseTree = parser.program();

        //Exit if syntactic errors are present
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.exit(100);
        }

        ErrorReporter err = new ErrorReporter(System.err);
        WACCVisitor visitor = new WACCVisitor(err);
        visitor.visit(parseTree);

        //Exit if semantic errors are present
        int returnCode = err.getReturnCode();
        if (returnCode != 0) {
            System.exit(returnCode);
        }
        
        TreeGenerator generator = new TreeGenerator();
        Tree internalTree = new Tree(generator.visit(parseTree));
        System.out.println(internalTree.print());
    }
}
