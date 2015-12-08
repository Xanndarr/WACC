package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.*;
import wacc.util.Error;

public class UnaryOpNode extends ExpNode {

    private UnaryOp op = UnaryOp.INVALID_OP;

    public UnaryOpNode(UnaryOp op) {
        this.op = op;
    }

    @Override
    public Reg generate() {
        RegHandler.descend();
        Reg operand = children.get(0).generate();
        if (nodeType == Type.ARRAY || nodeType == Type.PAIR) {
        	ProgramCode.add("LDR " + operand + ", " + operand.memory());
        }
        switch (op) {
            case NOT:
                ProgramCode.add("EOR  " + operand + ", " + operand + ", #1");
                nodeType = Type.BOOL;
                break;
            case CHR:
                nodeType = Type.CHAR;
                break;
            case LEN:
                ProgramCode.add("LDR " + operand + ", " + operand.memory(-Type.INT.getSize()));
            case ORD:
                nodeType = Type.INT;
                break;
            case SUB:
            	ProgramCode.add("RSBS " + operand + ", " + operand + " #0");
            	ProgramCode.add("BLVS p_throw_overflow_error");
            	RuntimeErrorCode.addError(Error.OVERFLOW);
                nodeType = Type.INT;
            default:
                break;
        }
        RegHandler.ascend();
        return operand;
    }
}
