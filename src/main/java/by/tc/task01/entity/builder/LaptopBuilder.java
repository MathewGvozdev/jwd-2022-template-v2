package by.tc.task01.entity.builder;

import by.tc.task01.entity.Laptop;

public interface LaptopBuilder extends ApplianceBuilder {

    Laptop.Builder batteryCapacity(Double batteryCapacity);

    Laptop.Builder os(String os);

    Laptop.Builder memoryRom(Integer memoryRom);

    Laptop.Builder systemMemory(Integer systemMemory);

    Laptop.Builder cpu(Double cpu);

    Laptop.Builder displayInches(Integer displayInches);
}
