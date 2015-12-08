package wacc.util;

public class StackLocation {
	
	private final int offset;
	
	public StackLocation(int offset) {
		this.offset = offset;
	}
	
	public int getOffset() {
		return offset;
	}
	
	@Override
	public String toString() {
		if (offset == 0) {
			return "[sp]";
		}
		int temp = offset;
		while (temp > 1024) {
			ProgramCode.add("SUB sp, sp, #1024");
			temp -= 1024;
		}
		return "[sp, " + Arm.imm(-temp) + "]";
	}

}
