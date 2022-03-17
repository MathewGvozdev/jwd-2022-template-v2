package by.tc.task01.dao.utility;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class CriteriaCounter {

    private CriteriaCounter() {
    }

    public static int countSearchedCriteria(Criteria criteria, Appliance appliance) {
        int counter = 0;
        Map<String, Object> specifications = getApplianceSpecifications(appliance);
        Map<String, Object> searchCriteria = criteria.getCriteria();
        for (Map.Entry<String, Object> specification : specifications.entrySet()) {
            if (searchCriteria.containsKey(specification.getKey()) &&
                    areEqualByValue(searchCriteria.get(specification.getKey()), specification.getValue())) {
                counter++;
            }
        }
        return counter;
    }

    private static Map<String, Object> getApplianceSpecifications(Appliance appliance) {
        Map<String, Object> map = new HashMap<>();
        try {
            putFieldsOfParentClass(appliance, map);
            putFields(appliance, map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
        return map;
    }

    private static void putFields(Appliance appliance, Map<String, Object> map) throws IllegalAccessException {
        Field[] declaredFields = appliance.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(appliance);
            String specificationName = transformCamelCaseToSnail(declaredField);
            map.put(specificationName, value);
        }
    }

    private static void putFieldsOfParentClass(Appliance appliance, Map<String, Object> map) throws IllegalAccessException {
        Field[] superDeclaredFields = appliance.getClass().getSuperclass().getDeclaredFields();
        for (Field superDeclaredField : superDeclaredFields) {
            superDeclaredField.setAccessible(true);
            Object value = superDeclaredField.get(appliance);
            String specificationName = transformCamelCaseToSnail(superDeclaredField);
            map.put(specificationName, value);
        }
    }

    private static String transformCamelCaseToSnail(Field field) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return field.getName().replaceAll(regex, replacement).toUpperCase();
    }

    private static boolean areEqualByValue(Object criteriaValue, Object applianceValue) {
        try {
            return Integer.parseInt(criteriaValue.toString()) == Double.parseDouble(applianceValue.toString());
        } catch (Exception e) {
            return criteriaValue.equals(applianceValue);
        }
    }
}
