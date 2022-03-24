package by.tc.task01.exception;

import by.tc.task01.service.impl.validation.Error;

import java.io.IOException;

public class DatabaseParserException extends RuntimeException {

    private final Error error;

    public DatabaseParserException(IOException e) {
        this.error = new Error("database.parser.exception", e.getMessage());
    }

    public String getCode() {
        return error.getCode();
    }

    @Override
    public String getMessage() {
        return error.getMessage();
    }
}
