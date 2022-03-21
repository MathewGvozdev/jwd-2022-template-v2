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
                for (Field enumField : enumClass.getDeclaredFields()) {
                    enumFields.add(enumField.getName());
                }
                int initialEnumFieldsSize = enumFields.size();
                enumFields.addAll(criteriaNames);
                if (!(enumFields.size() == initialEnumFieldsSize)) {
                    validationResult.add(new Error("criteria.validator",
                            "Field wasn't find in " + enumClass.getSimpleName() + ". Check criteria correctness"));
                }
            }
        }
        return validationResult;
    }

    public static CriteriaValidator getInstance() {
        return INSTANCE;
    }
}
