package by.tc.task01.entity.builder;

import by.tc.task01.entity.Oven;

public interface OvenBuilder extends ApplianceBuilder {

    Oven.Builder powerConsumption(Integer batteryCapacity);

    Oven.Builder weight(Integer os);

    Oven.Builder capacity(Integer memoryRom);

    Oven.Builder depth(Integer systemMemory);

    Oven.Builder height(Double cpu);

    Oven.Builder width(Double displayInches);
}
