package by.tc.task01.dao.builder;

import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

import static by.tc.task01.dao.parser.DBParser.objToDouble;
import static by.tc.task01.dao.parser.DBParser.objToInt;

public class OvenBuilder implements ApplianceBuilder{

    private final String specificationFromDB;

    public OvenBuilder(String specificationFromDB) {
        this.specificationFromDB = specificationFromDB;
    }

    @Override
    public Appliance build() {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(specificationFromDB);

        Double price = objToDouble(specifications, SearchCriteria.Appliance.PRICE.toString());
        Integer powerConsumption = objToInt(specifications, SearchCriteria.Oven.POWER_CONSUMPTION.toString());
        Integer weight = objToInt(specifications, SearchCriteria.Oven.WEIGHT.toString());
        Integer capacity = objToInt(specifications, SearchCriteria.Oven.CAPACITY.toString());
        Integer depth = objToInt(specifications, SearchCriteria.Oven.DEPTH.toString());
        Double height = objToDouble(specifications, SearchCriteria.Oven.HEIGHT.toString());
        Double width = objToDouble(specifications, SearchCriteria.Oven.WIDTH.toString());

        return new Oven.Builder(price, powerConsumption, weight, capacity, depth, height, width)
                .build();
    }
}
