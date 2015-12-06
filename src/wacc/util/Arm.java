package wacc.util;


public class Arm {

    public static String imm(Object o) {
        return "#" + o.toString();
    }
    
    public static String mem(Object o) {
    	return "=" + o.toString();
    }
    
}
