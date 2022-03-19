package by.tc.task01.exception;

import by.tc.task01.service.impl.validation.Error;

public class ApplianceSpecificationException extends RuntimeException {

    private final Error error;

    public ApplianceSpecificationException() {
        this.error = new Error("appliance.fields.access.exception",
                "There is no access to private fields of the appliance");
    }

    public String getCode() {
        return error.getCode();
    }

    @Override
    public String getMessage() {
        return error.getMessage();
    }
}
