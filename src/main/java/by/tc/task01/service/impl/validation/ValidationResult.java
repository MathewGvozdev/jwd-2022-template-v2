package by.tc.task01.service.impl.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private final List<Error> errors = new ArrayList<>();

    public void add(Error error) {
        this.errors.add(error);
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    public List<Error> getErrors() {
        return errors;
    }
}
