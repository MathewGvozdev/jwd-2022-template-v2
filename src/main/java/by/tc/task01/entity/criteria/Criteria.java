package by.tc.task01.entity.criteria;

import by.tc.task01.entity.Appliance;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria {

    private final String groupSearchName;
    private final Map<String, Object> searchCriteria = new HashMap<String, Object>();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public boolean isMatches(Appliance appliance) {
        return countMatchesWithAppliance(appliance) == searchCriteria.size();
    }

    private int countMatchesWithAppliance(Appliance appliance) {
        int counter = 0;
        Map<String, Object> specifications = appliance.getApplianceSpecifications();
        for (Map.Entry<String, Object> criterion : searchCriteria.entrySet()) {
            if (areEqualByValue(specifications.get(criterion.getKey()), criterion.getValue())) {
                counter++;
            }
        }
        return counter;
    }

    private boolean areEqualByValue(Object criteriaValue, Object applianceValue) {
        try {
            return Double.parseDouble(criteriaValue.toString()) == Integer.parseInt(applianceValue.toString());
        } catch (NumberFormatException e) {
            try {
                return ((String) criteriaValue).equalsIgnoreCase((String) applianceValue);
            } catch (ClassCastException e2) {
                return criteriaValue.equals(applianceValue);
            }
        }
    }

    public void add(String specificationName, Object value) {
        searchCriteria.put(specificationName, value);
    }

    public Set<String> getCriteriaNames() {
        return searchCriteria.keySet();
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public Map<String, Object> getCriteria() {
        return searchCriteria;
    }
}
