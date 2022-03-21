package by.tc.task01.utility;

import by.tc.task01.exception.ValueComparatorException;

public final class ValueComparator {

    private ValueComparator() {
    }

    public static boolean compareByOption(Object dbValue, Object criteriaValue, CompareOption option) {
        return switch (option) {
            case EQUAL -> isEqual(dbValue, criteriaValue);
            case LESS -> isLess(dbValue, criteriaValue);
            case MORE -> isMore(dbValue, criteriaValue);
        };
    }

    public static boolean isEqual(Object dbValue, Object criteriaValue) {
        try {
            return compare(dbValue, criteriaValue) == 0;
        } catch (ValueComparatorException e) {
            return ((String) dbValue).equalsIgnoreCase((String) criteriaValue);
        }
    }

    public static boolean isLess(Object dbValue, Object criteriaValue) {
        try {
            return compare(dbValue, criteriaValue) < 0;
        } catch (ValueComparatorException e) {
            return ((String) dbValue).equalsIgnoreCase((String) criteriaValue);
        }
    }

    public static boolean isMore(Object dbValue, Object criteriaValue) {
        try {
            return compare(dbValue, criteriaValue) > 0;
        } catch (ValueComparatorException e) {
            return ((String) dbValue).equalsIgnoreCase((String) criteriaValue);
        }
    }

    private static int compare(Object dbValue, Object criteriaValue) throws ValueComparatorException {
        int result = -1;
        if (dbValue instanceof Integer) {
            result = Integer.compare((Integer) dbValue, Integer.parseInt(criteriaValue.toString()));
        } else if (dbValue instanceof Double) {
            result = Double.compare((Double) dbValue, Double.parseDouble(criteriaValue.toString()));
        } else if (dbValue instanceof String) {
            throw new ValueComparatorException();
        }
        return result;
    }
}
