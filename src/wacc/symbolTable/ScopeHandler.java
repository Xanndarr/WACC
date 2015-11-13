package wacc.symbolTable;

import java.util.HashMap;
import java.util.Map;

public class ScopeHandler {

	//-1 represents the index for global scope
	final static int GLOBAL_SCOPE = -1;
	private int currentScope = GLOBAL_SCOPE;
	
	private Map<Integer, SymbolTable> tables;
	
	public ScopeHandler() {
		tables = new HashMap<Integer, SymbolTable>();
		tables.put(GLOBAL_SCOPE, new SymbolTable());
	}
	
	//Unsure whether we should throw exception here.
	public void add(String ident, String type) throws Exception{
		if (tables.get(currentScope).exists(ident)) {
			throw new Exception("Error: variable already exists");
		}
		tables.get(currentScope).put(ident, type);
	}
	
	//Unsure whether we should throw exception here.
	public void addGlobal(String ident, String type) throws Exception {
		if (tables.get(currentScope).exists(ident)) {
			throw new Exception("Error: global variable already exists");
		}
		tables.get(GLOBAL_SCOPE).put(ident, type);
	}
	
	public Object get(String ident) throws Exception {
		for(int i = currentScope; i >= GLOBAL_SCOPE; i--) {
			if (tables.get(i).exists(ident)) {
				return tables.get(i).get(ident);
			}
		}
		throw new Exception("Error: symbol not found");
	}
	
	public boolean exists(String ident) {
		for(SymbolTable symtab : tables.values()) {
			if (symtab.exists(ident)) {
				return true;
			}
		}
		return false;
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
