package wacc.util;

public enum Error {
    OVERFLOW("overflow"), DIV_BY_ZERO("check_divide_by_zero"), NULL_PTR("null_pointer");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return error;
    }
}
