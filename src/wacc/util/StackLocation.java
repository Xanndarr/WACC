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
		return "[sp, " + offset + "]";
	}

}
