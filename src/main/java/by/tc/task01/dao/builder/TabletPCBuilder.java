package by.tc.task01.dao.builder;

import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

import static by.tc.task01.dao.parser.DBParser.*;

public class TabletPCBuilder implements ApplianceBuilder{

    private final String specificationFromDB;

    public TabletPCBuilder(String specificationFromDB) {
        this.specificationFromDB = specificationFromDB;
    }

    @Override
    public Appliance build() {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(specificationFromDB);

        Double price = objToDouble(specifications, SearchCriteria.Appliance.PRICE.toString());
        Integer batteryCapacity = objToInt(specifications, SearchCriteria.TabletPC.BATTERY_CAPACITY.toString());
        Integer displayInches = objToInt(specifications, SearchCriteria.TabletPC.DISPLAY_INCHES.toString());
        Integer memoryRom = objToInt(specifications, SearchCriteria.TabletPC.MEMORY_ROM.toString());
        Integer flashMemoryCapacity = objToInt(specifications, SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString());
        String color = objToString(specifications, SearchCriteria.TabletPC.COLOR.toString());

        return new TabletPC.Builder(price, batteryCapacity,displayInches, memoryRom, flashMemoryCapacity)
                .color(color)
                .build();
    }
}
