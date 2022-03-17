package by.tc.task01.entity.builder;

import by.tc.task01.entity.Refrigerator;

public interface RefrigeratorBuilder extends ApplianceBuilder{

    Refrigerator.Builder powerConsumption(Integer batteryCapacity);

    Refrigerator.Builder weight(Integer os);

    Refrigerator.Builder freezerCapacity(Integer memoryRom);

    Refrigerator.Builder overallCapacity(Double systemMemory);

    Refrigerator.Builder height(Integer cpu);

    Refrigerator.Builder width(Integer displayInches);
}
