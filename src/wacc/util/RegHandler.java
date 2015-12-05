package wacc.util;

import wacc.symbolTable.SymbolTable;

import java.util.Map;

public class RegHandler {

    //0 represents the index for global scope
    private int GLOBAL_SCOPE = 0;
    private int currentScope = GLOBAL_SCOPE;

    private Map<Integer, SymbolTable<Reg, Boolean>> tables;

    public Boolean get(Reg reg) {
        for(int i = currentScope; i >= GLOBAL_SCOPE; i--) {
            if (tables.get(i).exists(reg)) {
                return tables.get(i).get(reg);
            }
        }
        return null;
    }

    public boolean exists(Reg reg) {
        for(int i = currentScope; i >= GLOBAL_SCOPE; i--) {
            if (tables.get(i).exists(reg)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsCurrentScope(Reg reg) {
        return tables.get(currentScope).exists(reg);
    }

    public void descend() {
        currentScope++;
        tables.put(currentScope, new SymbolTable<Reg, Boolean>());
    }

    public void ascend() {
        tables.remove(currentScope);
        currentScope--;
    }


}
