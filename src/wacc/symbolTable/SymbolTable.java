package wacc.symbolTable;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


class SymbolTable {
	
	private Map<String, String> symbolTable;
	private Map<String, Pair> pairReferences;
	
	public SymbolTable() {
		symbolTable = new LinkedHashMap<String, String>();
		pairReferences = new HashMap<String, Pair>();
	}
	
	public void put(String key, String value) {
		symbolTable.put(key, value);
	}
	
	public void put(String key, String value, String fstRef, String sndRef) {
		symbolTable.put(key, value);
		pairReferences.put(key, new Pair(fstRef, sndRef));
	}
	
	public String get(String key) {
		return symbolTable.get(key);
	}
	
	public String getPairRef(String key, String index){
		if (index.equals("fst")) {
			return pairReferences.get(key).fst;
		}else if(index.equals("snd")) {
			return pairReferences.get(key).snd;
		}
		return "null";
	}
	
	public boolean exists(String key) {
		return symbolTable.containsKey(key);
	}
	
	public Collection<String> getValues() {
		return symbolTable.values();
	}
	
}
