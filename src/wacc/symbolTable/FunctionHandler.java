package wacc.symbolTable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FunctionHandler {
	
	private Map<String, SymbolTable<String, String>> functions;
	private final String FUNCTION_TYPE = "$TYPE";
	
	public FunctionHandler() {
		functions = new HashMap<String, SymbolTable<String, String>>();
	}
	
	//FUNCTION_TYPE represents the return type of function in hashmap
	public void add(String ident, String returnType) {
		SymbolTable<String, String> params = new SymbolTable<String, String>();
		params.put(FUNCTION_TYPE, returnType);
		functions.put(ident, params);
	}
	
	public void addParam(String ident, String paramName, String paramType) {
		functions.get(ident).put(paramName, paramType);
	}

	//Overloads addParam to allow for pairs_elem references
	public void addParam(String ident, String paramName, String paramType, String fstRef, String sndRef) {
		functions.get(ident).put(paramName, paramType, fstRef, sndRef);;
	}
	
	public String getReturnType(String ident) {
		return functions.get(ident).get(FUNCTION_TYPE);
	}
	
	public String getParamType(String functionIdent, String paramIdent) {
		return functions.get(functionIdent).get(paramIdent);
	}
	
	public Collection<String> getParamTypeList(String funcIdent) {
		return functions.get(funcIdent).getValues();
	}
	
	public boolean exists(String ident) {
		return functions.containsKey(ident);
	}
	
	public boolean existsParam(String functionIdent, String paramIdent) {
		return functions.containsKey(functionIdent) && functions.get(functionIdent).exists(paramIdent);
	}

}
