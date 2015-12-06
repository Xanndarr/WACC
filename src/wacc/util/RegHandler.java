package wacc.util;

import wacc.symbolTable.SymbolTable;

import java.util.Map;

public class RegHandler {

    //0 represents the index for global scope
    private int GLOBAL_SCOPE = 0;
    private int currentScope = GLOBAL_SCOPE;

    private Map<Integer, SymbolTable<Reg, Boolean>> tables;

    public void add(Reg reg, Boolean used) {
        tables.get(currentScope).put(reg, used);
    }

    public Boolean get(Reg reg) {
        for(int i = currentScope; i >= GLOBAL_SCOPE; i--) {
            if (tables.get(i).exists(reg)) {
                return tables.get(i).get(reg);
            }
        }
        return null;
    }

    public boolean isUsedGlobally(Reg reg) {
        for(int i = currentScope; i >= GLOBAL_SCOPE; i--) {
            if (tables.get(i).exists(reg)) {
                return true;
            }
        }
        return false;
    }
    
    public Reg getNextReg() {
    	for (int i = Reg.R4.ordinal(); i <= Reg.R12.ordinal(); i++) {
    		if (!tables.get(currentScope).exists(Reg.values()[i])) {
    			return Reg.values()[i];
    		}
    	}
    	return null;
    }

    public boolean isUsedLocally(Reg reg) {
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
