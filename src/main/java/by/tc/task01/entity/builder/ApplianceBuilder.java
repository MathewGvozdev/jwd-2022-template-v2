package by.tc.task01.entity.builder;

import by.tc.task01.entity.Appliance;

public interface ApplianceBuilder {

    ApplianceBuilder price(Double price);

    Appliance build();
}
