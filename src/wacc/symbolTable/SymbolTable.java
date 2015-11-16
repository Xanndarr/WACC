package wacc.symbolTable;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


class SymbolTable {
	
	private Map<String, String> symbolTable;
	
	public SymbolTable() {
		symbolTable = new LinkedHashMap<String, String>();
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
	
	public Collection<String> getValues() {
		return symbolTable.values();
	}
	
}
