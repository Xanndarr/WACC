package wacc.util;

import wacc.symbolTable.SymbolTable;

import java.util.HashMap;
import java.util.Map;

public class StackHandler {

    //0 represents the index for global scope
    private static int GLOBAL_SCOPE = 0;
    private static int currentScope = GLOBAL_SCOPE;
    
    private static int offset = 0;

    private static StackHandler instance;
    private static Map<Integer, SymbolTable<String, StackLocation>> stack;
    
    private StackHandler() {
    	stack = new HashMap<Integer, SymbolTable<String, StackLocation>>();
    	stack.put(currentScope, new SymbolTable<String, StackLocation>());
	}

    public static void add(String ident, StackLocation loc, int size) {
    	if (instance == null) {
    		instance = new StackHandler();
    	}
    	stack.get(currentScope).put(ident, loc);
        offset += size;
    }

    public static StackLocation get(String ident) {
        for(int i = currentScope; i >= GLOBAL_SCOPE; i--) {
            if (stack.get(i).exists(ident)) {
                return stack.get(i).get(ident);
            }
        }
        return null;
    }
    
    public static int getOffset() {
    	return offset;
    }

    public static void descend() {
        currentScope++;
        stack.put(currentScope, new SymbolTable<String, StackLocation>());
    }

    public static void ascend() {
    	stack.remove(currentScope);
        currentScope--;
    }


}
