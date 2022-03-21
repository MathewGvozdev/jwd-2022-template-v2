package by.tc.task01.dao.builder;

import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

import static by.tc.task01.dao.parser.DBParser.*;

public class LaptopBuilder implements ApplianceBuilder{

    private final String specificationFromDB;

    public LaptopBuilder(String specificationFromDB) {
        this.specificationFromDB = specificationFromDB;
    }

    @Override
    public Appliance build() {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(specificationFromDB);

        Double price = objToDouble(specifications, SearchCriteria.Laptop.PRICE.toString());
        Double batteryCapacity = objToDouble(specifications, SearchCriteria.Laptop.BATTERY_CAPACITY.toString());
        String os = objToString(specifications, SearchCriteria.Laptop.OS.toString());
        Integer memoryRom = objToInt(specifications, SearchCriteria.Laptop.MEMORY_ROM.toString());
        Integer systemMemory = objToInt(specifications, SearchCriteria.Laptop.SYSTEM_MEMORY.toString());
        Double cpu = objToDouble(specifications, SearchCriteria.Laptop.CPU.toString());
        Integer displayInches = objToInt(specifications, SearchCriteria.Laptop.DISPLAY_INCHES.toString());

        return new Laptop.Builder(price, batteryCapacity, memoryRom, systemMemory, cpu, displayInches)
                .os(os)
                .build();
    }
}
