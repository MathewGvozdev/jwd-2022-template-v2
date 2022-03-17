package by.tc.task01.entity.builder;

import by.tc.task01.entity.Speakers;

public interface SpeakersBuilder extends ApplianceBuilder{

    Speakers.Builder powerConsumption(Integer batteryCapacity);

    Speakers.Builder numberOfSpeakers(Integer os);

    Speakers.Builder frequencyRange(String memoryRom);

    Speakers.Builder cordLength(Integer systemMemory);
}
