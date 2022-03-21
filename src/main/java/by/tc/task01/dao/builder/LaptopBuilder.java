package by.tc.task01.dao.builder;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.SearchCriteria;

public class LaptopBuilder extends ApplianceBuilder {

    public LaptopBuilder(String applianceInfoFromDB) {
        super(applianceInfoFromDB);
    }

    @Override
    public Appliance build() {
        Double price = getDoubleValueFromDB(SearchCriteria.Laptop.PRICE.toString());
        Double batteryCapacity = getDoubleValueFromDB(SearchCriteria.Laptop.BATTERY_CAPACITY.toString());
        String os = getStringValueFromDB(SearchCriteria.Laptop.OS.toString());
        Integer memoryRom = getIntValueFromDB(SearchCriteria.Laptop.MEMORY_ROM.toString());
        Integer systemMemory = getIntValueFromDB(SearchCriteria.Laptop.SYSTEM_MEMORY.toString());
        Double cpu = getDoubleValueFromDB(SearchCriteria.Laptop.CPU.toString());
        Integer displayInches = getIntValueFromDB(SearchCriteria.Laptop.DISPLAY_INCHES.toString());

        return new Laptop.Builder(price, batteryCapacity, memoryRom, systemMemory, cpu, displayInches)
                .os(os)
                .build();
    }
}
