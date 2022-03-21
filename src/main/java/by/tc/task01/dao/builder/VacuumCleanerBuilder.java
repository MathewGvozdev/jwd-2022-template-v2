package by.tc.task01.dao.builder;

import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

import static by.tc.task01.dao.parser.DBParser.*;

public class VacuumCleanerBuilder implements ApplianceBuilder{

    private final String specificationFromDB;

    public VacuumCleanerBuilder(String specificationFromDB) {
        this.specificationFromDB = specificationFromDB;
    }

    @Override
    public Appliance build() {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(specificationFromDB);

        Double price = objToDouble(specifications, SearchCriteria.VacuumCleaner.PRICE.toString());
        Integer powerConsumption = objToInt(specifications, SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString());
        String filterType = objToString(specifications, SearchCriteria.VacuumCleaner.FILTER_TYPE.toString());
        String bagType = objToString(specifications, SearchCriteria.VacuumCleaner.BAG_TYPE.toString());
        String wandType = objToString(specifications, SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
        Integer motorSpeedRegulation = objToInt(specifications, SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString());
        Integer cleaningWidth = objToInt(specifications, SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString());

        return new VacuumCleaner.Builder(price, powerConsumption, filterType, motorSpeedRegulation, cleaningWidth)
                .bagType(bagType)
                .wandType(wandType)
                .build();
    }
}
