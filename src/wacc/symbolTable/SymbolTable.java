package wacc.symbolTable;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class SymbolTable<K, V> {
	
	private Map<K, V> symbolTable;
	private Map<K, Pair> pairReferences;
	
	public SymbolTable() {
		symbolTable = new LinkedHashMap<K, V>();
		pairReferences = new HashMap<K, Pair>();
	}
	
	public void put(K key, V value) {
		symbolTable.put(key, value);
	}
	
	public void put(K key, V value, String fstRef, String sndRef) {
		symbolTable.put(key, value);
		pairReferences.put(key, new Pair(fstRef, sndRef));
	}
	
	public V get(K key) {
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
	
	public void remove(K key) {
		if (exists(key)) {
			symbolTable.remove(key);
		}
	}
	
	public boolean exists(K key) {
		return symbolTable.containsKey(key);
	}
	
	public Collection<K> getKeys() {
		return symbolTable.keySet();
	}
	
	public Collection<V> getValues() {
		return symbolTable.values();
	}
	
}
