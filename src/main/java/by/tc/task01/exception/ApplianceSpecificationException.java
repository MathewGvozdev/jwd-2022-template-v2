package by.tc.task01.exception;

import by.tc.task01.service.impl.validation.Error;

public class ApplianceSpecificationException extends RuntimeException {

    private final Error error;

    public ApplianceSpecificationException(IllegalAccessException e) {
        this.error = new Error("appliance.field.access.exception", e.getMessage());
    }

    public String getCode() {
        return error.getCode();
    }

    @Override
    public String getMessage() {
        return error.getMessage();
    }
}
