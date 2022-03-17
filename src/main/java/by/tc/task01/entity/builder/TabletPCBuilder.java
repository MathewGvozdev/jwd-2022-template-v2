package by.tc.task01.entity.builder;

import by.tc.task01.entity.TabletPC;

public interface TabletPCBuilder extends ApplianceBuilder{

    TabletPC.Builder batteryCapacity(Integer batteryCapacity);

    TabletPC.Builder displayInches(Integer os);

    TabletPC.Builder memoryRom(Integer memoryRom);

    TabletPC.Builder flashMemoryCapacity(Integer systemMemory);

    TabletPC.Builder color(String cpu);
}
