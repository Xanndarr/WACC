package wacc.util;

import wacc.symbolTable.SymbolTable;

import java.util.HashMap;
import java.util.Map;

public class RegHandler {

    //0 represents the index for global scope
    private static int GLOBAL_SCOPE = 0;
    private static int currentScope = GLOBAL_SCOPE;

    private static RegHandler instance;
    private static Map<Integer, SymbolTable<Reg, Boolean>> tables;

    private RegHandler() {
        tables = new HashMap<Integer, SymbolTable<Reg, Boolean>>();
        tables.put(GLOBAL_SCOPE, new SymbolTable<Reg, Boolean>());
    }

    public static void add(Reg reg, Boolean used) {
        tables.get(currentScope).put(reg, used);
    }

    public static Boolean get(Reg reg) {
        for (int i = currentScope; i >= GLOBAL_SCOPE; i--) {
            if (tables.get(i).exists(reg)) {
                return tables.get(i).get(reg);
            }
        }
        return null;
    }

    public static boolean isUsedGlobally(Reg reg) {
        for (int i = currentScope; i >= GLOBAL_SCOPE; i--) {
            if (tables.get(i).exists(reg)) {
                return true;
            }
        }
        return false;
    }

    public static Reg getNextReg() {
        for (int i = Reg.R4.ordinal(); i <= Reg.R12.ordinal(); i++) {
            if (!tables.get(currentScope).exists(Reg.values()[i])) {
                add(Reg.values()[i], true);
                return Reg.values()[i];
            }
        }
        return null;
    }

    public static boolean isUsedLocally(Reg reg) {
        return tables.get(currentScope).exists(reg);
    }

    public static void descend() {
        currentScope++;
        tables.put(currentScope, new SymbolTable<Reg, Boolean>());
    }

    public static void ascend() {
        tables.remove(currentScope);
        currentScope--;
    }


    public static void createInstance() {
        if (instance == null) {
            instance = new RegHandler();
        }
    }

}
