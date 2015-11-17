package wacc.symbolTable;

import java.util.HashMap;
import java.util.Map;

public class ScopeHandler {

	//0 represents the index for global scope
	private int GLOBAL_SCOPE = 0;
	private int currentScope = GLOBAL_SCOPE;
	
	private Map<Integer, SymbolTable> tables;
	
	public ScopeHandler() {
		tables = new HashMap<Integer, SymbolTable>();
		tables.put(GLOBAL_SCOPE, new SymbolTable());
	}
	
	public void add(String ident, String type) {
		tables.get(currentScope).put(ident, type);
	}
	
	// Allows adding of pair_elem types to current scope
	public void add(String ident, String type, String fstRef, String sndRef) {
		tables.get(currentScope).put(ident, type, fstRef, sndRef);
	}
	
	public String get(String ident) {
		for(int i = currentScope; i >= GLOBAL_SCOPE; i--) {
			if (tables.get(i).exists(ident)) {
				return tables.get(i).get(ident);
			}
		}
		return null;
	}
	
	public String get(String ident, String index) {
		for(int i = currentScope; i >= GLOBAL_SCOPE; i--) {
			if (tables.get(i).exists(ident)) {
				return tables.get(i).getPairRef(ident, index);
			}
		}
		return null;
	}
	
	public boolean exists(String ident) {
		for(int i = currentScope; i >= GLOBAL_SCOPE; i--) {
			if (tables.get(i).exists(ident)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existsCurrentScope(String ident) {
		return tables.get(currentScope).exists(ident);
	}
	
	public void ascendFun() {
		GLOBAL_SCOPE++;
	}
	
	public void descendFun() {
		GLOBAL_SCOPE--;
	}
	
	public void descend() {
		currentScope++;
		tables.put(currentScope, new SymbolTable());
	}
	
	public void ascend() {
		tables.remove(currentScope);
		currentScope--;
	}

}
