package by.tc.task01.entity;

import by.tc.task01.entity.builder.TabletPCBuilder;
import by.tc.task01.entity.criteria.SearchCriteria;

public class TabletPC extends Appliance{

    private Integer batteryCapacity;
    private Integer displayInches;
    private Integer memoryRom;
    private Integer flashMemoryCapacity;
    private String color;

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
    public String toString() {
        return this.getClass().getSimpleName() + ":\n" +
                String.format("%s = %d\n", SearchCriteria.TabletPC.BATTERY_CAPACITY, batteryCapacity) +
                String.format("%s = %d\n", SearchCriteria.TabletPC.DISPLAY_INCHES, displayInches) +
                String.format("%s = %d\n", SearchCriteria.TabletPC.MEMORY_ROM, memoryRom) +
                String.format("%s = %d\n", SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY, flashMemoryCapacity) +
                String.format("%s = %s\n", SearchCriteria.TabletPC.COLOR, color);
    }

    public static class Builder implements TabletPCBuilder {
        private final TabletPC tabletPC;

        public Builder(){
            tabletPC = new TabletPC();
        }

        @Override
        public Builder price(Double price){
            tabletPC.setPrice(price);
            return this;
        }

        @Override
        public Builder batteryCapacity(Integer batteryCapacity){
            tabletPC.batteryCapacity = batteryCapacity;
            return this;
        }

        @Override
        public Builder displayInches(Integer displayInches) {
            tabletPC.displayInches = displayInches;
            return this;
        }

        @Override
        public Builder memoryRom(Integer memoryRom) {
            tabletPC.memoryRom = memoryRom;
            return this;
        }

        @Override
        public Builder flashMemoryCapacity(Integer flashMemoryCapacity) {
            tabletPC.flashMemoryCapacity = flashMemoryCapacity;
            return this;
        }

        @Override
        public Builder color(String color) {
            tabletPC.color = color.toUpperCase();
            return this;
        }

        @Override
        public TabletPC build() {
            return tabletPC;
        }
    }
}
