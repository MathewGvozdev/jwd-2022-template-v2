package by.tc.task01.dao.builder;

import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

import static by.tc.task01.dao.parser.DBParser.objToDouble;
import static by.tc.task01.dao.parser.DBParser.objToInt;

public class RefrigeratorBuilder implements ApplianceBuilder {

    private final String specificationFromDB;

    public RefrigeratorBuilder(String specificationFromDB) {
        this.specificationFromDB = specificationFromDB;
    }

    @Override
    public Appliance build() {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(specificationFromDB);

        Double price = objToDouble(specifications, SearchCriteria.Appliance.PRICE.toString());
        Integer powerConsumption = objToInt(specifications, SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString());
        Integer weight = objToInt(specifications, SearchCriteria.Refrigerator.WEIGHT.toString());
        Integer freezerCapacity = objToInt(specifications, SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString());
        Double overallCapacity = objToDouble(specifications, SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString());
        Integer height = objToInt(specifications, SearchCriteria.Refrigerator.HEIGHT.toString());
        Integer width = objToInt(specifications, SearchCriteria.Refrigerator.WIDTH.toString());

        return new Refrigerator.Builder(price, powerConsumption, weight, freezerCapacity, overallCapacity, height, width)
                .build();
    }
}
