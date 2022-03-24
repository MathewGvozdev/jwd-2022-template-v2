package by.tc.task01.entity.criteria;

import by.tc.task01.entity.Appliance;
import by.tc.task01.utility.CompareOption;
import by.tc.task01.utility.ValueComparator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria {

    private final String groupSearchName;
    private final Map<String, Object> criteria = new HashMap<>();
    private final CompareOption option;

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
        this.option = CompareOption.EQUAL;
    }

    public Criteria(String groupSearchName, CompareOption option) {
        this.groupSearchName = groupSearchName;
        this.option = option;
    }

    public boolean isMatches(Appliance appliance) {
        return countMatchesWithAppliance(appliance) == criteria.size();
    }

    private int countMatchesWithAppliance(Appliance appliance) {
        int counter = 0;
        Map<String, Object> specifications = appliance.getApplianceSpecification();
        for (Map.Entry<String, Object> criterion : criteria.entrySet()) {
            if (ValueComparator.compareByOption(specifications.get(criterion.getKey()), criterion.getValue(), option)) {
                counter++;
            }
        }
        return counter;
    }

    public void add(String specificationName, Object value) {
        criteria.put(specificationName, value);
    }

    public Set<String> getCriteriaNames() {
        return criteria.keySet();
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public Map<String, Object> getCriteria() {
        return criteria;
    }
}
