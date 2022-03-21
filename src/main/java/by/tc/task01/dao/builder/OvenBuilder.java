package by.tc.task01.dao.builder;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.SearchCriteria;

public class OvenBuilder extends ApplianceBuilder {

    public OvenBuilder(String applianceInfoFromDB) {
        super(applianceInfoFromDB);
    }

    @Override
    public Appliance build() {
        Double price = getDoubleValueFromDB(SearchCriteria.Oven.PRICE.toString());
        Integer powerConsumption = getIntValueFromDB(SearchCriteria.Oven.POWER_CONSUMPTION.toString());
        Integer weight = getIntValueFromDB(SearchCriteria.Oven.WEIGHT.toString());
        Integer capacity = getIntValueFromDB(SearchCriteria.Oven.CAPACITY.toString());
        Integer depth = getIntValueFromDB(SearchCriteria.Oven.DEPTH.toString());
        Double height = getDoubleValueFromDB(SearchCriteria.Oven.HEIGHT.toString());
        Double width = getDoubleValueFromDB(SearchCriteria.Oven.WIDTH.toString());

        return new Oven.Builder(price, powerConsumption, weight, capacity, depth, height, width)
                .build();
    }
}
