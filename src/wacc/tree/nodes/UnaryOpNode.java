package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.Type;
import wacc.util.UnaryOp;

public class UnaryOpNode extends ExpNode {

    private UnaryOp op = UnaryOp.INVALID_OP;

    public UnaryOpNode(UnaryOp op) {
        this.op = op;
    }

    @Override
    public Reg generate() {
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
                ProgramCode.add("LDR " + operand + ", [" + operand + "]");
            case ORD:
                nodeType = Type.INT;
                break;
            case SUB:
                nodeType = Type.INT;
            default:
                break;
        }
        return operand;
    }
}
