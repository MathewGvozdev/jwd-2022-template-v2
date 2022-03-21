package by.tc.task01.dao.builder;

import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.Appliance;

import java.util.Map;

public abstract class ApplianceBuilder implements Builder {

    private final Map<String, Object> specification;

    public ApplianceBuilder(String applianceInfoFromDB) {
        this.specification = DBParser.parseLineToSpecification(applianceInfoFromDB);
    }

    @Override
    public abstract Appliance build();

    protected String getStringValueFromDB(String criteriaName) {
        return (String) specification.get(criteriaName);
    }

    protected Integer getIntValueFromDB(String criteriaName) {
        return Integer.parseInt((String) specification.get(criteriaName));
    }

    protected Double getDoubleValueFromDB(String criteriaName) {
        return Double.parseDouble((String) specification.get(criteriaName));
    }
}
