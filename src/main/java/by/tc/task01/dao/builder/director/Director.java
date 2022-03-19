package by.tc.task01.dao.builder.director;

import by.tc.task01.dao.builder.*;
import by.tc.task01.exception.ApplianceBuilderException;
import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.*;

public class Director {

    private static final Director INSTANCE = new Director();

    private Director(){
    }

    public Appliance build(String lineFromDB) {
        String applianceName = DBParser.defineApplianceGroup(lineFromDB);
        return switch (applianceName) {
            case "Laptop" -> new LaptopBuilder(lineFromDB).build();
            case "Oven" -> new OvenBuilder(lineFromDB).build();
            case "Refrigerator" -> new RefrigeratorBuilder(lineFromDB).build();
            case "Speakers" -> new SpeakersBuilder(lineFromDB).build();
            case "TabletPC" -> new TabletPCBuilder(lineFromDB).build();
            case "VacuumCleaner" -> new VacuumCleanerBuilder(lineFromDB).build();
            default -> throw new ApplianceBuilderException();
        };
    }

    public static Director getInstance() {
        return INSTANCE;
    }
}
