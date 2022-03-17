package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

    public static void print(List<Appliance> appliances) {
        if (appliances.isEmpty()) {
            System.out.println("Didn't find\n");
        } else {
            for (Appliance appliance : appliances) {
                System.out.println(appliance);
            }
        }
    }
}
