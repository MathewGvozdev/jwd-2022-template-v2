package by.tc.task01.service.impl.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.lang.reflect.Field;
import java.util.*;

public class CriteriaValidator {

    private static final CriteriaValidator INSTANCE = new CriteriaValidator();

    public ValidationResult isValid(Criteria criteria) {
        ValidationResult validationResult = new ValidationResult();
        String groupSearchName = criteria.getGroupSearchName();
        Set<String> criteriaNames = criteria.getCriteriaNames();

        for (Class<?> enumClass : SearchCriteria.class.getDeclaredClasses()) {
            Set<String> enumFields = new HashSet<>();
            if (enumClass.getSimpleName().equals(groupSearchName)) {
                int initialEnumFieldsSize = getInitialSizeOfEnumFields(enumClass, enumFields);
                enumFields.addAll(criteriaNames);
                if (isSizeChanged(enumFields, initialEnumFieldsSize)) {
                    validationResult.add(new Error("criteria.validator",
                            "Field wasn't find in " + enumClass.getSimpleName() + ". Check criteria correctness"));
                }
            }
        }
        return validationResult;
    }

    private boolean isSizeChanged(Set<String> enumFields, int initialEnumFieldsSize) {
        return !(enumFields.size() == initialEnumFieldsSize);
    }

    private int getInitialSizeOfEnumFields(Class<?> enumClass, Set<String> enumFields) {
        for (Field enumField : enumClass.getDeclaredFields()) {
            enumFields.add(enumField.getName());
        }
        return enumFields.size();
    }

    public static CriteriaValidator getInstance() {
        return INSTANCE;
    }
}
