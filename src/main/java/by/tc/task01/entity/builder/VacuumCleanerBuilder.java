package by.tc.task01.entity.builder;

import by.tc.task01.entity.VacuumCleaner;

public interface VacuumCleanerBuilder extends ApplianceBuilder{

    VacuumCleaner.Builder powerConsumption(Integer batteryCapacity);

    VacuumCleaner.Builder filterType(String os);

    VacuumCleaner.Builder bagType(String memoryRom);

    VacuumCleaner.Builder wandType(String systemMemory);

    VacuumCleaner.Builder motorSpeedRegulation(Integer cpu);

    VacuumCleaner.Builder cleaningWidth(Integer displayInches);
}
