package wacc.util;

public enum Error {
    OVERFLOW("throw_overflow_error"), DIV_BY_ZERO("check_divide_by_zero"), NULL_PTR("check_null_pointer"),
    ARR_OOB("check_array_bounds");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return error;
    }
}
