package by.tc.task01.entity.builder;

import by.tc.task01.dao.utility.DBParser;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class Director {

    public Appliance buildAppliance(String info) {
        String applianceName = DBParser.defineApplianceGroup(info);
        return switch (applianceName) {
            case "Laptop" -> buildLaptop(info);
            case "Oven" -> buildOven(info);
            case "Refrigerator" -> buildRefrigerator(info);
            case "Speakers" -> buildSpeakers(info);
            case "TabletPC" -> buildTabletPC(info);
            case "VacuumCleaner" -> buildVacuumCleaner(info);
            default -> throw new RuntimeException();
        };
    }

    private Laptop buildLaptop(String info) {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(info);
        return new Laptop.Builder()
                .price(DBParser.toDouble(specifications, SearchCriteria.Laptop.PRICE.toString()))
                .batteryCapacity(DBParser.toDouble(specifications, SearchCriteria.Laptop.BATTERY_CAPACITY.toString()))
                .os(DBParser.toString(specifications, SearchCriteria.Laptop.OS.toString()))
                .memoryRom(DBParser.toInt(specifications, SearchCriteria.Laptop.MEMORY_ROM.toString()))
                .systemMemory(DBParser.toInt(specifications, SearchCriteria.Laptop.SYSTEM_MEMORY.toString()))
                .cpu(DBParser.toDouble(specifications, SearchCriteria.Laptop.CPU.toString()))
                .displayInches(DBParser.toInt(specifications, SearchCriteria.Laptop.DISPLAY_INCHES.toString()))
                .build();
    }

    private Oven buildOven(String info) {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(info);
        return new Oven.Builder()
                .price(DBParser.toDouble(specifications, SearchCriteria.Oven.PRICE.toString()))
                .powerConsumption(DBParser.toInt(specifications, SearchCriteria.Oven.POWER_CONSUMPTION.toString()))
                .weight(DBParser.toInt(specifications, SearchCriteria.Oven.WEIGHT.toString()))
                .capacity(DBParser.toInt(specifications, SearchCriteria.Oven.CAPACITY.toString()))
                .depth(DBParser.toInt(specifications, SearchCriteria.Oven.DEPTH.toString()))
                .height(DBParser.toDouble(specifications, SearchCriteria.Oven.HEIGHT.toString()))
                .width(DBParser.toDouble(specifications, SearchCriteria.Oven.WIDTH.toString()))
                .build();
    }

    private Refrigerator buildRefrigerator(String info) {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(info);
        return new Refrigerator.Builder()
                .price(DBParser.toDouble(specifications, SearchCriteria.Refrigerator.PRICE.toString()))
                .powerConsumption(DBParser.toInt(specifications, SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()))
                .weight(DBParser.toInt(specifications, SearchCriteria.Refrigerator.WEIGHT.toString()))
                .freezerCapacity(DBParser.toInt(specifications, SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()))
                .overallCapacity(DBParser.toDouble(specifications, SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()))
                .height(DBParser.toInt(specifications, SearchCriteria.Refrigerator.HEIGHT.toString()))
                .width(DBParser.toInt(specifications, SearchCriteria.Refrigerator.WIDTH.toString()))
                .build();
    }

    private Speakers buildSpeakers(String info) {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(info);
        return new Speakers.Builder()
                .price(DBParser.toDouble(specifications, SearchCriteria.Speakers.PRICE.toString()))
                .powerConsumption(DBParser.toInt(specifications, SearchCriteria.Speakers.POWER_CONSUMPTION.toString()))
                .numberOfSpeakers(DBParser.toInt(specifications, SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()))
                .frequencyRange(DBParser.toString(specifications, SearchCriteria.Speakers.FREQUENCY_RANGE.toString()))
                .cordLength(DBParser.toInt(specifications, SearchCriteria.Speakers.CORD_LENGTH.toString()))
                .build();
    }

    private TabletPC buildTabletPC(String info) {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(info);
        return new TabletPC.Builder()
                .price(DBParser.toDouble(specifications, SearchCriteria.TabletPC.PRICE.toString()))
                .batteryCapacity(DBParser.toInt(specifications, SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()))
                .displayInches(DBParser.toInt(specifications, SearchCriteria.TabletPC.DISPLAY_INCHES.toString()))
                .memoryRom(DBParser.toInt(specifications, SearchCriteria.TabletPC.MEMORY_ROM.toString()))
                .flashMemoryCapacity(DBParser.toInt(specifications, SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()))
                .color(DBParser.toString(specifications, SearchCriteria.TabletPC.COLOR.toString()))
                .build();
    }

    private VacuumCleaner buildVacuumCleaner(String info) {
        Map<String, Object> specifications = DBParser.parseLineToSpecification(info);
        return new VacuumCleaner.Builder()
                .price(DBParser.toDouble(specifications, SearchCriteria.VacuumCleaner.PRICE.toString()))
                .powerConsumption(DBParser.toInt(specifications, SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()))
                .filterType(DBParser.toString(specifications, SearchCriteria.VacuumCleaner.FILTER_TYPE.toString()))
                .bagType(DBParser.toString(specifications, SearchCriteria.VacuumCleaner.BAG_TYPE.toString()))
                .wandType(DBParser.toString(specifications, SearchCriteria.VacuumCleaner.WAND_TYPE.toString()))
                .motorSpeedRegulation(DBParser.toInt(specifications, SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()))
                .cleaningWidth(DBParser.toInt(specifications, SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()))
                .build();
    }
}
