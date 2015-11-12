package wacc.symbolTable;

import java.util.HashMap;
import java.util.Map;

public class ScopeHandler {
	
	//-1 represents the index for global scope
	private int currentScope = -1;
	private Map<Integer, SymbolTable> tables;
	
	public ScopeHandler() {
		tables = new HashMap<Integer, SymbolTable>();
	}
	
	public void add(String key, Object value) {
		tables.get(currentScope).put(key, value);
	}
	
	public Object get(String key) {
		return tables.get(currentScope).get(key);
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
