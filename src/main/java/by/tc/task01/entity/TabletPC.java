package by.tc.task01.entity;

import java.util.Objects;

public class TabletPC extends Appliance {

    private final Integer batteryCapacity;
    private final Integer displayInches;
    private final Integer memoryRom;
    private final Integer flashMemoryCapacity;
    private final String color;

    public TabletPC(Builder builder) {
        super(builder.price);
        batteryCapacity = builder.batteryCapacity;
        displayInches = builder.displayInches;
        memoryRom = builder.memoryRom;
        flashMemoryCapacity = builder.flashMemoryCapacity;
        color = builder.color;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public Integer getDisplayInches() {
        return displayInches;
    }

    public Integer getMemoryRom() {
        return memoryRom;
    }

    public Integer getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabletPC tabletPC = (TabletPC) o;
        return Objects.equals(batteryCapacity, tabletPC.batteryCapacity) &&
                Objects.equals(displayInches, tabletPC.displayInches) &&
                Objects.equals(memoryRom, tabletPC.memoryRom) &&
                Objects.equals(flashMemoryCapacity, tabletPC.flashMemoryCapacity) &&
                Objects.equals(color, tabletPC.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
    }

    @Override
    public String toString() {
        return String.format("%s:\n%s = %d\n%s = %d\n%s = %d\n%s = %d\n%s = %s\n%s = $%.2f\n",
                this.getClass().getSimpleName(),
                "BATTERY CAPACITY", batteryCapacity,
                "DISPLAY INCHES", displayInches,
                "MEMORY ROM", memoryRom,
                "FLASH MEMORY CAPACITY", flashMemoryCapacity,
                "COLOR", color.toUpperCase(),
                "PRICE", getPrice());
    }

    public static class Builder {

        private final Double price;
        private final Integer batteryCapacity;
        private final Integer displayInches;
        private final Integer memoryRom;
        private final Integer flashMemoryCapacity;
        private String color = "Gray";

        public Builder(Double price,
                       Integer batteryCapacity,
                       Integer displayInches,
                       Integer memoryRom,
                       Integer flashMemoryCapacity) {
            this.price = price;
            this.batteryCapacity = batteryCapacity;
            this.displayInches = displayInches;
            this.memoryRom = memoryRom;
            this.flashMemoryCapacity = flashMemoryCapacity;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public TabletPC build() {
            return new TabletPC(this);
        }
    }
}
