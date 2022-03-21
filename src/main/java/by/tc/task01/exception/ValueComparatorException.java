package by.tc.task01.exception;

import by.tc.task01.service.impl.validation.Error;

public class ValueComparatorException extends RuntimeException {

    private final Error error;

    public ValueComparatorException() {
        this.error = new Error("value.compare.exception",
                "Error in parsing string value as a number");
    }

    public String getCode() {
        return error.getCode();
    }

    @Override
    public String getMessage() {
        return error.getMessage();
    }
}
