package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.lang.reflect.Field;
import java.util.Map;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {
		boolean isValid = true;
		Map<String, Object> searchCriteria = criteria.getCriteria();
		for (Map.Entry<String, Object> specification : searchCriteria.entrySet()) {
			enumLoop:
			for (Class<?> enumClass : SearchCriteria.class.getDeclaredClasses()) {
				for (Field enumField : enumClass.getDeclaredFields()) {
					if (enumField.getName().equals(specification.getKey())) {
						isValid = true;
						break enumLoop;
					} else {
						isValid = false;
					}
				}
			}
		}
		return isValid;
	}
}
