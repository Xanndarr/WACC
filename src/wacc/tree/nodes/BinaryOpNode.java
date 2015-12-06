package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.*;
import wacc.util.Error;

public class BinaryOpNode extends ExpNode {

    private BinaryOp op = BinaryOp.INVALID_OP;

    public BinaryOpNode(BinaryOp op) {
        this.op = op;
    }

    @Override
    public Reg generate() {
        Reg operand1 = children.get(0).generate();
        Reg operand2 = children.get(1).generate();
        String dataLabel;
        switch (op) {
            case MULT:
                ProgramCode.add("SMUL " + operand1 + ", " + operand2 + ", " + operand2 + ", " + operand1);
                ProgramCode.add("CMP " + operand2 + ", " + operand1 + ", ASR #31");
                ProgramCode.add("BLNE p_throw_overflow_error");
                dataLabel = RuntimeErrorCode.addPrintData(Error.OVERFLOW);
                RuntimeErrorCode.addPrint(Error.OVERFLOW, dataLabel);
                nodeType = Type.INT;
                break;
            case DIV:
                ProgramCode.add("MOV r0, " + operand1);
                ProgramCode.add("MOV r1, " + operand2);
                ProgramCode.add("BL p_check_divide_by_zero");
                ProgramCode.add("BL __aeabi_idiv");
                dataLabel = RuntimeErrorCode.addPrintData(Error.DIV_BY_ZERO);
                RuntimeErrorCode.addPrint(Error.DIV_BY_ZERO, dataLabel);
                nodeType = Type.INT;
                break;
            case MOD:
                ProgramCode.add("MOV r0, " + operand1);
                ProgramCode.add("MOV r1, " + operand2);
                ProgramCode.add("BL p_check_divide_by_zero");
                ProgramCode.add("BL __aeabi_idivmod");
                dataLabel = RuntimeErrorCode.addPrintData(Error.DIV_BY_ZERO);
                RuntimeErrorCode.addPrint(Error.DIV_BY_ZERO, dataLabel);
                nodeType = Type.INT;
                break;
            case ADD:
                ProgramCode.add("ADDS " + operand1 + ", " + operand1 + ", " + operand2);
                ProgramCode.add("BLVS p_throw_overflow_error");
                nodeType = Type.INT;
                dataLabel = RuntimeErrorCode.addPrintData(Error.OVERFLOW);
                RuntimeErrorCode.addPrint(Error.OVERFLOW, dataLabel);
                break;
            case SUB:
                ProgramCode.add("SUBS " + operand1 + ", " + operand1 + ", " + operand2);
                ProgramCode.add("BLVS p_throw_overflow_error");
                dataLabel = RuntimeErrorCode.addPrintData(Error.OVERFLOW);
                RuntimeErrorCode.addPrint(Error.OVERFLOW, dataLabel);
                nodeType = Type.INT;
                break;
            case GT:
                ProgramCode.add("CMP " + operand1 + ", " + operand2);
                ProgramCode.add("MOVGT " + operand1 + ", #1");
                ProgramCode.add("MOVLE " + operand1 + ", #0");
                nodeType = Type.BOOL;
                break;
            case GTE:
                ProgramCode.add("CMP " + operand1 + ", " + operand2);
                ProgramCode.add("MOVGE " + operand1 + ", #1");
                ProgramCode.add("MOVLT " + operand1 + ", #0");
                nodeType = Type.BOOL;
                break;
            case LT:
                ProgramCode.add("CMP " + operand1 + ", " + operand2);
                ProgramCode.add("MOVLT " + operand1 + ", #1");
                ProgramCode.add("MOVGE " + operand1 + ", #0");
                nodeType = Type.BOOL;
                break;
            case LTE:
                ProgramCode.add("CMP " + operand1 + ", " + operand2);
                ProgramCode.add("MOVLE " + operand1 + ", #1");
                ProgramCode.add("MOVGT " + operand1 + ", #0");
                nodeType = Type.BOOL;
                break;
            case EQ:
                ProgramCode.add("CMP " + operand1 + ", " + operand2);
                ProgramCode.add("MOVEQ " + operand1 + ", #1");
                ProgramCode.add("MOVNE " + operand1 + ", #0");
                nodeType = Type.BOOL;
                break;
            case NEQ:
                ProgramCode.add("CMP " + operand1 + ", " + operand2);
                ProgramCode.add("MOVEQ " + operand1 + ", #1");
                ProgramCode.add("MOVNE " + operand1 + ", #0");
                nodeType = Type.BOOL;
                break;
            case AND:
                ProgramCode.add("AND " + operand1 + ", " + operand1 + ", " + operand2);
                nodeType = Type.BOOL;
                break;
            case OR:
                ProgramCode.add("ORR " + operand1 + ", " + operand1 + ", " + operand2);
                nodeType = Type.BOOL;
                break;
            default:
                break;
        }
        return operand1;
    }

}
