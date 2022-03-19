package by.tc.task01.exception;

import by.tc.task01.service.impl.validation.Error;

public class ApplianceBuilderException extends RuntimeException {

    private final Error error;

    public ApplianceBuilderException() {
        this.error = new Error("database.builder.exception",
                "There is no such appliance in the database");
    }

    public String getCode() {
        return error.getCode();
    }

    @Override
    public String getMessage() {
        return error.getMessage();
    }
}
