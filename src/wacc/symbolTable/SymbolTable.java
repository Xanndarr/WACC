package wacc.symbolTable;

import java.util.HashMap;
import java.util.Map;

class SymbolTable {
	
	private Map<String, Object> symbolTable;
	
	public SymbolTable() {
		symbolTable = new HashMap<String, Object>();
	}
	
	public void put(String key, Object value) {
		symbolTable.put(key, value);
	}
	
	public Object get(String key) {
		return symbolTable.get(key);
	}
	
	public boolean exists(String key) {
		return symbolTable.containsKey(key);
	}
	
}
