package wacc.util;

public enum Error {
    OVERFLOW("overflow"), DIV_BY_ZERO("check_divide_by_zero");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return error;
    }
}
