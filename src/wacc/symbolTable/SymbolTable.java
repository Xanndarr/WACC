package wacc.symbolTable;

import java.util.HashMap;
import java.util.Map;

class SymbolTable {
	
	private Map<String, String> symbolTable;
	
	public SymbolTable() {
		symbolTable = new HashMap<String, String>();
	}
	
	public void put(String key, String value) {
		symbolTable.put(key, value);
	}
	
	public String get(String key) {
		return symbolTable.get(key);
	}
	
	public boolean exists(String key) {
		return symbolTable.containsKey(key);
	}
	
}
