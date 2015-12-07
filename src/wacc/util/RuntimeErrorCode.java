package wacc.util;

import wacc.tree.nodeSupers.Node;

public class RuntimeErrorCode {

    public static String addErrorData(Error e) {
        switch (e) {
            case OVERFLOW:
                return ProgramCode.addData("OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n");
            case DIV_BY_ZERO:
                return ProgramCode.addData("DivideByZeroError: divide or modulo by zero\\n\\0");
            case NULL_PTR:
                return ProgramCode.addData("\"NullReferenceError: dereference a null reference\\n\\0\"");
            default:
                return null;
        }
    }

    public static void addError(Error e, String dataLabel) {
        switch (e) {
            case OVERFLOW:
                ProgramCode.addPost("p_throw_overflow_error:");
                ProgramCode.setPostIndent(true);
                ProgramCode.addPost("PUSH {lr}");
                ProgramCode.addPost("LDR r0, " + Arm.mem(dataLabel));
                ProgramCode.addPost("BL p_throw_runtime_error");
                addRuntimeError();
                break;
            case DIV_BY_ZERO:
                ProgramCode.addPost("p_check_divide_by_zero:");
                ProgramCode.setPostIndent(true);
                ProgramCode.addPost("PUSH {lr}");
                ProgramCode.addPost("CMP r1, #0");
                ProgramCode.addPost("LDREQ r0, " + Arm.mem(dataLabel));
                ProgramCode.addPost("BLEQ p_throw_runtime_error");
                ProgramCode.addPost("POP {pc}");
                addRuntimeError();
                break;
            case NULL_PTR:
                ProgramCode.addPost("p_check_divide_by_zero:");
                ProgramCode.setPostIndent(true);
                ProgramCode.addPost("PUSH {lr}");
                ProgramCode.addPost("CMP r0, #0");
                ProgramCode.addPost("LDREQ r0, " + Arm.mem(dataLabel));
                ProgramCode.addPost("BLEQ p_throw_runtime_error");
                ProgramCode.addPost("POP {pc}");
                addRuntimeError();
            default:
                break;
        }
        ProgramCode.setPostIndent(false);
    }

    private static void addRuntimeError() {
        ProgramCode.setPostIndent(false);
        ProgramCode.addPost("p_throw_runtime_error:");
        ProgramCode.setPostIndent(true);
        ProgramCode.addPost("BL p_print_string");
        ProgramCode.addPost("MOV r0, #-1");
        ProgramCode.addPost("BL exit");
    }

    public static void checkExistingErrors(boolean existsError, Error e) {
        String dataLabel;
        if (!existsError) {
            RuntimeErrorCode.addError(e);
            Node.getPrintedErrorLabels().add(e);
            if (!Node.getPrintedTypeLabels().containsKey(Type.STRING)) {
                dataLabel = PrintCode.addPrintData(Type.STRING);
                Node.getPrintedTypeLabels().put(Type.STRING, dataLabel);
                PrintCode.addPrint(Type.STRING, dataLabel);
            }
        }
    }

}
