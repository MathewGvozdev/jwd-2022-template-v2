package by.tc.task01.entity;

import by.tc.task01.exception.ApplianceSpecificationException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class Appliance {

    private Double price;

    public Appliance(Double price) {
        this.price = price;
    }

    public Map<String, Object> getApplianceSpecification() {
        Map<String, Object> specification = new HashMap<>();
        try {
            putFieldsOfParentClass(specification);
            putFieldsOfAppliance(specification);
        } catch (IllegalAccessException e) {
            throw new ApplianceSpecificationException();
        }
        return specification;
    }

    private void putFieldsOfAppliance(Map<String, Object> specification) throws IllegalAccessException {
        Field[] declaredFields = this.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(this);
            String specificationName = transformCamelCaseToSnail(declaredField);
            specification.put(specificationName, value);
        }
    }

    private void putFieldsOfParentClass(Map<String, Object> specification) throws IllegalAccessException {
        Field[] superDeclaredFields = this.getClass().getSuperclass().getDeclaredFields();
        for (Field superDeclaredField : superDeclaredFields) {
            superDeclaredField.setAccessible(true);
            Object value = superDeclaredField.get(this);
            String specificationName = transformCamelCaseToSnail(superDeclaredField);
            specification.put(specificationName, value);
        }
    }

    private String transformCamelCaseToSnail(Field field) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return field.getName().replaceAll(regex, replacement).toUpperCase();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
