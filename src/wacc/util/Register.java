package wacc.util;

public enum Register {

    R0("r0"), R1("r1"), R2("r2"), R3("r3"), R4("r4"), R5("r5"), R6("r6"),
    R7("r7"), R8("r8"), R9("r9"), R10("r10"), R11("r11"), R12("r12"),
    R13("sp"), R14("lr"), R15("pc");

    private final String name;

    Register(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
