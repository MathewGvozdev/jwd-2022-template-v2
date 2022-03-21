package by.tc.task01.dao.builder;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.SearchCriteria;

public class VacuumCleanerBuilder extends ApplianceBuilder {

    public VacuumCleanerBuilder(String applianceInfoFromDB) {
        super(applianceInfoFromDB);
    }

    @Override
    public Appliance build() {
        Double price = getDoubleValueFromDB(SearchCriteria.VacuumCleaner.PRICE.toString());
        Integer powerConsumption = getIntValueFromDB(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString());
        String filterType = getStringValueFromDB(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString());
        String bagType = getStringValueFromDB(SearchCriteria.VacuumCleaner.BAG_TYPE.toString());
        String wandType = getStringValueFromDB(SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
        Integer motorSpeedRegulation = getIntValueFromDB(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString());
        Integer cleaningWidth = getIntValueFromDB(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString());

        return new VacuumCleaner.Builder(price, powerConsumption, filterType, motorSpeedRegulation, cleaningWidth)
                .bagType(bagType)
                .wandType(wandType)
                .build();
    }
}
