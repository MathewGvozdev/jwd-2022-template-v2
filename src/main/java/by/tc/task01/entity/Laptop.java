package by.tc.task01.entity;

import java.util.Objects;

public class Laptop extends Appliance {

    private final Double batteryCapacity;
    private final String os;
    private final Integer memoryRom;
    private final Integer systemMemory;
    private final Double cpu;
    private final Integer displayInches;

    public Laptop(Builder builder) {
        super(builder.price);
        batteryCapacity = builder.batteryCapacity;
        os = builder.os;
        memoryRom = builder.memoryRom;
        systemMemory = builder.systemMemory;
        cpu = builder.cpu;
        displayInches = builder.displayInches;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(batteryCapacity, laptop.batteryCapacity) &&
                Objects.equals(os, laptop.os) &&
                Objects.equals(memoryRom, laptop.memoryRom) &&
                Objects.equals(systemMemory, laptop.systemMemory) &&
                Objects.equals(cpu, laptop.cpu) &&
                Objects.equals(displayInches, laptop.displayInches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\n" +
                String.format("BATTERY CAPACITY = %.1f\n", batteryCapacity) +
                String.format("OS = %s\n", os.toUpperCase()) +
                String.format("MEMORY ROM = %d\n", memoryRom) +
                String.format("SYSTEM MEMORY = %d\n", systemMemory) +
                String.format("CPU = %.1f\n", cpu) +
                String.format("DISPLAY INCHES = %d\n", displayInches) +
                String.format("PRICE = $%.2f\n", getPrice());
    }

    public static class Builder {

        private final Double price;
        private final Double batteryCapacity;
        private String os = "Without OS";
        private final Integer memoryRom;
        private final Integer systemMemory;
        private final Double cpu;
        private final Integer displayInches;

        public Builder(Double price,
                       Double batteryCapacity,
                       Integer memoryRom,
                       Integer systemMemory,
                       Double cpu,
                       Integer displayInches) {
            this.price = price;
            this.batteryCapacity = batteryCapacity;
            this.memoryRom = memoryRom;
            this.systemMemory = systemMemory;
            this.cpu = cpu;
            this.displayInches = displayInches;
        }

        public Builder os(String os) {
            this.os = os;
            return this;
        }

        public Laptop build() {
            return new Laptop(this);
        }
    }
}
