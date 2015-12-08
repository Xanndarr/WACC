package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.*;

public class UnaryOpNode extends ExpNode {

    private UnaryOp op = UnaryOp.INVALID_OP;

    public UnaryOpNode(UnaryOp op) {
        this.op = op;
    }

    @Override
    public Reg generate() {
        RegHandler.descend();
        Reg operand = children.get(0).generate();
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
                nodeType = Type.INT;
            default:
                break;
        }
        RegHandler.ascend();
        return operand;
    }
}
