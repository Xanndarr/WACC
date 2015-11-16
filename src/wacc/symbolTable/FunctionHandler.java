package wacc.symbolTable;

import java.util.HashMap;
import java.util.Map;

public class FunctionHandler {
	
	private Map<String, SymbolTable> functions;
	private final String FUNCTION_TYPE = "$TYPE";
	
	public FunctionHandler() {
		functions = new HashMap<String, SymbolTable>();
	}
	
	public void add(String ident, String returnType) {
		SymbolTable params = new SymbolTable();
		params.put(FUNCTION_TYPE, returnType);
		functions.put(ident, params);
	}
	
	public void addParam(String ident, String paramName, String paramType) {
		functions.get(ident).put(paramName, paramType);
	}
	
	public String getReturnType(String ident) {
		return functions.get(ident).get(FUNCTION_TYPE);
	}
	
	public String getParamType(String functionIdent, String paramIdent) {
		return functions.get(functionIdent).get(paramIdent);
	}
	
	public SymbolTable getParamList(String funcIdent) {
		return functions.get(funcIdent);
	}
	
	public boolean exists(String ident) {
		return functions.containsKey(ident);
	}
	
	public boolean existsParam(String functionIdent, String paramIdent) {
		return functions.containsKey(functionIdent) && functions.get(functionIdent).exists(paramIdent);
	}

}
