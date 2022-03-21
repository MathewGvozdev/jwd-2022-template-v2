package by.tc.task01.utility;

import by.tc.task01.exception.ValueComparatorException;

public final class ValueComparator{

    public static boolean areEqual(Object o1, Object o2) {
        try {
            return compare(o1, o2) == 0;
        } catch (ValueComparatorException e) {
            return ((String) o1).equalsIgnoreCase((String) o2);
        }
    }

    private static int compare(Object o1, Object o2) throws ValueComparatorException {
        int result = -1;
        if (o1 instanceof Integer) {
            result = Integer.compare((Integer) o1, Integer.parseInt(o2.toString()));
        } else if (o1 instanceof Double) {
            result = Double.compare((Double) o1, Double.parseDouble(o2.toString()));
        } else if (o1 instanceof String) {
            throw new ValueComparatorException();
        }
        return result;
    }
}
