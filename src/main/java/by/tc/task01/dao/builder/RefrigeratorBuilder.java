package by.tc.task01.dao.builder;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;

public class RefrigeratorBuilder extends ApplianceBuilder {

    public RefrigeratorBuilder(String applianceInfoFromDB) {
        super(applianceInfoFromDB);
    }

    @Override
    public Appliance build() {
        Double price = getDoubleValueFromDB(SearchCriteria.Refrigerator.PRICE.toString());
        Integer powerConsumption = getIntValueFromDB(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString());
        Integer weight = getIntValueFromDB(SearchCriteria.Refrigerator.WEIGHT.toString());
        Integer freezerCapacity = getIntValueFromDB(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString());
        Double overallCapacity = getDoubleValueFromDB(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString());
        Integer height = getIntValueFromDB(SearchCriteria.Refrigerator.HEIGHT.toString());
        Integer width = getIntValueFromDB(SearchCriteria.Refrigerator.WIDTH.toString());

        return new Refrigerator.Builder(price, powerConsumption, weight, freezerCapacity, overallCapacity, height, width)
                .build();
    }
}
