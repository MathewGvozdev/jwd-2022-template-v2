package by.tc.task01.dao.builder;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria;

public class TabletPCBuilder extends ApplianceBuilder {

    public TabletPCBuilder(String applianceInfoFromDB) {
        super(applianceInfoFromDB);
    }

    @Override
    public Appliance build() {
        Double price = getDoubleValueFromDB(SearchCriteria.TabletPC.PRICE.toString());
        Integer batteryCapacity = getIntValueFromDB(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString());
        Integer displayInches = getIntValueFromDB(SearchCriteria.TabletPC.DISPLAY_INCHES.toString());
        Integer memoryRom = getIntValueFromDB(SearchCriteria.TabletPC.MEMORY_ROM.toString());
        Integer flashMemoryCapacity = getIntValueFromDB(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString());
        String color = getStringValueFromDB(SearchCriteria.TabletPC.COLOR.toString());

        return new TabletPC.Builder(price, batteryCapacity, displayInches, memoryRom, flashMemoryCapacity)
                .color(color)
                .build();
    }
}
