package by.tc.task01.dao.builder.director;

import by.tc.task01.dao.builder.*;
import by.tc.task01.exception.ApplianceBuilderException;
import by.tc.task01.dao.parser.DBParser;
import by.tc.task01.entity.*;

public class Director {

    private static final Director INSTANCE = new Director();

    private Director(){
    }

    public Appliance build(String applianceInfoFromDB) {
        String applianceGroup = DBParser.defineApplianceGroup(applianceInfoFromDB);
        return switch (applianceGroup) {
            case "Laptop" -> new LaptopBuilder(applianceInfoFromDB).build();
            case "Oven" -> new OvenBuilder(applianceInfoFromDB).build();
            case "Refrigerator" -> new RefrigeratorBuilder(applianceInfoFromDB).build();
            case "Speakers" -> new SpeakersBuilder(applianceInfoFromDB).build();
            case "TabletPC" -> new TabletPCBuilder(applianceInfoFromDB).build();
            case "VacuumCleaner" -> new VacuumCleanerBuilder(applianceInfoFromDB).build();
            default -> throw new ApplianceBuilderException();
        };
    }

    public static Director getInstance() {
        return INSTANCE;
    }
}
