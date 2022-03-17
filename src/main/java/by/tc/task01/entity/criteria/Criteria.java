package by.tc.task01.entity.criteria;

import by.tc.task01.entity.Laptop;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

    private String groupSearchName;
    private Map<String, Object> criteria = new HashMap<String, Object>();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(String searchCriteria, Object value) {
        if (searchCriteria.equals(SearchCriteria.Laptop.OS.toString()) ||
                searchCriteria.equals(SearchCriteria.Speakers.FREQUENCY_RANGE.toString()) ||
                searchCriteria.equals(SearchCriteria.TabletPC.COLOR.toString()) ||
                searchCriteria.equals(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString()) ||
                searchCriteria.equals(SearchCriteria.VacuumCleaner.WAND_TYPE.toString()) ||
                searchCriteria.equals(SearchCriteria.VacuumCleaner.BAG_TYPE.toString())) {
            criteria.put(searchCriteria, ((String) value).toUpperCase());
        } else {
            criteria.put(searchCriteria, value);
        }
    }

    public Map<String, Object> getCriteria() {
        return criteria;
    }
}
