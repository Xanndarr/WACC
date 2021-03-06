package wacc.util;

import java.util.LinkedList;
import java.util.Stack;

public class RegHandler {

    private static RegHandler instance;
    private static Stack<LinkedList<Reg>> regs;
    private static int used = 0;
    private static int stacked = 0;
    private static boolean peek = false;

    private RegHandler() {
        regs = new Stack<LinkedList<Reg>>();
        regs.push(new LinkedList<Reg>());
    }

    public static void use() {
        used++;
        if (used > Reg.R11.ordinal() - Reg.R4.ordinal()) {
            ProgramCode.add("PUSH " + Reg.R11.stack());
            stacked++;
        }

    }
    
    public static Reg free(Reg r) {
        used--;
        if (stacked > 0) {
            ProgramCode.add("POP " + Reg.R12.stack());
            stacked--;
            return Reg.R12;
        }
        return r;
    }

    public static Reg getNextReg() {
    	if (peek) {
    		return peekNextReg();
    	}
        if (stacked > 0) {
            return Reg.R11;
        }
        for (int i = Reg.R4.ordinal() + used - stacked; i <= Reg.R12.ordinal(); i++) {
            if (!regs.peek().contains(Reg.values()[i])) {
                regs.peek().add(Reg.values()[i]);
                return Reg.values()[i];
            }
        }
        return null;
    }
    
    public static Reg peekNextReg() {
        if (stacked > 0) {
            return Reg.R11;
        }
    	for (int i = Reg.R4.ordinal() + used - stacked; i <= Reg.R12.ordinal(); i++) {
            if (!regs.peek().contains(Reg.values()[i])) {
                return Reg.values()[i];
            }
        }
        return null;
    }

    public static void descend() {
        regs.push(new LinkedList<Reg>());
    }

    public static void ascend() {
        regs.pop();
    }

    public static void setPeek(boolean peek) {
    	RegHandler.peek = peek;
    }

    public static void createInstance() {
        if (instance == null) {
            instance = new RegHandler();
        }
    }

}
