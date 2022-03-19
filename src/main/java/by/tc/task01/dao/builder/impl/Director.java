package by.tc.task01.dao.builder.impl;

import by.tc.task01.dao.builder.*;
import by.tc.task01.exception.ApplianceBuilderException;
import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.*;

public class Director {

    private static final Director INSTANCE = new Director();

    private Director(){
    }

    public Appliance build(ApplianceBuilder builder) {
        return builder.build();
    }

    public ApplianceBuilder defineBuilderFromDB(String lineFromDB) {
        String applianceName = DBParser.defineApplianceGroup(lineFromDB);
        return switch (applianceName) {
            case "Laptop" -> new LaptopBuilder(lineFromDB);
            case "Oven" -> new OvenBuilder(lineFromDB);
            case "Refrigerator" -> new RefrigeratorBuilder(lineFromDB);
            case "Speakers" -> new SpeakersBuilder(lineFromDB);
            case "TabletPC" -> new TabletPCBuilder(lineFromDB);
            case "VacuumCleaner" -> new VacuumCleanerBuilder(lineFromDB);
            default -> throw new ApplianceBuilderException();
        };
    }

    public static Director getInstance() {
        return INSTANCE;
    }
}
