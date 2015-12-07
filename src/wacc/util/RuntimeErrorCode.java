package wacc.util;

import java.util.LinkedList;
import java.util.List;

public class RuntimeErrorCode {

    private static final List<Error> printedErrorLabels = new LinkedList<Error>();

    private static String addErrorData(Error e) {
        switch (e) {
            case OVERFLOW:
                return ProgramCode.addData("OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n");
            case DIV_BY_ZERO:
                return ProgramCode.addData("DivideByZeroError: divide or modulo by zero\\n\\0");
            case NULL_PTR:
                return ProgramCode.addData("NullReferenceError: dereference a null reference\\n\\0");
            case ARR_OOB:
            	String fst = ProgramCode.addData("ArrayIndexOutOfBoundsError: negative index\\n\\0");
            	ProgramCode.addData("ArrayIndexOutOfBoundsError: index too large\\n\\0");
            	return fst;
            default:
                return null;
        }
    }

    private static void produceError(Error e) {
        ProgramCode.setPostIndent(false);
        String dataLabel = addErrorData(e);
        ProgramCode.addPost("p_" + e + ":");
        ProgramCode.setPostIndent(true);
        ProgramCode.addPost("PUSH {lr}");
        switch (e) {
            case OVERFLOW:
                ProgramCode.addPost("LDR r0, " + Arm.mem(dataLabel));
                ProgramCode.addPost("BL p_throw_runtime_error");
                break;
            case DIV_BY_ZERO:
                ProgramCode.addPost("CMP r1, #0");
                ProgramCode.addPost("LDREQ r0, " + Arm.mem(dataLabel));
                ProgramCode.addPost("BLEQ p_throw_runtime_error");
                break;
            case NULL_PTR:
                ProgramCode.addPost("CMP r0, #0");
                ProgramCode.addPost("LDREQ r0, " + Arm.mem(dataLabel));
                ProgramCode.addPost("BLEQ p_throw_runtime_error");
                break;
            case ARR_OOB:
            	String secondLabel = "msg_" + (Integer.parseInt(dataLabel.replaceAll("msg_", "")) + 1);
            	ProgramCode.addPost("LDRLT r0, " + Arm.mem(dataLabel));
            	ProgramCode.addPost("BLLT p_throw_runtime_error");
            	ProgramCode.addPost("LDR r1, [r1]");
            	ProgramCode.addPost("CMP r0, r1");
            	ProgramCode.addPost("LDRCS r0, " + Arm.mem(secondLabel));
            	ProgramCode.addPost("BLCS p_throw_runtime_error");
            	break;
            default:
                break;
        }
        ProgramCode.addPost("POP {pc}");
        addRuntimeError();
    }

    private static void addRuntimeError() {
        ProgramCode.setPostIndent(false);
        ProgramCode.addPost("p_throw_runtime_error:");
        ProgramCode.setPostIndent(true);
        ProgramCode.addPost("BL p_print_string");
        ProgramCode.addPost("MOV r0, #-1");
        ProgramCode.addPost("BL exit");
        ProgramCode.setPostIndent(false);
    }

    public static void addError(Error e) {
        if (!printedErrorLabels.contains(e)) {
            RuntimeErrorCode.produceError(e);
            printedErrorLabels.add(e);
            PrintCode.addPrint(Type.STRING);
        }
    }

}
