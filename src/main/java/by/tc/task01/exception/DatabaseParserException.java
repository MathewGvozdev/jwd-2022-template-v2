package by.tc.task01.exception;

import by.tc.task01.service.impl.validation.Error;

public class DatabaseParserException extends RuntimeException{

    private final Error error;

    public DatabaseParserException() {
        this.error = new Error("database.parser.exception",
                "Check the path to the database");
    }

    public String getCode() {
        return error.getCode();
    }

    @Override
    public String getMessage() {
        return error.getMessage();
    }
}
