package by.tc.task01.entity;

import by.tc.task01.entity.builder.LaptopBuilder;
import by.tc.task01.entity.criteria.SearchCriteria;

public class Laptop extends Appliance {

    private Double batteryCapacity;
    private String os;
    private Integer memoryRom;
    private Integer systemMemory;
    private Double cpu;
    private Integer displayInches;

    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public Integer getMemoryRom() {
        return memoryRom;
    }

    public Integer getSystemMemory() {
        return systemMemory;
    }

    public Double getCpu() {
        return cpu;
    }

    public Integer getDisplayInches() {
        return displayInches;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\n" +
                String.format("%s = %.1f\n", SearchCriteria.Laptop.BATTERY_CAPACITY, batteryCapacity) +
                String.format("%s = %s\n", SearchCriteria.Laptop.OS, os) +
                String.format("%s = %d\n", SearchCriteria.Laptop.MEMORY_ROM, memoryRom) +
                String.format("%s = %d\n", SearchCriteria.Laptop.SYSTEM_MEMORY, systemMemory) +
                String.format("%s = %.1f\n", SearchCriteria.Laptop.CPU, cpu) +
                String.format("%s = %d\n", SearchCriteria.Laptop.DISPLAY_INCHES, displayInches);
    }

    public static class Builder implements LaptopBuilder  {
        private final Laptop laptop;

        public Builder(){
            laptop = new Laptop();
        }

        @Override
        public Builder price(Double price){
            laptop.setPrice(price);
            return this;
        }

        @Override
        public Builder batteryCapacity(Double batteryCapacity){
            laptop.batteryCapacity = batteryCapacity;
            return this;
        }

        @Override
        public Builder os(String os) {
            laptop.os = os.toUpperCase();
            return this;
        }

        @Override
        public Builder memoryRom(Integer memoryRom) {
            laptop.memoryRom = memoryRom;
            return this;
        }

        @Override
        public Builder systemMemory(Integer systemMemory) {
            laptop.systemMemory = systemMemory;
            return this;
        }

        @Override
        public Builder cpu(Double cpu) {
            laptop.cpu = cpu;
            return this;
        }

        @Override
        public Builder displayInches(Integer displayInches) {
            laptop.displayInches = displayInches;
            return this;
        }

        @Override
        public Laptop build() {
            return laptop;
        }
    }
}
