package by.tc.task01.exception;

import by.tc.task01.service.impl.validation.Error;

import java.util.List;

public class CriteriaValidationException extends RuntimeException {

    private final List<Error> errors;

    public CriteriaValidationException(List<Error> errors) {
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public String getMessage() {
        StringBuilder message = new StringBuilder();
        for (Error error : errors) {
            message.append(error.getMessage()).append("\n");
        }
        return message.toString();
    }
}
